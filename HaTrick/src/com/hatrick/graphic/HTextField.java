package com.hatrick.graphic;

import java.awt.Color;
import java.awt.Font;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;

public class HTextField{
	private TrueTypeFont font;
	private String draw_text;
	private int x,y;
	private org.newdawn.slick.Color font_color;
	public HTextField(String type,int style,String text,org.newdawn.slick.Color font_color,int font_size){
		Font fontePadrao = new Font(type, style, font_size);
		font = new TrueTypeFont(fontePadrao, true);
		draw_text = text;
		this.font_color = font_color;
	}
	
	public void setText(String text){
		draw_text = text;
	}
	public void setPosition(int x,int y){
		this.x = x;
		this.y = y;
	}
	public void render(){
		font.drawString(x, y, draw_text,font_color);
	}
	

}

