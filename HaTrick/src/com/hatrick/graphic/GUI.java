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
	private static HTextField side_1_roleName;
	private static HTextField side_2_roleName;
	private static HTextField side_3_roleName;
	private static HTextField side_1_roleKill;
	private static HTextField side_2_roleKill;
	private static HTextField side_3_roleKill;
	private static HTextField side_1_roleDeath;
	private static HTextField side_2_roleDeath;
	private static HTextField side_3_roleDeath;
	private static HTextField side_1_roleStatus;
	private static HTextField side_2_roleStatus;
	private static HTextField side_3_roleStatus;
	
	Rectangle healthBG = new Rectangle(300, 300, 200, 20);
    //ShapeFill healthFill = new GradientFill();

	public GUI(){
		
	}
	public static void init(GameContainer gc){
		side_1_score = new HTextField(gc, "score1", java.awt.Color.green, 20, 100, 25);
		side_2_score = new HTextField(gc, "score2", java.awt.Color.green, 20, 100, 25);
		side_1_score.setPosition(200, 0);
		side_2_score.setPosition(400, 0);
		
		side_1_roleName = new HTextField(gc, "me", java.awt.Color.white,20,100,25);
		side_2_roleName = new HTextField(gc, "parterner1", java.awt.Color.white,20,100,25);
		side_3_roleName = new HTextField(gc, "parterner2", java.awt.Color.white,20,100,25);
		side_1_roleName.setPosition(650, 50);
		side_2_roleName.setPosition(650, 250);
		side_3_roleName.setPosition(650, 450);

		side_1_roleKill = new HTextField(gc, "Kill:", java.awt.Color.white,15,100,25);
		side_2_roleKill = new HTextField(gc, "Kill:", java.awt.Color.white,15,100,25);
		side_3_roleKill = new HTextField(gc, "Kill:", java.awt.Color.white,15,100,25);
		side_1_roleKill.setPosition(700, 80);
		side_2_roleKill.setPosition(700, 280);
		side_3_roleKill.setPosition(700, 480);

		side_1_roleDeath = new HTextField(gc, "Death:", java.awt.Color.white,15,100,25);
		side_2_roleDeath = new HTextField(gc, "Death:", java.awt.Color.white,15,100,25);
		side_3_roleDeath = new HTextField(gc, "Death:", java.awt.Color.white,15,100,25);
		side_1_roleDeath.setPosition(700, 110);
		side_2_roleDeath.setPosition(700, 310);
		side_3_roleDeath.setPosition(700, 510);

		side_1_roleStatus = new HTextField(gc, "Status:", java.awt.Color.white,15,100,25);
		side_2_roleStatus = new HTextField(gc, "Status:", java.awt.Color.white,15,100,25);
		side_3_roleStatus = new HTextField(gc, "Status:", java.awt.Color.white,15,100,25);
		side_1_roleStatus.setPosition(700, 140);
		side_2_roleStatus.setPosition(700, 340);
		side_3_roleStatus.setPosition(700, 540);
		
	}
	public static void draw(GUIContext guic,Graphics g){
		side_1_score.render(guic, g);
		side_2_score.render(guic, g);
		

		side_1_roleName.render(guic, g);
		side_2_roleName.render(guic, g);
		side_3_roleName.render(guic, g);
		

		side_1_roleKill.render(guic, g);
		side_2_roleKill.render(guic, g);
		side_3_roleKill.render(guic, g);

		
		side_1_roleDeath.render(guic, g);
		side_2_roleDeath.render(guic, g);
		side_3_roleDeath.render(guic, g);

		
		side_1_roleStatus.render(guic, g);
		side_2_roleStatus.render(guic, g);
		side_3_roleStatus.render(guic, g);
		
		
		//draw blood bar
		//g.setColor(Color.red);
		//g.drawRect(300,300,200,20);
	
		//draw magic bar
		//g.setColor(Color.blue);
		//g.drawRect(300,400,200,20);
		
		//draw role info1
		//g.drawRect(600, 0, 200, 200);
		//g.drawRect(620, 80, 80, 80);
		
		//draw role info2
		//g.drawRect(600, 200, 200, 200);
		//g.drawRect(620, 280, 80, 80);
		
		//draw role info3
		//g.drawRect(600, 400, 200, 200);
		//g.drawRect(620, 480, 80, 80);
	}
}
