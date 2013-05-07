package com.hatrick.logic;

public class Hero {
	/* moving */
	double pos_x, pos_y;
	double width;
	int direction;		//1 of 4 OK? Will turn cost time? Different time?
	double speed;
	/* status */
	int status;			//stop
	double hp;
	double change;
	/* using items */
	Item[] bag = new Item[10];
	int strength;
	int power;
}
