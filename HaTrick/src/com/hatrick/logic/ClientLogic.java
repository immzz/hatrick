package com.hatrick.logic;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.Input;
import com.hatrick.server.Client;
import com.hatrick.server.Message;

public class ClientLogic implements Runnable {
    static String name;
    static int team;
    static int occupation;
    public static Hero myhero;
    public static int myhero_index;
    static int team1Score = 0;
    static int team2Score = 0;
    static ArrayList<Hero> hero_list = new ArrayList<Hero>();
    static ArrayList<Bomb> bomb_list = new ArrayList<Bomb>();
    static ArrayList<Potion> potion_list = new ArrayList<Potion>();
    
    public static long[] direction = new long[] { 0, 0, 0, 0 };
    
    public ClientLogic(String s, int team, int occupation) {
        name = s;
        ClientLogic.team = team;
        ClientLogic.occupation = occupation;
    }

    public int getScore1() {
        return team1Score;
    }

    public int getScore2() {
        return team2Score;
    }
    
    synchronized static public ArrayList<Hero> get_heros () {
        return hero_list;
    }

    synchronized static public ArrayList<Bomb> get_bombs () {
        return bomb_list;
    }
    
    synchronized static public ArrayList<Potion> get_potions () {
        return potion_list;
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
        Message message = new Message(Message.TYPE_INIT, null, name + "," + team + "," + occupation);
        try {
            Client.sendMessage(message);
            //this.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static public void new_operation(Input input) {
        Operation op = new Operation();
        op.getInput(input, direction);
        //send to server
    }
    
    static public void sendOperation(Operation op) {
        //System.out.println("send op");
        Message message = new Message(Message.TYPE_OPERATION, null, op);
        try {
            Client.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static void handleMessage(Message message) {

        //if(message.type = Message.TYPE_OPERATION);

        // HEAD
        //nothing now; LATER: myhero.handle(message.data);
        // gamelogic
        //no way
        
        if(message.type == Message.TYPE_HERO) {
            hero_list = (ArrayList<Hero>)message.get_obj();
            for(int i=0; i<hero_list.size(); i++) {
                if(hero_list.get(i).name.equals(name)) {
                    myhero = hero_list.get(i);
                    myhero_index = i;
                }
            }
            //System.out.println("Hero:\tpos_x" + hero_list.get(0).pos_x +"\tpos_y" + hero_list.get(0).pos_y);
        }
        if (message.type == Message.TYPE_BOMB) {
            bomb_list = (ArrayList<Bomb>)message.get_obj();
            Iterator<Bomb> iter = bomb_list.iterator();
            while (iter.hasNext()) {
                Bomb lo = iter.next();
                //if (lo.isExploring()) {
                //    System.out.printf("EXPLORE!!!!!!!!!!!\n");
                //}
            }
        }
        if (message.type == Message.TYPE_POTION) {
            potion_list = (ArrayList<Potion>)message.get_obj();
        }
        if (message.type == Message.TYPE_SCORE) {
            String[] score = ((String)message.get_obj()).split(",");
            team1Score = Integer.parseInt(score[0]);
            team2Score = Integer.parseInt(score[1]);
        }
    }
}
