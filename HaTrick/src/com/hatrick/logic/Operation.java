package com.hatrick.logic;

import java.util.Calendar;

public class Operation {		// holding is not using !!!
	public int moving;			// 0no 1up 2down 3left 4right 
	public int state;			// 0no 1hold 2run
	public int usingitem;		// 0no 1item1 ... 9item9
	public boolean shooting;	// 0no 1yes
	public boolean jumping;		// 0no 1yes
	public long time;
	
	public void goingup() {
		moving = 1;
	}
	
	public void goingdown() {
		moving = 2;
	}
	
	public void goingleft() {
		moving = 3;
	}
	
	public void goingright() {
		moving = 4;
	}
	
	public void hold() {
		state = 1;
	}
	
	public void run() {
		state = 2;
	}
	
	public void useitem(int index) {
		usingitem = index;
	}
	
	public void jump() {
		jumping = true;
	}
	
	public void shoot() {
		shooting = true;
	}
	
	public void 
}
