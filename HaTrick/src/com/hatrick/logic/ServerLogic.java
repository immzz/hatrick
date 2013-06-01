package com.hatrick.logic;

import java.util.ArrayList;

import com.hatrick.server.Message;
import com.hatrick.server.Server;

public class ServerLogic implements Runnable{
	static ArrayList<Hero> hero_list = new ArrayList<Hero>();
    static LogicMap logicmap;
	ArrayList<Operation> op_list = new ArrayList<Operation>();
	
	synchronized static public ArrayList<Hero> get_heros () {
		return hero_list;
	}

    public static void initMap(int size_x, int size_y, int[][] groundMap, int ratio) {
        
    }
	
	public void run() {
        
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            


			Message m = new Message(Message.TYPE_HERO, null, hero_list);
			Server.broadcast(m);
			//if(hero_list.size() > 0)
				//System.out.println("pos_x" + hero_list.get(0).pos_x);
		}
	}
	
	public synchronized static void handleMessage(Message message) {
		if(message.get_type() == Message.TYPE_INIT) {
			hero_list.add(new Hero((String)message.get_obj(),0,0,0,0,10));
			Message m = new Message(Message.TYPE_HERO, null, hero_list);
			Server.broadcast(m);
		}
		else if(message.type == Message.TYPE_OPERATION) {
			Operation op = (Operation)message.get_obj();
			//System.out.println(op.moving);
			hero_list.get(op.index).handle_op((Operation)message.get_obj()); //notgood->add_op();
		}
	}
}
