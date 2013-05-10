package com.hatrick.server;

import java.io.*;
import java.net.*;
import java.sql.Time;
import java.util.*;

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

 class Message implements Serializable {

	public static final int TYPE_HEART_BEAT = 1;
	public static final int TYPE_OPERATION = 2;
	public static final int TYPE_HERO = 3;

	private int type;
	private Long time;
	private Serializable obj;

	Message(int type, Long time, Serializable obj) {
		this.set_obj(obj);
		this.set_time(time);
		this.set_type(type);
	}

	public void set_time(Long time) {
		this.time = time;
	}

	public void set_obj(Serializable obj) {
		this.obj = obj;
	}

	public void set_type(int type) {
		this.type = type;
	}

	public int get_type() {
		return type;
	}

	public Long get_time() {
		return time;
	}

	public Serializable get_obj() {
		return obj;
	}
}

class HandleAClient extends Thread {
	private Socket socket;// A connected socket
	private Machine_status status;
	private InetAddress ID;
	static InputStream input;
	static OutputStream output;

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

	public static void sendMessage(Serializable obj) {
		try {
			
			Message msg = ( Message ) obj;
			msg.set_time(System.currentTimeMillis());
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); // 构造一个字节输出流
			ObjectOutputStream oos = new ObjectOutputStream(baos); // 构造一个类输出流
			// oos.writeObject(list); //写这个对象
			oos.writeObject(obj); // 写这个对象
			byte[] buf = baos.toByteArray(); // 从这个地层字节流中把传输的数组给一个新的数组
			oos.flush();
			output.write(buf, 0, buf.length);
		} catch (Exception e) {
			
		}
	}

	public static Serializable recvMessage() {
		byte[] buf = new byte[4096];
		try {
			input.read(buf, 0, buf.length);
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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return msg;
	}

	// Run the thread
	public void run() {
		// Create data input Streams
		System.out.println("input");
		try {
			output = socket.getOutputStream();
			input = socket.getInputStream();
			System.out.printf("input");

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
				//System.out.println("type:"+msg.get_type());
				if (msg.get_type() == Message.TYPE_HEART_BEAT) {
					System.out.printf("receive heart_beat\n");
					status.online = true;
					status.get_heart_beat().set_latest_clock(msg.get_time());
					status.get_heart_beat().set_number(
							status.get_heart_beat().get_number() + 1);
				} else {
					/******************************* 调用接口提交收到的信息 ********************************/
					//handleMessage((Message) obj);
					System.out.println("recv a message type:"+msg.get_type());
					/*****************************************************************************/
				}
			} catch (Exception ex) {
				// ex.printStackTrace();
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
			if (ratio > 10.0) {
				if (array_thread.get(i).get_status().get_online() == true) {
					array_thread.get(i).suspend();
					System.out.println(array_thread.get(i).gethostaddress()
							+ "is suspended\n");
				}
				array_thread.get(i).get_status().set_online(false);
				try {
					array_thread.get(i).input.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					array_thread.get(i).output.close();
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

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// new Server();
	// }
	public static void broadcast(Serializable obj) {
		for (int i = 0; i < array_thread.size(); i++) {

			if (array_thread.get(i).isAlive()) {
				array_thread.get(i).sendMessage(obj);
			}
			// if(array_thread.get(i).gethostaddress().equals(clientIP))break;
		}
		return;
	}
//	public static void main(String[] args){
//		Server ser = new Server();
//		new Thread(ser).start();
//	}
	
	@Override
	public void run() {

		initial_clock = System.currentTimeMillis();
		Timer timer = new Timer(true);
		newTimerTask timertask = new newTimerTask();
		timertask.setServer(this);
		timer.schedule(timertask, new Date(), 1000);

		try {
			// create a server socket
			ServerSocket serversocket = new ServerSocket(8003);
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
