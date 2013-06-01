package com.hatrick.graphic;


import java.awt.Font;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;

public class GUI {
	
	private static HTextField side_1_score;
	private static HTextField side_2_score;
	Rectangle healthBG = new Rectangle(300, 300, 200, 20);
    //ShapeFill healthFill = new GradientFill();

	public GUI(){
		
	}
	public static void init(GameContainer gc){
		side_1_score = new HTextField(gc, "score1", java.awt.Color.green, 20, 100, 25);
		side_2_score = new HTextField(gc, "score2", java.awt.Color.green, 20, 100, 25);
		side_1_score.setPosition(200, 0);
		side_2_score.setPosition(400, 0);
	}
	public static void draw(GUIContext guic,Graphics g){
		side_1_score.render(guic, g);
		side_2_score.render(guic, g);
		
		//draw blood bar
		g.setColor(Color.red);
		g.drawRect(300,300,200,20);
		//draw magic bar
		g.setColor(Color.blue);
		g.drawRect(300,400,200,20);
	}

}
