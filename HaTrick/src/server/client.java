package server;
import java.io.*;
import java.net.*;
import java.sql.Time;
import java.util.*;

class checkTimerTask extends TimerTask{
	client client;
	OutputStream toServer;
	public checkTimerTask(client client, OutputStream toServer) {
		// TODO Auto-generated constructor stub
		this.client=client;
		this.toServer=toServer;
	}

	@Override
	public void run() {
		if(client.is_connected(toServer)==false){
			System.out.printf("Server is closed\n");
			System.exit(0);
		}
		// TODO Auto-generated method stub
		
	}
	
}
class heartTimerTask extends TimerTask{
	client client;
	public heartTimerTask(client client) {
		// TODO Auto-generated constructor stub
		this.client=client;
	}

	@Override
	public void run() {
		try {
			if(client.is_connected(client.toServer)==true){
			byte b[]=new byte[20];
			client.toServer.write(b,0,20);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}
	
}
public class client {

	/**
	 * @param args
	 */
	 OutputStream toServer;
	 InputStream fromServer;
	public client(){
		try{
			//create a socket to connect to the server
			Socket socket=new Socket("localhost",8003);
			//create an output stream to send data to the server
			toServer=socket.getOutputStream();
			//create an input stream to receive data from the server
			fromServer=socket.getInputStream();
			checkTimerTask checktimertask=new checkTimerTask(this,toServer);
			heartTimerTask hearttimertask=new heartTimerTask(this);
			Timer checktimer=new Timer();
			Timer hearttimer=new Timer();
			checktimer.schedule(checktimertask, new Date(), 1000);
			hearttimer.schedule(hearttimertask, new Date(), 200);
			
			
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	boolean is_connected(OutputStream temp){//judge whether a connection is true
 		try{
 			byte b[]=new byte[20];
			temp.write(b,0,20);
 			temp.flush();
 			}
 			catch(Exception ex){
 				ex.printStackTrace();
 				return false;
 			}
 			return true;
 		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new client();
	}

}
