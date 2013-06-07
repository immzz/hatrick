package com.hatrick.resource;

import java.util.HashMap;

import com.hatrick.graphic.AnimationInfo;
import com.hatrick.graphic.Avatar;
import com.hatrick.graphic.Sprite;

public class AnimationResource {
	public static class avatars{
		public static HashMap<Integer,AnimationInfo[]> walk = new HashMap<Integer,AnimationInfo[]>(){
			{
				put(Avatar.ASSASSIN1A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/assassin1a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin1a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin1a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin1a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.ASSASSIN1B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/assassin1b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin1b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin1b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin1b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.ASSASSIN2A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/assassin2a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin2a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin2a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin2a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.ASSASSIN3A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/assassin3a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin3a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin3a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin3a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.ASSASSIN3B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/assassin3b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin3b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin3b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin3b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.ASSASSIN4A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/assassin4a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin4a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin4a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/assassin4a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.COLLABO1A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/collabo1a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/collabo1a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/collabo1a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/collabo1a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.COLLABO1B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/collabo1b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/collabo1b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/collabo1b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/collabo1b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.CRUSADER1A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/crusader1a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/crusader1a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/crusader1a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/crusader1a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.CRUSADER1B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/crusader1b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/crusader1b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/crusader1b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/crusader1b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.DAEMON2A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/daemon2a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/daemon2a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/daemon2a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/daemon2a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.DANCER1A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/dancer1a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/dancer1a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/dancer1a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/dancer1a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.DANCER1B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/dancer1b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/dancer1b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/dancer1b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/dancer1b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.GUNSLINGER1A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/gunslinger1a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/gunslinger1a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/gunslinger1a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/gunslinger1a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.GUNSLINGER1B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/gunslinger1b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/gunslinger1b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/gunslinger1b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/gunslinger1b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.KNIGHT1A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/knight1a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight1a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight1a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight1a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.KNIGHT1B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/knight1b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight1b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight1b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight1b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.KNIGHT2A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/knight2a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight2a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight2a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight2a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.KNIGHT2B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/knight2b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight2b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight2b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight2b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.KNIGHT3A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/knight3a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight3a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight3a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight3a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.KNIGHT3B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/knight3b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight3b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight3b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight3b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.KNIGHT4A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/knight4a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight4a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight4a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight4a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.KNIGHT5A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/knight5a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight5a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight5a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/knight5a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN1A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician1a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician1a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician1a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician1a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN2A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician2a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician2a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician2a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician2a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN3A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician3a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician3a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician3a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician3a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN3B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician3b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician3b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician3b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician3b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN4A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician4a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician4a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician4a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician4a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN4B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician4b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician4b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician4b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician4b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN5A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician5a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician5a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician5a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician5a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN5B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician5b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician5b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician5b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician5b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN6A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician6a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician6a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician6a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician6a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MAGICIAN6B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/magician6b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician6b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician6b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/magician6b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MONK1A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/monk1a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/monk1a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/monk1a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/monk1a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MONK1B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/monk1b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/monk1b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/monk1b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/monk1b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.MUMMY4A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/mummy4a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/mummy4a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/mummy4a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/mummy4a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.PRIEST1A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/priest1a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest1a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest1a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest1a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.PRIEST1B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/priest1b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest1b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest1b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest1b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.PRIEST2A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/priest2a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest2a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest2a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest2a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.PRIEST2B,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/priest2b.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest2b.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest2b.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest2b.png",3,4,0,2,3,3,16,32)});
				put(Avatar.PRIEST3A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/priest3a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest3a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest3a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/priest3a.png",3,4,0,2,3,3,16,32)});
				put(Avatar.WITCH3A,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/avatars/witch3a.png",3,4,0,2,0,0,16,32),
						new AnimationInfo("res/game/graphic/avatars/witch3a.png",3,4,0,2,1,1,16,32),
						new AnimationInfo("res/game/graphic/avatars/witch3a.png",3,4,0,2,2,2,16,32),
						new AnimationInfo("res/game/graphic/avatars/witch3a.png",3,4,0,2,3,3,16,32)});
			}
		};
	}
	public static class effects{
		public static HashMap<Integer,AnimationInfo[]> explosions = new HashMap<Integer,AnimationInfo[]>(){
			{
				put(Sprite.EXPLOSION_1,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/explosion/explosion_1_big.png",4,3,0,3,0,2,42,42)
				});
			};
		};
	}
	public static class bubbles{
		public static HashMap<Integer,AnimationInfo[]> still = new HashMap<Integer,AnimationInfo[]>(){
			{
				put(Sprite.BUBBLE_1,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/bubbles/bubble_1.png",4,4,0,3,0,3,32,32)
				});
				put(Sprite.BUBBLE_2,new AnimationInfo[]{
						new AnimationInfo("res/game/graphic/bubbles/bubble_2.png",4,4,0,3,0,3,32,32)
				});
			};
		};
	}
}

