package com.hatrick.logic;

import java.util.ArrayList;

public class ServerLogic implements Runnable{
	static ArrayList<Hero> hero_list = new ArrayList<Hero>();
	Hero myhero;
	ArrayList<Operation> op_list = new ArrayList<Operation>();
	
	synchronized static public ArrayList<Hero> get_heros () {
		return hero_list;
	}
	
	public void run() {
		//duel with op_list
		//**send hero_list
	}
	
	void handleMessage(Object message) {
		//if(message.type = Message.TYPE_OPERATION)
		//myhero.handle_op(message.item); notgood->add_op();
		
		//else if(message.type = Message.TYPE_INIT)
		//new hero
		//ack hero_id & hero_list
	}
}
