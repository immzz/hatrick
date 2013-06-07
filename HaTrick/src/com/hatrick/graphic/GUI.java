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
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;


import com.hatrick.logic.ClientLogic;

public class GUI {
	
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
	private static int side_scores[];
	private static int side_2_score;
	private static String current_time;
	private static HTextField side_1_score_text;
	private static HTextField side_2_score_text;
	private static HTextField time_text;
	private static HTextField hp_text;
	private static HTextField mana_text;
	private static HTextField vs;
	private static Rectangle score_board = new Rectangle(250, 13, 300, 30);
	private static Rectangle time_board = new Rectangle(250, 53, 300, 30);
	private static Rectangle healthBG = new Rectangle(240, 530, 0, 20);
	private static Rectangle healthRM = new Rectangle(240, 530, 0, 20);
	private static Rectangle manaBG = new Rectangle(240, 560, 0, 20);
	private static Rectangle manaRM = new Rectangle(240, 560, 0, 20);
	private static ShapeFill score_fill = new GradientFill(0, 40,new Color(0x33,0x33,0x33,100) , 0, 580, new Color(0x33,0x33,0x33,100));
	private static ShapeFill time_fill = new GradientFill(0, 40,new Color(0x33,0x33,0x33,100) , 0, 580, new Color(0x33,0x33,0x33,100));
    private static Color health_color = new Color(0xFF0000);
    private static Color mana_color = new Color(0x0000FF);
	private static ShapeFill healthFill = new GradientFill(0, 40,health_color , 0, 580, health_color);
	private static ShapeFill manaFill = new GradientFill(0, 40,health_color , 0, 580, health_color);
    private static ShapeFill rmFill = new GradientFill(0, 40,Color.black , 0, 580, Color.black);
   // private static 
    private static int my_health = 0;
    private static int my_mana = 0;
	public GUI(){
		
	}
	public static void init(GameContainer gc){
<<<<<<< HEAD
		side_scores = new int[2];
		for(int i=0;i<side_scores.length;i++){
			side_scores[i] = 0;
		}
		side_1_score_text = new HTextField("Magneto",Font.BOLD,"score1", org.newdawn.slick.Color.cyan, 25);
		side_2_score_text = new HTextField("Magneto",Font.BOLD,"score2", org.newdawn.slick.Color.cyan, 25);
		time_text = new HTextField("Magneto",Font.BOLD,"12:21", org.newdawn.slick.Color.cyan, 25);
		vs = new HTextField("Magneto",Font.BOLD,":", org.newdawn.slick.Color.white, 35);
		hp_text = new HTextField("Britannic Bold",Font.BOLD,"HP:", org.newdawn.slick.Color.red, 25);
		mana_text = new HTextField("Britannic Bold",Font.BOLD,"MANA:", org.newdawn.slick.Color.blue, 25);
		side_1_score_text.setPosition(285, 10);
		vs.setPosition(385, 0);
		side_2_score_text.setPosition(485, 10);
		hp_text.setPosition(150, 527);
		mana_text.setPosition(150, 557);
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
	public static void updateHealth(int health){
		my_health = health;
	}
	public static void updateMana(int mana){
		my_mana = mana;
	}
	public static void updateScore(int side,int score){
		side_scores[side-1] = score;
	}
	public static void updateTime(String time){
		current_time = time;
	}
	public static void update(){
		if(ClientLogic.myhero != null){
			updateHealth(ClientLogic.myhero.getHp());
		}
		
		
		
	}
	public static void draw(GUIContext guic,Graphics g){
		g.fill(time_board,time_fill);
		g.fill(score_board,score_fill);
		side_1_score_text.setText(String.valueOf(side_scores[0]));
		side_2_score_text.setText(String.valueOf(side_scores[1]));
		side_1_score_text.render();
		side_2_score_text.render();
		vs.render();
		hp_text.render();
		mana_text.render();
		health_color.r = 0.5f+0.5f*my_health/(float)100;
		health_color.g = 0.15f*(100-my_health)/100f;
		health_color.b = 0.15f*(100-my_health)/100f;
		mana_color.r = 0.15f*(100-my_mana)/100f;
		mana_color.g = 0.15f*(100-my_mana)/100f;
		mana_color.b = 0.6f+0.4f*my_mana/(float)100;
		
<<<<<<< HEAD
		healthFill = new GradientFill(0, 40,health_color , 0, 580, health_color);
		manaFill = new GradientFill(0, 40,mana_color , 0, 580, mana_color);
		healthBG.setWidth(my_health*3);
		healthRM.setX(healthBG.getX()+healthBG.getWidth());
		healthRM.setWidth((100 - my_health)*3);
		manaBG.setWidth(my_mana*3);
		manaRM.setX(manaBG.getX()+manaBG.getWidth());
		manaRM.setWidth((100 - my_mana)*3);
		g.fill(healthBG,healthFill);
		g.fill(manaBG,manaFill);
		g.fill(healthRM,rmFill);
		g.fill(manaRM,rmFill);

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
