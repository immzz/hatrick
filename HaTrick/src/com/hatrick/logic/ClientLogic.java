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
	
	public void init() {
		//**send message.INIT
		//*lock
	}
	
	public void run() {
		//**will get op be here?
	}

	synchronized static void handleMessage(Object message) {
		//if(message.type = Message.TYPE_OPERATION);
		//nothing now; LATER: myhero.handle(message.data);
		
		//else if(message.type = Message.TYPE_HERO)
		//myhero = message.data;
		
		//else if(message.type = Message.TYPE_INIT)
		//map & other heros init
		//*unlock
	}
}
