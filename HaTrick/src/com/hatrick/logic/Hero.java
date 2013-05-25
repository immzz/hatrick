package com.hatrick.logic;

import java.io.Serializable;

public class Hero extends LogicObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String name;
	int id;
	/* moving */
	//double pos_x, pos_y;
	//double width;
	//int direction;		//1 of 4 OK? Will turn cost time? Different time?
	//double speed;
	/* status */
	double hp;
	double change;
	/* using items */
	Item[] bag = new Item[10];
	int strength;
	int power;
	
    public Hero(String s, double pos_x, double pos_y, double width, int direction, double speed) {
        super(pos_x, pos_y, width, direction, speed);
        name = s;
    }

    public void doAction() {}

	void handle_op(Operation op) {
		if (op.moving == 1) {
			pos_y -= speed;
			direction = 1;
		} else if (op.moving == 2) {
			pos_y += speed;
			direction = 2;
		} else if (op.moving == 3) {
			pos_x -= speed;
			direction = 3;
		} else if (op.moving == 4) {
			pos_x += speed;
			direction = 4;
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
