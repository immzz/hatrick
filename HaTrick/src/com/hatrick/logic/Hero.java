package com.hatrick.logic;

import java.io.Serializable;

public class Hero extends LogicObject implements Serializable{
	
	/* moving */
	//double pos_x, pos_y;
	//double width;
	//int direction;		//1 of 4 OK? Will turn cost time? Different time?
	//double speed;
	String name;
	double hp;
	double change;
	/* using items */
	//Item[] bag = new Item[10];
	int strength;
	int power;
	
    public Hero(String name, int p_x, int p_y, double width, int direction, double speed) {
        super(p_x, p_y, width, direction, speed);
        this.name = name;
    }
    public void doAction() {
    	offset++;
    	super.count_pos();
    	if(actionTime <= 1) {
    		LogicObject.mapInstance.delActionList(this);
    	}
    	else 
    		actionTime--;
    }

    public void doDamage(double damage) {
        // naive
        hp -= damage;
        if (hp < 0)
            dead();
    }

    private void dead(){}
    
    boolean is_free() {
    	if(this.actionTime == 0) return true;
    	else return false;
    }

	void handle_op(Operation op) {
		if (op.moving == 1) {
			direction = 1;
			actionTime = 4;
			super.moveUp();
		} else if (op.moving == 2) {
			direction = 2;
			actionTime = 4;
			super.moveDown();
		} else if (op.moving == 3) {
			direction = 3;
			actionTime = 4;
			super.moveLeft();
		} else if (op.moving == 4) {
			direction = 4;
			actionTime = 4;
			super.moveRight();
		}
		use_item(op.usingitem);
	}
	
	void merge_state(Hero h) {
		pos_x = h.pos_x;
		pos_y = h.pos_y;
	}
	
	void use_item(int n) {
		if(n == 0) return;
	}
}
