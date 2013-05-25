package com.hatrick.logic;

import java.util.ArrayList;

import org.newdawn.slick.Input;
import com.hatrick.server.Client;
import com.hatrick.server.Message;

public class ClientLogic implements Runnable {
	static String name;
	static Hero myhero;
	//static int myhero_index;
	static ArrayList<Hero> hero_list = new ArrayList<Hero>();
	
	public static long[] direction = new long[] { 0, 0, 0, 0 };
	
	public ClientLogic(String s) {
		name = s;
	}
	
	synchronized static public ArrayList<Hero> get_heros () {
		return hero_list;
	}
	
	/**
	 * send message.INIT for hero name
	 * lock until get herolist, init myhero_index, myhero
	 * lock incase run() or graphics_get_herolist()
	 */
	
	/**
	 * relop for op
	 * 
	 * nothing to do
	 * @throws Exception 
	 */
	public void run() {
		Message message = new Message(Message.TYPE_INIT, null, name);
		try {
			Client.sendMessage(message);
			this.wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	static public void new_operation(Input input) {
		Operation op = new Operation();
		op.getInput(input, direction);
		//send to server
	}

	synchronized static void handleMessage(Message message) {
		//if(message.type = Message.TYPE_OPERATION);

        // HEAD
		//nothing now; LATER: myhero.handle(message.data);
        // gamelogic
		//no way
		
		if(message.type == Message.TYPE_HERO) {
			hero_list = (ArrayList<Hero>)message.get_obj();
			for(int i=0; i<hero_list.size(); i++) {
				if(hero_list.get(i).name.equals(name))
					myhero = hero_list.get(i);
			}
		}
		if(message.type == Message.TYPE_INIT) {
		//map & other heros init
		//*unlock
		}
	}
}
