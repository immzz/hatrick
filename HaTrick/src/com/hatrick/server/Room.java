package com.hatrick.server;

import java.net.InetAddress;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Room {

	public static final int ROOM_WAITING = 20; 
	public static final int ROOM_FULL = 21;
	public static final int ROOM_GAME = 22;
	
	
	private ArrayList<String> userList = new ArrayList<String>();
	private int state ;
	//private ArrayList<InetAddress> addressList = new ArrayList<InetAddress>();
	//private ArrayList
	
	public Room(){
		
	}
	
	public void addUser(String name, InetAddress address){
		userList.add(name);
		//addressList.add(address);
	}
	
	public boolean removeUser(String name){
		int index = userList.indexOf(name);
		if( index < 0)return false;
		userList.remove(index);
		//addressList.remove(index);
		return true;
	}
	/*public boolean removeUser(InetAddress address){
		int index = addressList.indexOf(address);
		if( index < 0)return false;
		userList.remove(index);
		addressList.remove(index);
		return true;
	}*/
	public static void main(String[] args){

		JFrame frame = new JFrame("Room");
		
		//outlook on surface
		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel") ;
		}catch (Exception e) {
            System.err.println("Oops!  Something went wrong!");
  		}
		SwingUtilities.updateComponentTreeUI(frame);
		
		
		
		
		
		
		
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	
}
