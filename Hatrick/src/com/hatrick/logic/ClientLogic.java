package com.hatrick.logic;

import java.util.ArrayList;

import com.hatrick.server.Client;
import com.hatrick.server.Message;

public class ClientLogic implements Runnable {
	static Hero myhero;
	static int myhero_index;
	static ArrayList<Hero> hero_list = new ArrayList<Hero>();
	
	synchronized static public ArrayList<Hero> get_heros () {
		return hero_list;
	}
	
	/**
	 * send message.INIT for hero name
	 * lock until get herolist, init myhero_index, myhero
	 * lock incase run() or graphics_get_herolist()
	 */
	public void init() {//lock for what?
		
		
	}
	
	/**
	 * relop for op
	 * 
	 */
	public void run() {
		//**will get op be here?
	}

	public synchronized static void handleMessage(Object message) {
		//if(message.type = Message.TYPE_OPERATION);
		//nothing now; LATER: myhero.handle(message.data);
		
		//else if(message.type = Message.TYPE_HERO)
		//myhero = message.data;
		
		//else if(message.type = Message.TYPE_INIT)
		//map & other heros init
		//*unlock
	}
}
