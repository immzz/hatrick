
package com.hatrick.server;

import java.io.*;
import java.net.*;
import java.sql.Time;
import java.util.*;


import com.hatrick.logic.ClientLogic;
import com.hatrick.logic.Hero;
import com.hatrick.logic.Operation;
import com.hatrick.logic.ServerLogic;



class CheckTimerTask extends TimerTask {
	Client client;
	OutputStream toServer;
	//ObjectOutputStream toServerObj;

	public CheckTimerTask(Client client, OutputStream toServer)
			throws IOException {
		// TODO Auto-generated constructor stub
		this.client = client;
		this.toServer = toServer;
		//this.toServerObj = new ObjectOutputStream(toServerObj);
	}

	@Override
	public void run() {
		if (client.is_connected(toServer) == false) {
			System.out.printf("Server is closed\n");
			System.exit(0);
		}
		// TODO Auto-generated method stub

	}

}

class HeartTimerTask extends TimerTask {
	Client client;

	public HeartTimerTask(Client client) {
		// TODO Auto-generated constructor stub
		this.client = client;
	}

	@Override
	public void run() {
		if (client.is_connected(client.toServer) == true) {
			// byte b[]=new byte[20];
			Message obj = new Message(Message.TYPE_HEART_BEAT,
					System.currentTimeMillis(), null);
			try {
				client.sendMessage(obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub

	}

}

public class Client {

	/**
	 * @param args
	 */
	static OutputStream toServer;
	static InputStream fromServer;

	public Client() {
		try {

			// create a socket to connect to the server
			Socket socket = new Socket("127.0.0.1",8000);
			// create an output stream to send data to the server
			toServer = socket.getOutputStream();
			// create an input stream to receive data from the server
			fromServer = socket.getInputStream();

			HandleRecv handlerecv = new HandleRecv();
			Thread recvthread = new Thread(handlerecv);
			recvthread.start();

			// timer are used for heart beat
			CheckTimerTask checktimertask = new CheckTimerTask(this, toServer);
			HeartTimerTask hearttimertask = new HeartTimerTask(this);
			Timer checktimer = new Timer();
			Timer hearttimer = new Timer();
			checktimer.schedule(checktimertask, new Date(), 1000);
			hearttimer.schedule(hearttimertask, new Date(), 1000);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void sendMessage(Serializable obj) throws Exception {
			
			Message msg = ( Message )obj;
			int type=msg.get_type();
			if(type!=1&&type!=2&&type!=3&&type!=4&&type!=5&&type!=6&&type!=7){
				System.out.println("Sending message type error\n");
				return ;
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); // 鏋勯�涓�釜瀛楄妭杈撳嚭娴�			
			ObjectOutputStream oos = new ObjectOutputStream(baos); // 鏋勯�涓�釜绫昏緭鍑烘祦
			// oos.writeObject(list); //鍐欒繖涓璞�			
			msg.set_time(System.currentTimeMillis());
			oos.writeObject(obj); // 鍐欒繖涓璞�			

			byte[] buf = baos.toByteArray(); // 浠庤繖涓湴灞傚瓧鑺傛祦涓妸浼犺緭鐨勬暟缁勭粰涓�釜鏂扮殑鏁扮�?
			int length=buf.length;
			//System.out.println("length: " + buf.length);
			byte[] buf_new=new byte[4+length];
			buf_new[0] = (byte) (length & 0xff);// 鏈�綆浣�? 
			buf_new[1] = (byte) ((length >> 8) & 0xff);// 娆′綆浣�  
			buf_new[2] = (byte) ((length>> 16) & 0xff);// 娆￠珮浣�? 
			buf_new[3] = (byte) (length>>> 24);// 鏈�珮浣�鏃犵鍙峰彸绉汇�   
			System.arraycopy(buf, 0,buf_new,4,length);
			oos.flush();
			toServer.write(buf_new, 0,length+4);
	}

	public static Serializable recvMessage() {
		byte[] buf = new byte[4096];
		int length;
		try {
			fromServer.read(buf,0,4);
			length= (buf[0] & 0xff) | ((buf[1] << 8) & 0xff00) // | 琛ㄧず瀹変綅鎴�? 
					| ((buf[2] << 24) >>> 8) | (buf[3] << 24);   
			fromServer.read(buf, 0,length);
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
			e.printStackTrace();
		} 
		return msg;
	}

	protected class HandleRecv implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try{
				Serializable obj = recvMessage();
				Message msg = ( Message ) obj;
				//System.out.println("type:"+msg.get_type());
				ClientLogic.handleMessage((Message) obj);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}

	}

	boolean is_connected(OutputStream temp) {// judge whether a connection is
												// true
		try {
			Message obj = new Message(Message.TYPE_HEART_BEAT,
					System.currentTimeMillis(), null);
			this.sendMessage(obj);
		} catch (Exception ex) {
			//ex.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();
	}

	public void auto_send_random() {
		// TODO Auto-generated method stub
		Message msg = new Message ( Message.TYPE_HERO, null, null);
		try {
			this.sendMessage(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
