package com.hatrick.logic;

import java.io.Serializable;
import java.util.Random;

public abstract class LogicObject implements Serializable{
	private static final long serialVersionUID = -1693769809101702805L;
	static LogicMap mapInstance;
	static ServerLogic serverLogicInstance;
    static int globalId = 0;

    public int id;
	/* status */
	int status;			//stop

	public int p_x, p_y;
	public int offset;
    public double pos_x, pos_y;
    public int direction;
    public double speed;
    public int actionTime;
    public int deleteTime;

    public LogicObject mapNext;
    
    void count_pos() {
    	if(direction == 1) {
    		this.pos_x = p_x * 70;
        	this.pos_y = (p_y - (double)offset / 4) * 70;
    	}
    	else if(direction == 2) {
    		this.pos_x = p_x * 70;
        	this.pos_y = (p_y + (double)offset / 4) * 70;
    	}
    	else if(direction == 3) {
    		this.pos_x = (p_x - (double)offset / 4) * 70;
        	this.pos_y = p_y * 70;
    	}
    	else if(direction == 4) {
    		this.pos_x = (p_x + (double)offset / 4) * 70;
        	this.pos_y = p_y * 70;
    	}
    	//this.pos_x += 35;
    	//this.pos_y += 55;
    }

    protected LogicObject(int p_x, int p_y, int direction, double speed, int actionTime, int deleteTime) {
        this.p_x = p_x;
        this.p_y = p_y;
        this.direction = direction;
        this.speed = speed;
        this.actionTime = actionTime;
        this.deleteTime = deleteTime;
        id = globalId ++;
    }

    protected LogicObject(int p_x, int p_y, int direction, double speed) {
        this(p_x, p_y, direction, speed, 0, 0);
    }

    public abstract void doAction();

    public void randomPos() {
        Random rand = new Random();
        int x = rand.nextInt(mapInstance.width);
        int y = rand.nextInt(mapInstance.height);
        while (!mapInstance.reachable(x, y)) {
            x = rand.nextInt(mapInstance.width);
            y = rand.nextInt(mapInstance.height);
        }
        p_x = x;
        p_y = y;
        pos_x = p_x * 70;
        pos_y = p_y * 70;
    }

    public void doDelete() {
        deleteTime --;
        if (deleteTime <= 0) {
            LogicObject.mapInstance.deleteListDel.add(this);
            LogicObject.mapInstance.delObjList(this);
        }
    }
    
    public void moveUp() {
    	if(!mapInstance.objMove(this, 0, -1)) {
    		actionTime = 0;
        }
    }

    public void moveDown() {
    	if(!mapInstance.objMove(this, 0, 1))
    		actionTime = 0;
    }

    public void moveLeft() {
    	if(!mapInstance.objMove(this, -1, 0))
    		actionTime = 0;
    }

    public void moveRight() {
    	if(!mapInstance.objMove(this, 1, 0))
    		actionTime = 0;
    }
}
