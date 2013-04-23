package com.hatrick.resource;

import java.util.HashMap;

import com.hatrick.graphic.Avatar;
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
				put(Avatar.ASSASSIN1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.ASSASSIN1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.ASSASSIN2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.ASSASSIN3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.ASSASSIN3B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin3b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin3b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin3b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin3b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.ASSASSIN4A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/assassin4a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin4a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin4a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/assassin4a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.COLLABO1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/collabo1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/collabo1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/collabo1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/collabo1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.COLLABO1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/collabo1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/collabo1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/collabo1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/collabo1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.CRUSADER1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/crusader1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/crusader1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/crusader1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/crusader1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.CRUSADER1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/crusader1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/crusader1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/crusader1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/crusader1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.DAEMON2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/daemon2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/daemon2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/daemon2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/daemon2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.DANCER1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/dancer1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/dancer1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/dancer1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/dancer1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.DANCER1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/dancer1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/dancer1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/dancer1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/dancer1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.GUNSLINGER1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/gunslinger1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.GUNSLINGER1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/gunslinger1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/gunslinger1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.KNIGHT1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.KNIGHT1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.KNIGHT2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.KNIGHT2B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight2b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight2b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight2b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight2b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.KNIGHT3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.KNIGHT3B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight3b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight3b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight3b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight3b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.KNIGHT4A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight4a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight4a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight4a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight4a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.KNIGHT5A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/knight5a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight5a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight5a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/knight5a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN3B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician3b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician3b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician3b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician3b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN4A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician4a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician4a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician4a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician4a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN4B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician4b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician4b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician4b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician4b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN5A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician5a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician5a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician5a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician5a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN5B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician5b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician5b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician5b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician5b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN6A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician6a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician6a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician6a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician6a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MAGICIAN6B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/magician6b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician6b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician6b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/magician6b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MONK1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/monk1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/monk1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/monk1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/monk1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MONK1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/monk1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/monk1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/monk1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/monk1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.MUMMY4A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/mummy4a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/mummy4a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/mummy4a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/mummy4a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.PRIEST1A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.PRIEST1B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.PRIEST2A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest2a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest2a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest2a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest2a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.PRIEST2B,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest2b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest2b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest2b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest2b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.PRIEST3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/priest3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/priest3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
				put(Avatar.WITCH3A,new ImageInfo[]{new ImageInfo("res/game/graphic/avatars/witch3a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/witch3a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/witch3a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
				,new ImageInfo("res/game/graphic/avatars/witch3a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
	
			}
		};
	}
		
		public static class elements {
			public static HashMap<Integer,ImageInfo[]> stand = new HashMap<Integer,ImageInfo[]>(){
				/**
				 * 
				 */
				private static final long serialVersionUID = 78863533991560002L;

				{
					put(Avatar.ASSASSIN1A,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/brick1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/brick1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/brick1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/brick1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
					put(Avatar.ASSASSIN1B,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/brick1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/brick1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/brick1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/brick1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
					put(Avatar.ASSASSIN2A,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/flower1a.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/flower1a.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/flower1a.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/flower1a.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
					put(Avatar.ASSASSIN3A,new ImageInfo[]{new ImageInfo("res/game/graphic/elements/flower1b.png",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/flower1b.png",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/flower1b.png",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)
					,new ImageInfo("res/game/graphic/elements/flower1b.png",Sprite.DIRECTION_UP,32,96,16,32,32,32)});
		
				}
			};
		
		}

}
