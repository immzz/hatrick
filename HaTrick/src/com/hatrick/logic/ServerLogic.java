package com.hatrick.logic;

import java.util.ArrayList;
import java.util.Iterator;

import com.hatrick.server.Message;
import com.hatrick.server.Server;

public class ServerLogic implements Runnable{
	static ArrayList<Hero> hero_list = new ArrayList<Hero>();
    static LogicMap logicMap;
	ArrayList<Operation> op_list = new ArrayList<Operation>();
	
	synchronized static public ArrayList<Hero> get_heros () {
		return hero_list;
	}

    public static void initMap(int height, int width, int[][] groundMap) {

        logicMap = new LogicMap(height, width, groundMap);
        LogicObject.mapInstance = logicMap;
    }
	
	public void run() {
        Iterator<LogicObject> iter;
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // action list
            iter = logicMap.actionList.iterator();
            while (iter.hasNext()) {
                iter.next().doAction();
            }

            // TODO: deleteList

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
			if(hero_list.get(op.index).is_free())
				hero_list.get(op.index).handle_op((Operation)message.get_obj());
		}
	}
}
