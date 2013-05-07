package com.hatrick.test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.hatrick.graphic.*;
import com.hatrick.logic.Operation;

public class GraphicBasicTest extends BasicGame {

	public static long[] direction;

	public GraphicBasicTest(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		Stage.display();
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		Avatar avt_0 = new Avatar(0, Avatar.DAEMON2A);
		Avatar avt_1 = new Avatar(1, Avatar.ASSASSIN1B);
		Avatar avt_2 = new Avatar(2, Avatar.COLLABO1A);
		Avatar avt_3 = new Avatar(3, Avatar.CRUSADER1A);
		Avatar avt_4 = new Avatar(4, Avatar.DANCER1A);
		Avatar avt_5 = new Avatar(5, Avatar.GUNSLINGER1A);
		Avatar avt_6 = new Avatar(6, Avatar.KNIGHT1A);
		Avatar avt_7 = new Avatar(7, Avatar.MAGICIAN2A);
		Avatar avt_8 = new Avatar(8, Avatar.MONK1B);
		Avatar avt_9 = new Avatar(9, Avatar.MUMMY4A);
		avt_0.setPosition(16, 32);
		avt_1.setPosition(160, 320);
		avt_2.setPosition(50, 32);
		avt_3.setPosition(140, 150);
		avt_4.setPosition(470, 180);
		avt_5.setPosition(160, 560);
		avt_6.setPosition(232, 270);
		avt_7.setPosition(560, 490);
		avt_8.setPosition(50, 450);
		avt_9.setPosition(460, 100);
		Stage.add(avt_0);
		Stage.add(avt_1);
		Stage.add(avt_2);
		Stage.add(avt_3);
		Stage.add(avt_4);
		Stage.add(avt_5);
		Stage.add(avt_6);
		Stage.add(avt_7);
		Stage.add(avt_8);
		Stage.add(avt_9);

		direction = new long[] { 0, 0, 0, 0 };
	}

	@Override
	public void update(GameContainer c, int delta) throws SlickException {
		// TODO Auto-generated method stub
		int sid = 4;
		Sprite sprt = Stage.get(sid);

		Operation op = new Operation();
		Input input = c.getInput();

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
			op.goingup();
		} else if (min == 1) {
			op.goingdown();
		} else if (min == 2) {
			op.goingleft();
		} else if (min == 3) {
			op.goingright();
		}

		if (input.isKeyDown(Input.KEY_J)) {
			op.shoot();
		}

		if (input.isKeyDown(Input.KEY_K)) {
			op.jump();
		}

		if (input.isKeyDown(Input.KEY_1)) {
			op.useitem(1);
		} else if (input.isKeyDown(Input.KEY_2)) {
			op.useitem(2);
		} else if (input.isKeyDown(Input.KEY_3)) {
			op.useitem(3);
		} else if (input.isKeyDown(Input.KEY_4)) {
			op.useitem(4);
		} else if (input.isKeyDown(Input.KEY_5)) {
			op.useitem(5);
		} else if (input.isKeyDown(Input.KEY_6)) {
			op.useitem(6);
		} else if (input.isKeyDown(Input.KEY_7)) {
			op.useitem(7);
		} else if (input.isKeyDown(Input.KEY_8)) {
			op.useitem(8);
		} else if (input.isKeyDown(Input.KEY_9)) {
			op.useitem(9);
		} else if (input.isKeyDown(Input.KEY_0)) {
			op.useitem(0);
		}

		if (op.moving == 1) {
			sprt.moveTo(sprt.getX(), sprt.getY() - delta / 2f);
		} else if (op.moving == 2) {
			sprt.moveTo(sprt.getX(), sprt.getY() + delta / 2f);
		} else if (op.moving == 3) {
			sprt.moveTo(sprt.getX() - delta / 2f, sprt.getY());
		} else if (op.moving == 4) {
			sprt.moveTo(sprt.getX() + delta / 2f, sprt.getY());
		}
		/*
		 * if (input.isKeyDown(Input.KEY_R)) {
		 * if(input.isKeyDown(Input.KEY_EQUALS)) sprt.rotateGraph(delta/50.0f);
		 * else if(input.isKeyDown(Input.KEY_MINUS))
		 * sprt.rotateGraph(-1*delta/50.0f); }
		 * 
		 * if (input.isKeyDown(Input.KEY_S)) {
		 * if(input.isKeyDown(Input.KEY_EQUALS))
		 * sprt.setScale(sprt.getScale()+delta/5000f); else
		 * if(input.isKeyDown(Input.KEY_MINUS))
		 * sprt.setScale(sprt.getScale()-delta/5000f); } if
		 * (input.isKeyDown(Input.KEY_A)) {
		 * if(input.isKeyDown(Input.KEY_EQUALS))
		 * sprt.setAlpha(sprt.getAlpha()+delta/5000f); else
		 * if(input.isKeyDown(Input.KEY_MINUS))
		 * sprt.setAlpha(sprt.getAlpha()-delta/5000f); }
		 */

	}

	public static void main(String[] args) {
		try {
			AppGameContainer g = new AppGameContainer(new GraphicBasicTest(
					"Graphic basic test."), 800, 600, false);
			Stage.setContainer(g);
			g.setFullscreen(false);
			g.setVerbose(false);
			g.setTargetFrameRate(Stage.getMaxFPS());
			g.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}