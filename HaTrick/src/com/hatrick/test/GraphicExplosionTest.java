package com.hatrick.test;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.hatrick.graphic.*;

public class GraphicExplosionTest extends BasicGame {

	public GraphicExplosionTest(String title) {
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
		Effect explosion_1 = new Effect(1,Effect.EXPLOSION_1);
		explosion_1.setPosition(200, 200);
		Stage.add(explosion_1);
	}

	@Override
	public void update(GameContainer c, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = c.getInput();
		Sprite sprt = Stage.get(0);
		//System.out.println("delta:"+delta);
		//System.out.println("FPS:"+Stage.getFPS());
		if (input.isKeyDown(Input.KEY_UP)) {
			sprt.moveTo(sprt.getX(),sprt.getY()-delta/2f);
		}else
		if (input.isKeyDown(Input.KEY_DOWN)) {
			sprt.moveTo(sprt.getX(),sprt.getY()+delta/2f);
		}else
		if (input.isKeyDown(Input.KEY_LEFT)) {
			sprt.moveTo(sprt.getX()-delta/2f,sprt.getY());
		}else
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			sprt.moveTo(sprt.getX()+delta/2f,sprt.getY());
		}
		if (input.isKeyDown(Input.KEY_R)) {
			if(input.isKeyDown(Input.KEY_EQUALS))
				sprt.rotateGraph(delta/50.0f);
			else if(input.isKeyDown(Input.KEY_MINUS))
				sprt.rotateGraph(-1*delta/50.0f);
		}
		
		if (input.isKeyDown(Input.KEY_S)) {
			if(input.isKeyDown(Input.KEY_EQUALS))
				sprt.setScale(sprt.getScale()+delta/5000f);
			else if(input.isKeyDown(Input.KEY_MINUS))
				sprt.setScale(sprt.getScale()-delta/5000f);
		}
		if (input.isKeyDown(Input.KEY_A)) {
			if(input.isKeyDown(Input.KEY_EQUALS))
				sprt.setAlpha(sprt.getAlpha()+delta/5000f);
			else if(input.isKeyDown(Input.KEY_MINUS))
				sprt.setAlpha(sprt.getAlpha()-delta/5000f);
		}
	}

	public static void main(String [] args){
		try {
			AppGameContainer g = new AppGameContainer(new GraphicExplosionTest(
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