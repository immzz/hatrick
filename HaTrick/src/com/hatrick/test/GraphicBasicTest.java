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
	}

	@Override
	public void update(GameContainer c, int delta) throws SlickException {
		// TODO Auto-generated method stub
		int sid = 4;
		Sprite sprt = Stage.get(sid);

		Operation op = new Operation();
		Input input = c.getInput();

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