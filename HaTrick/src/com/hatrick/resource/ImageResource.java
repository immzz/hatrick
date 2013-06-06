package com.hatrick.resource;

import java.util.HashMap;

import com.hatrick.graphic.Avatar;
import com.hatrick.graphic.Element;
import com.hatrick.graphic.ImageInfo;
import com.hatrick.graphic.Sprite;

public class ImageResource {
	public static class avatars {
		public static HashMap<Integer,ImageInfo[]> stand = new HashMap<Integer,ImageInfo[]>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 78863533991560002L;

			{
				put(Sprite.ASSASSIN1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.ASSASSIN1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.ASSASSIN2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.ASSASSIN3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.ASSASSIN3B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin3b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin3b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin3b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin3b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.ASSASSIN4A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin4a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin4a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin4a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/assassin4a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.COLLABO1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/collabo1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/collabo1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/collabo1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/collabo1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.COLLABO1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/collabo1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/collabo1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/collabo1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/collabo1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.CRUSADER1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/crusader1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/crusader1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/crusader1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/crusader1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.CRUSADER1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/crusader1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/crusader1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/crusader1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/crusader1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.DAEMON2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/daemon2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/daemon2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/daemon2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/daemon2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.DANCER1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/dancer1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/dancer1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/dancer1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/dancer1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.DANCER1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/dancer1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/dancer1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/dancer1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/dancer1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.GUNSLINGER1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/gunslinger1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.GUNSLINGER1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/gunslinger1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.KNIGHT1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.KNIGHT1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.KNIGHT2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.KNIGHT2B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight2b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight2b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight2b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight2b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.KNIGHT3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.KNIGHT3B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight3b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight3b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight3b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight3b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.KNIGHT4A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight4a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight4a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight4a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight4a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.KNIGHT5A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight5a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight5a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight5a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/knight5a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN3B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician3b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician3b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician3b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician3b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN4A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician4a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician4a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician4a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician4a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN4B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician4b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician4b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician4b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician4b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN5A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician5a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician5a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician5a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician5a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN5B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician5b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician5b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician5b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician5b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN6A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician6a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician6a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician6a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician6a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MAGICIAN6B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician6b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician6b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician6b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/magician6b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MONK1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/monk1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/monk1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/monk1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/monk1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MONK1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/monk1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/monk1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/monk1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/monk1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.MUMMY4A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/mummy4a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/mummy4a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/mummy4a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/mummy4a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.PRIEST1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.PRIEST1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.PRIEST2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.PRIEST2B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest2b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest2b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest2b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest2b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.PRIEST3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/priest3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});
				put(Sprite.WITCH3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/witch3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/witch3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/witch3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32,1,1)
				,new ImageInfo("res/game/graphic/avatars/witch3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32,1,1)});

			}
		};
	}

	public static class elements {
		public static HashMap<Integer,ImageInfo[]> still = new HashMap<Integer,ImageInfo[]>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 5010077800553022571L;

			{
				put(Sprite.SNOW_CAGE,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_cage.png",Sprite.DIRECTION_NONE,0,0,0,0,76,104,1,1)});
				put(Sprite.SNOW_DUCK_1,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_duck_1.png",Sprite.DIRECTION_NONE,0,0,0,0,70,103,2,1)});
				put(Sprite.SNOW_DUCK_2,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_duck_2.png",Sprite.DIRECTION_NONE,0,0,0,0,70,103,2,1)});
				put(Sprite.SNOW_DUCK_3,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_duck_3.png",Sprite.DIRECTION_NONE,0,0,0,0,70,103,2,1)});
				put(Sprite.SNOW_FLOOR_1,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_floor_1.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				put(Sprite.SNOW_FLOOR_2,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_floor_2.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				put(Sprite.SNOW_FLOOR_3,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_floor_3.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				put(Sprite.SNOW_FLOOR_4,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_floor_4.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				put(Sprite.SNOW_FLOOR_5,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_floor_5.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				put(Sprite.SNOW_FLOOR_6,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_floor_6.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				put(Sprite.SNOW_FLOOR_7,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_floor_7.png",Sprite.DIRECTION_NONE,0,0,0,0,71,70,1,1)});
				put(Sprite.SNOW_FLOOR_8,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_floor_8.png",Sprite.DIRECTION_NONE,0,0,0,0,71,70,1,1)});
				put(Sprite.SNOW_GRASS_1,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_grass_1.png",Sprite.DIRECTION_NONE,0,0,0,0,75,80,1,1)});
				put(Sprite.SNOW_GRASS_2,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_grass_2.png",Sprite.DIRECTION_NONE,0,0,0,0,71,80,1,1)});
				put(Sprite.SNOW_ICEBLOCK_1,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_iceblock_1.png",Sprite.DIRECTION_NONE,0,0,0,0,76,80,1,1)});
				put(Sprite.SNOW_ICEBLOCK_2,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_iceblock_2.png",Sprite.DIRECTION_NONE,0,0,0,0,76,92,1,1)});
				put(Sprite.SNOW_ICEBLOCK_3,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_iceblock_3.png",Sprite.DIRECTION_NONE,0,0,0,0,76,80,1,1)});
				put(Sprite.SNOW_ICEBLOCK_4,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_iceblock_4.png",Sprite.DIRECTION_NONE,0,0,0,0,76,80,1,1)});
				put(Sprite.SNOW_PLANT,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_plant.png",Sprite.DIRECTION_NONE,0,0,0,0,75,82,1,1)});
				put(Sprite.SNOW_ROAD_CURVE_1,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_curve_1.png",Sprite.DIRECTION_NONE,0,0,0,0,140,140,2,2)});
				put(Sprite.SNOW_ROAD_CURVE_2,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_curve_2.png",Sprite.DIRECTION_NONE,0,0,0,0,140,140,2,2)});
				put(Sprite.SNOW_ROAD_CURVE_3,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_curve_3.png",Sprite.DIRECTION_NONE,0,0,0,0,140,140,2,2)});
				put(Sprite.SNOW_ROAD_CURVE_4,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_curve_4.png",Sprite.DIRECTION_NONE,0,0,0,0,140,140,2,2)});
				put(Sprite.SNOW_ROAD_CURVE_5,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_curve_5.png",Sprite.DIRECTION_NONE,0,0,0,0,140,140,2,2)});
				put(Sprite.SNOW_ROAD_CURVE_6,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_curve_6.png",Sprite.DIRECTION_NONE,0,0,0,0,140,140,2,2)});
				put(Sprite.SNOW_ROAD_CURVE_7,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_curve_7.png",Sprite.DIRECTION_NONE,0,0,0,0,140,140,2,2)});
				put(Sprite.SNOW_ROAD_CURVE_8,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_curve_8.png",Sprite.DIRECTION_NONE,0,0,0,0,140,140,2,2)});
				//put(Sprite.SNOW_ROAD_HOR_1,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_hor_1.png",Sprite.DIRECTION_NONE,0,0,0,0,106,54)});
				put(Sprite.SNOW_ROAD_HOR_2,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_hor_2.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				//put(Sprite.SNOW_ROAD_HOR_3,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_hor_3.png",Sprite.DIRECTION_NONE,0,0,0,0,106,52)});
				put(Sprite.SNOW_ROAD_HOR_4,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_hor_4.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				//put(Sprite.SNOW_ROAD_VER_1,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_ver_1.png",Sprite.DIRECTION_NONE,0,0,0,0,53,104)});
				put(Sprite.SNOW_ROAD_VER_2,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_ver_2.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				//put(Sprite.SNOW_ROAD_VER_3,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_ver_3.png",Sprite.DIRECTION_NONE,0,0,0,0,53,104)});
				put(Sprite.SNOW_ROAD_VER_4,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_road_ver_4.png",Sprite.DIRECTION_NONE,0,0,0,0,71,71,1,1)});
				//put(Sprite.SNOW_STATUE_1,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_statue_1.png",Sprite.DIRECTION_NONE,0,0,0,0,102,74)});
				put(Sprite.SNOW_STATUE_2,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/snow_statue_2.png",Sprite.DIRECTION_NONE,0,0,0,0,282,199,2,4)});
			}
		};
	}
}
