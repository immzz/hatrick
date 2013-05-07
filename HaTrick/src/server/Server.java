package server;
import java.io.*;
import java.net.*;
import java.sql.Time;
import java.util.*;
class Heart_beat implements Serializable{
	private long initial_clock;
	private int number;
	private long latest_clock;
	public Heart_beat(){
		initial_clock=System.currentTimeMillis();
		number=0;
		latest_clock=initial_clock;
	}
	public long get_initial_clock(){
		return initial_clock;
	}
	public void set_initial_clock(long initial_clock){
		this.initial_clock=initial_clock;
	}
	public int get_number(){
		return number;
	}
	public void set_number(int number){
		this.number=number;
	}
	public long get_latest_clock(){
		return latest_clock;
	}
	public void set_latest_clock(long latest_clock){
		this.latest_clock=latest_clock;
	}
	public double calculate(){
		long now=System.currentTimeMillis();
		return (now-latest_clock)*number*1.0/(now-initial_clock);
	}
}
class HandleAClient extends Thread{
	private Socket socket;//A connected socket
	private Machine_status status;
	private InetAddress ID;
	InputStream input;
	OutputStream output;
	//Construct a thread
	public HandleAClient(Socket socket,Machine_status status,InetAddress ID){
		this.socket=socket;
		this.status=status;
		this.ID=ID;
	}
	public Socket getsocket(){
		return socket;
	}
	public InetAddress gethostaddress(){
		return ID;
	}
	public void setID(InetAddress client){
		ID=client;
	}
	public Machine_status get_status(){
		return status;
	}
	public void reset(Socket socket){
		this.socket=socket;
		try {
			this.input=socket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.output=socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Run the thread
	public void run(){
		//Create data input Streams
		System.out.printf("input");
		try {
			output=socket.getOutputStream();
			input =socket.getInputStream();
			System.out.printf("input");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//new a input
		
			while(true){
				//System.out.printf("execute\n");
				try{
					//if(is_connected(new ObjectOutputStream(socket.getOutputStream()))){
					byte[] b=new byte[20];
					input.read(b,0,20);
					System.out.printf("receive heart_beat\n");
					status.online=true;
					status.get_heart_beat().set_latest_clock(System.currentTimeMillis());
					status.get_heart_beat().set_number(status.get_heart_beat().get_number()+1);
				}
				catch(Exception ex){
					//ex.printStackTrace();
					continue;
					}
			}
	}
}

class Machine_status{
	Heart_beat heart_beat;
	boolean online;
	public Machine_status(){
		heart_beat=new Heart_beat();
		online=true;
	}
	public boolean get_online(){
		return online;
	}
	public Heart_beat get_heart_beat(){
		return heart_beat;
	}
	public void set_online(boolean online){
		this.online=online;
	}
	public void set_heart_beat(Heart_beat temp){
		heart_beat.set_number(temp.get_number());
		heart_beat.set_latest_clock(temp.get_latest_clock());
		heart_beat.set_initial_clock(temp.get_initial_clock());
	}
}
class newTimerTask extends TimerTask{
	Server server;
	public void setServer(Server server){
		this.server=server;
	}
	public void run() {
		// TODO Auto-generated method stub
		server.judge();
	}
}
public class Server {

	/**
	 * @param args
	 */
	private long initial_clock;
	private ArrayList<HandleAClient> array_thread=new ArrayList<HandleAClient>();
	public Server(){
		initial_clock=System.currentTimeMillis();
		Timer timer=new Timer(true);
		newTimerTask timertask=new newTimerTask();
		timertask.setServer(this);
		timer.schedule(timertask, new Date(), 1000);
		try{
			//create a server socket
			ServerSocket serversocket=new ServerSocket(8003);
			int clientNo=1;
			while(true){
				Socket socket=serversocket.accept();
				System.out.printf("new a connection\n");
				InetAddress clientIP=socket.getInetAddress();
				int i=0;
				for( i=0;i<array_thread.size();i++){
					if(array_thread.get(i).gethostaddress().equals(clientIP))break;
				}
				if(i==array_thread.size()){
					Machine_status status=new Machine_status(); 
					HandleAClient task=new HandleAClient(socket,status,socket.getInetAddress());
					array_thread.add(task);
					//Start the new thread
					task.start();
					//Increment clientNo
					clientNo++;
				}
				else{
					array_thread.get(i).get_status().set_online(true);
					array_thread.get(i).get_status().set_heart_beat(new Heart_beat());
					array_thread.get(i).reset(socket);
					array_thread.get(i).resume();
					System.out.println(array_thread.get(i).gethostaddress()+"is reconnected\n");
				}
			}
		}
		catch(IOException ex){
			System.err.println(ex);
		}
	}
	@SuppressWarnings("deprecation")
	void judge(){
		for(int i=0;i<array_thread.size();i++){
			double ratio=array_thread.get(i).get_status().get_heart_beat().calculate();
			if(ratio>10.0){
				if(array_thread.get(i).get_status().get_online()==true)
					{	
					array_thread.get(i).suspend();
					System.out.println(array_thread.get(i).gethostaddress()+"is suspended\n");
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}

}
