package com.hatrick.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.hatrick.server.Message;
import com.hatrick.server.Server;

public class ServerLogic implements Runnable{
    static ArrayList<Hero> hero_list = new ArrayList<Hero>();
    static ArrayList<Bomb> bomb_list;
    static ArrayList<Potion> potion_list;
    static LogicMap logicMap;
    ArrayList<Operation> op_list = new ArrayList<Operation>();
    
    synchronized static public ArrayList<Hero> get_heros () {
        return hero_list;
    }

    public static void initMap(int height, int width, short[][] groundMap) {
        int[][] intMap = new int[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                intMap[i][j] = groundMap[i][j];
            }
        }
        logicMap = new LogicMap(height, width, intMap);
        LogicObject.mapInstance = logicMap;
    }
    
    public void run() {
        Iterator<LogicObject> iter;
        Random r = new Random();
        while(true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // set potion
            if (r.nextInt(1000) > 990) {
                new Potion(0, 0, 0, 10000);
            }

            // action list
            synchronized (logicMap.actionList) {
                iter = logicMap.actionList.iterator();
                while (iter.hasNext()) {
                    iter.next().doAction();
                }
            }
            // we should add more code about deletion
            iter = logicMap.actionListDel.iterator();
            while (iter.hasNext()) {
                logicMap.actionList.remove(iter.next());
            }
            logicMap.actionListDel = new ArrayList<LogicObject>();

            synchronized (logicMap.deleteList) {
                iter = logicMap.deleteList.iterator();
                while (iter.hasNext()) {
                    iter.next().doDelete();
                }
            }
            // we should add more code about deletion
            iter = logicMap.deleteListDel.iterator();
            while (iter.hasNext()) {
                LogicObject lo = iter.next();
                logicMap.deleteList.remove(lo);
                logicMap.objList.remove(lo);
            }
            logicMap.deleteListDel = new ArrayList<LogicObject>();

            synchronized (logicMap.objList) {
                iter = logicMap.objList.iterator();
                bomb_list = new ArrayList<Bomb>();
                potion_list = new ArrayList<Potion>();
                while (iter.hasNext()) {
                    LogicObject lo = iter.next();
                    if (lo instanceof Bomb) {
                        bomb_list.add((Bomb)lo);
                    }
                    if (lo instanceof Potion) {
                        potion_list.add((Potion)lo);
                    }
                }
            }

            Message m = new Message(Message.TYPE_HERO, null, hero_list);
            Server.broadcast(m);
            m = new Message(Message.TYPE_BOMB, null, bomb_list);
            Server.broadcast(m);
            m = new Message(Message.TYPE_POTION, null, potion_list);
            Server.broadcast(m);
            //if(hero_list.size() > 0)
                //System.out.println("pos_x" + hero_list.get(0).pos_x);
        }
    }
    
    public synchronized static void handleMessage(Message message) {
        if(message.get_type() == Message.TYPE_INIT) {
            hero_list.add(new Hero((String)message.get_obj(),0,0,0,10));
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
