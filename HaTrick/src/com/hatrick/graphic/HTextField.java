package com.hatrick.graphic;

import java.awt.Color;
import java.awt.Font;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;

public class HTextField{
	private TextField text_field;
	private UnicodeFont uFont;
	public HTextField(GUIContext guic,String text,Color font_color,int font_size,int width,int height){
		Font fontePadrao = new Font("Arial", Font.PLAIN, font_size);
		uFont = new UnicodeFont(fontePadrao);
		uFont.addAsciiGlyphs();
		uFont.addGlyphs(400,600);
		uFont.getEffects().add(new ColorEffect(font_color));
		try {
			uFont.loadGlyphs();
		} catch (SlickException e) {

		};
		text_field = new TextField(guic , uFont, 0 , 0 , width , height);
		text_field.setText(text);
	}
	
	public void setText(String text){
		text_field.setText(text);
	}
	public void setPosition(int x,int y){
		text_field.setLocation(x, y);
	}
	public void render(GUIContext guic,Graphics g){
		//g.setColor(new org.newdawn.slick.Color(font_color));
		text_field.render(guic, g);
	}
	

}
