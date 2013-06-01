package com.hatrick.server;

import java.net.InetAddress;
import java.net.Socket;

public class User {

	public static final int USER_LOBBY = 10; 
	public static final int USER_ROOM = 11;
	public static final int USER_GAME = 12; 
	
	public static final int CHAR_HOST = 13;
	public static final int CHAR_GUEST = 14;
	public static final int CHAR_UNKOWN = 15;
	
	private InetAddress address;
	private String name;
	private int state;
	private Room room;
	private int character;
	private Socket socket;
	
	public User( InetAddress address,String name,int state,Socket socket ){
		this.address = address;
		this.name =name;
		this.room = null;
		this.socket = socket;
		this.state = USER_LOBBY;
		this.character = CHAR_UNKOWN;
	}
	
	
	
}

