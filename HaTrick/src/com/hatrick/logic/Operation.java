package com.hatrick.logic;

import java.io.Serializable;

import org.newdawn.slick.Input;

public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public int moving = 0;				// 0no 1up 2down 3left 4right 
	public int state = 0;				// 0no 1hold 2run
	public int usingitem = 0;			// 0no 1item1 ... 9item9
	public boolean shooting = false;	// 0no 1yes
	public boolean jumping = false;		// 0no 1yes
	public long time = 0;
	public int index;
	
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
	
	public void getInput(Input input, long[] direction) {
		if (input.isKeyDown(Input.KEY_W))
			direction[0]++;
		else
			direction[0] = 0;
		
		if (input.isKeyDown(Input.KEY_S))
			direction[1]++;
		else
			direction[1] = 0;
		
		if (input.isKeyDown(Input.KEY_A)) 
			direction[2]++;
		else
			direction[2] = 0;
		
		if (input.isKeyDown(Input.KEY_D))
			direction[3]++;
		else
			direction[3] = 0;

		int min = -1;
		long minvalue = Long.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			if (direction[i] != 0 && direction[i] < minvalue) {
				minvalue = direction[i];
				min = i;
			}
		}

		if (min == 0) {
			goingup();
		} else if (min == 1) {
			goingdown();
		} else if (min == 2) {
			goingleft();
		} else if (min == 3) {
			goingright();
		}

		if (input.isKeyDown(Input.KEY_J)) {
			shoot();
		}

		if (input.isKeyDown(Input.KEY_K)) {
			jump();
		}

		if (input.isKeyDown(Input.KEY_1)) {
			useitem(1);
		} else if (input.isKeyDown(Input.KEY_2)) {
			useitem(2);
		} else if (input.isKeyDown(Input.KEY_3)) {
			useitem(3);
		} else if (input.isKeyDown(Input.KEY_4)) {
			useitem(4);
		} else if (input.isKeyDown(Input.KEY_5)) {
			useitem(5);
		} else if (input.isKeyDown(Input.KEY_6)) {
			useitem(6);
		} else if (input.isKeyDown(Input.KEY_7)) {
			useitem(7);
		} else if (input.isKeyDown(Input.KEY_8)) {
			useitem(8);
		} else if (input.isKeyDown(Input.KEY_9)) {
			useitem(9);
		} else if (input.isKeyDown(Input.KEY_0)) {
			useitem(0);
		}
	}
}
