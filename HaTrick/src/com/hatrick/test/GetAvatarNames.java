package com.hatrick.test;

import java.io.File;

import com.hatrick.graphic.AnimationInfo;
import com.hatrick.graphic.Avatar;

public class GetAvatarNames {
	public static void main(String [] args){
		File dir = new File("res/game/graphic/avatars");
		File [] files = dir.listFiles();
		int i = -1;
		for(File file : files){
			String name = file.getName().substring(0,file.getName().indexOf("."));
			/*System.out.println("put(Avatar."+name.toUpperCase()+",new ImageInfo[]{new ImageInfo(\"res/game/graphic/avatars/"+name+".png\",Sprite.DIRECTION_DOWN,32,0,16,32,32,32)\n" +
					",new ImageInfo(\"res/game/graphic/avatars/"+name+".png\",Sprite.DIRECTION_LEFT,32,32,16,32,32,32)\n" +
							",new ImageInfo(\"res/game/graphic/avatars/"+name+".png\",Sprite.DIRECTION_RIGHT,32,64,16,32,32,32)\n" +
									",new ImageInfo(\"res/game/graphic/avatars/"+name+".png\",Sprite.DIRECTION_UP,32,96,16,32,32,32)});");
			*/
			System.out.println("put(Avatar."+name.toUpperCase()+",new AnimationInfo[]{\nnew AnimationInfo(\"res/game/graphic/avatars/"+name+".png\",3,4,0,2,0,0,16,32),\nnew AnimationInfo(\"res/game/graphic/avatars/"+name+".png\",3,4,0,2,1,1,16,32),\nnew AnimationInfo(\"res/game/graphic/avatars/"+name+".png\",3,4,0,2,2,2,16,32),\nnew AnimationInfo(\"res/game/graphic/avatars/"+name+".png\",3,4,0,2,3,3,16,32)});");
		}
	}
}
