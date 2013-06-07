
package com.hatrick.server;

import java.io.*;
import java.net.*;
import java.sql.Time;
import java.util.*;

import com.hatrick.logic.ServerLogic;

class Heart_beat implements Serializable {
	private long initial_clock;
	private int number;
	private long latest_clock;

	public Heart_beat() {
		initial_clock = System.currentTimeMillis();
		number = 0;
		latest_clock = initial_clock;
	}

	public long get_initial_clock() {
		return initial_clock;
	}

	public void set_initial_clock(long initial_clock) {
		this.initial_clock = initial_clock;
	}

	public int get_number() {
		return number;
	}

	public void set_number(int number) {
		this.number = number;
	}

	public long get_latest_clock() {
		return latest_clock;
	}

	public void set_latest_clock(long latest_clock) {
		this.latest_clock = latest_clock;
	}

	public double calculate() {
		long now = System.currentTimeMillis();
		return (now - latest_clock) * number * 1.0 / (now - initial_clock);
	}
}

class HandleAClient extends Thread {
	private Socket socket;// A connected socket
	private Machine_status status;
	private InetAddress ID;
	private InputStream input;
	private OutputStream output;

	// Construct a thread
	public HandleAClient(Socket socket, Machine_status status, InetAddress ID) {
		this.socket = socket;
		this.status = status;
		this.ID = ID;
	}

	public Socket getsocket() {
		return socket;
	}

	public InetAddress gethostaddress() {
		return ID;
	}

	public void setID(InetAddress client) {
		ID = client;
	}

	public Machine_status get_status() {
		return status;
	}
	public InputStream get_InputStream(){ 
		return input;
	}
	public OutputStream get_OutputStream(){
		return output;
	}
	public void reset(Socket socket) {
		this.socket = socket;
		try {
			this.input = socket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.output = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  void sendMessage(Serializable obj) {
		try {
			
			Message msg = ( Message ) obj;
			int type=msg.get_type();
			if(type!=1&&type!=2&&type!=3&&type!=4&&type!=5&&type!=6&&type!=7){
				System.out.println("Sending message type error\n");
				return ;
			}
			msg.set_time(System.currentTimeMillis());
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); // 鏋勯�涓�釜瀛楄妭杈撳嚭娴�			
			ObjectOutputStream oos = new ObjectOutputStream(baos); // 鏋勯�涓�釜绫昏緭鍑烘祦
			oos.writeObject(obj); //鍐欒繖涓璞�			oos.writeObject(obj); // 鍐欒繖涓璞�			
			byte[] buf = baos.toByteArray(); // 浠庤繖涓湴灞傚瓧鑺傛祦涓妸浼犺緭鐨勬暟缁勭粰涓�釜鏂扮殑鏁扮粍
			int length=buf.length;
			byte[] buf_new=new byte[4+length];
			buf_new[0] = (byte) (length & 0xff);// 最低位   
			buf_new[1] = (byte) ((length >> 8) & 0xff);// 次低位   
			buf_new[2] = (byte) ((length>> 16) & 0xff);// 次高位   
			buf_new[3] = (byte) (length>>> 24);// 最高位,无符号右移。   
			System.arraycopy(buf, 0,buf_new,4,length);
			oos.flush();
			output.write(buf_new, 0,length+4);
		} catch (Exception e) {
			
		}
	}

	public  Serializable recvMessage() {
		byte[] buf = new byte[4096];
		int length;
		try {
			input.read(buf,0,4);
			length= (buf[0] & 0xff) | ((buf[1] << 8) & 0xff00) // | 表示安位或   
					| ((buf[2] << 24) >>> 8) | (buf[3] << 24);   
			input.read(buf, 0,length);
			//System.out.println("a.length:"+a);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		ObjectInputStream ois;
		Message msg = null;
		try {
			ois = new ObjectInputStream(bais);
			msg = (Message) ois.readObject();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		return msg;
	}

	// Run the thread
	public void run() {
		// Create data input Streams
		
		try {
			output = socket.getOutputStream();
			input = socket.getInputStream();
			//System.out.printf("input");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// new a input
		
		while (true) {
			// System.out.printf("execute\n");
			try {
				// if(is_connected(new
				// ObjectOutputStream(socket.getOutputStream()))){
				Serializable obj = recvMessage();
				
				Message msg = (Message) obj;
				//System.out.println("input");
				//System.out.println(msg);
				//System.out.println( "recv a message type: "+ new Integer(msg.get_type()).toString());
				//System.out.println("type:"+msg.get_type());
				if (msg.get_type() == Message.TYPE_HEART_BEAT) {
					//System.out.printf("receive heart_beat\n");
					status.online = true;
					status.get_heart_beat().set_latest_clock(System.currentTimeMillis());
					status.get_heart_beat().set_number(
							status.get_heart_beat().get_number() + 1);
				} else {
					/******************************* 璋冪敤鎺ュ彛鎻愪氦鏀跺埌鐨勪俊鎭�********************************/
					ServerLogic.handleMessage((Message) obj);
					//System.out.println("recv a message type:"+msg.get_type());
					/*****************************************************************************/
				}
			} catch (Exception ex) {
				//ex.printStackTrace();
				continue;
			}
		}
	}
	// static public Message recvMessage(){
	// return new Message();
	// }
}
class Machine_status {
	Heart_beat heart_beat;
	boolean online;

	public Machine_status() {
		heart_beat = new Heart_beat();
		online = true;
	}

	public boolean get_online() {
		return online;
	}

	public Heart_beat get_heart_beat() {
		return heart_beat;
	}

	public void set_online(boolean online) {
		this.online = online;
	}

	public void set_heart_beat(Heart_beat temp) {
		heart_beat.set_number(temp.get_number());
		heart_beat.set_latest_clock(temp.get_latest_clock());
		heart_beat.set_initial_clock(temp.get_initial_clock());
	}
}

class newTimerTask extends TimerTask {
	Server server;

	public void setServer(Server server) {
		this.server = server;
	}

	public void run() {
		// TODO Auto-generated method stub
		server.judge();
	}
}

public class Server implements Runnable {

	/**
	 * @param args
	 */
	private long initial_clock;
	private static ArrayList<HandleAClient> array_thread = new ArrayList<HandleAClient>();

	public Server() {

	}

	@SuppressWarnings("deprecation")
	void judge() {
		for (int i = 0; i < array_thread.size(); i++) {
			double ratio = array_thread.get(i).get_status().get_heart_beat()
					.calculate();
			//System.out.println("ration:"+ratio);
			if (ratio > 10.0) {
				if (array_thread.get(i).get_status().get_online() == true) {
					array_thread.get(i).suspend();
					System.out.println(array_thread.get(i).gethostaddress()
							+ "is suspended\n");
				}
				array_thread.get(i).get_status().set_online(false);
				try {
					array_thread.get(i).get_InputStream().close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					array_thread.get(i).get_OutputStream().close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					array_thread.get(i).getsocket().close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void broadcast(Serializable obj) {
		for (int i = 0; i < array_thread.size(); i++) {
			if (array_thread.get(i).isAlive()) {
				//System.out.println("alive");
				array_thread.get(i).sendMessage(obj);
			}
			// if(array_thread.get(i).gethostaddress().equals(clientIP))break;
		}
		//System.out.println("broadcast");
		return;
	}
	public static void main(String[] args){
	Server ser = new Server();
		new Thread(ser).start();
	}
	
	@Override
	public void run() {

		initial_clock = System.currentTimeMillis();
		Timer timer = new Timer(true);
		newTimerTask timertask = new newTimerTask();
		timertask.setServer(this);
		timer.schedule(timertask, new Date(), 1000);

		try {
			// create a server socket
			ServerSocket serversocket = new ServerSocket(8000);
			int clientNo = 1;
			while (true) {
				Socket socket = serversocket.accept();
				System.out.printf("new a connection\n");
				InetAddress clientIP = socket.getInetAddress();
				int i = 0;
				for (i = 0; i < array_thread.size(); i++) {
					if (array_thread.get(i).gethostaddress().equals(clientIP))
						break;
				}
				if (i == array_thread.size()) {
					Machine_status status = new Machine_status();
					HandleAClient task = new HandleAClient(socket, status,
							socket.getInetAddress());
					array_thread.add(task);
					// Start the new thread
					task.start();
					// Increment clientNo
					clientNo++;
				} else {
					array_thread.get(i).get_status().set_online(true);
					array_thread.get(i).get_status()
							.set_heart_beat(new Heart_beat());
					array_thread.get(i).reset(socket);
					array_thread.get(i).resume();
					System.out.println(array_thread.get(i).gethostaddress()
							+ "is reconnected\n");
				}
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}

		// TODO Auto-generated method stub

	}

}
