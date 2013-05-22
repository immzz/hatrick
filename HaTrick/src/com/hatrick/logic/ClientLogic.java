package com.hatrick.logic;

import java.util.ArrayList;

import org.newdawn.slick.Input;

import com.hatrick.server.Client;
import com.hatrick.server.Message;

public class ClientLogic implements Runnable {
	static Hero myhero;
	static int myhero_index;
	static ArrayList<Hero> hero_list = new ArrayList<Hero>();
	
	public static long[] direction = new long[] { 0, 0, 0, 0 };
	
	synchronized static public ArrayList<Hero> get_heros () {
		return hero_list;
	}
	
	/**
	 * send message.INIT for hero name
	 * lock until get herolist, init myhero_index, myhero
	 * lock incase run() or graphics_get_herolist()
	 */
	public void init() {
		
		
	}
	
	/**
	 * nothing to do
	 */
	public void run() {
		
	}
	
	static public void new_operation(Input input) {
		Operation op = new Operation();
		op.getInput(input, direction);
		//send to server
	}

	synchronized static void handleMessage(Object message) {
		//if(message.type = Message.TYPE_OPERATION);
		//no way
		
		//else if(message.type = Message.TYPE_HERO)
		//myhero = message.data;
		
		//else if(message.type = Message.TYPE_INIT)
		//map & other heros init
		//*unlock
	}
}
