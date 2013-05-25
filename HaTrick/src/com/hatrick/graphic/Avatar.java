package com.hatrick.graphic;

import com.hatrick.resource.AnimationResource;
import com.hatrick.resource.ImageResource;
import com.hatrick.graphic.AnimationInfo;

public class Avatar extends Sprite{
	
	public static final int [] ASSASSINS = new int[]{ASSASSIN1A,ASSASSIN1B,ASSASSIN2A,ASSASSIN3A,ASSASSIN3B,ASSASSIN4A};
	public static final int [] CRUSADERS = new int[]{CRUSADER1A,CRUSADER1B};
	public static final int [] DAEMONS = new int[]{DAEMON2A};
	public static final int [] WITCHES = new int[]{WITCH3A};
	public static final int [] MUMMIES = new int[]{MUMMY4A};
	public static final int [] COLLABOS = new int[]{COLLABO1A,COLLABO1B};
	public static final int [] DANCERS = new int[]{DANCER1A,DANCER1B};
	public static final int [] GUNSLINGERS = new int[]{GUNSLINGER1A,GUNSLINGER1B};
	public static final int [] KNIGHTS = new int[]{KNIGHT1A,KNIGHT1B,KNIGHT2A,KNIGHT2B,KNIGHT3A,KNIGHT3B,KNIGHT4A,KNIGHT5A};
	public static final int [] MAGICIANS = new int[]{MAGICIAN1A,MAGICIAN2A,MAGICIAN3A,MAGICIAN3B,MAGICIAN4A,MAGICIAN4B,MAGICIAN5A,MAGICIAN5B,MAGICIAN6A,MAGICIAN6B};
	public static final int [] MONKS = new int[]{MONK1A,MONK1B};
	public static final int [] PRIESTS = new int[]{PRIEST1A,PRIEST1B,PRIEST2A,PRIEST2B,PRIEST3A};
	
	
	public static final int ACTION_WALK = 0;
	
	public Avatar(int id,int type){
		setId(id);
		this.setDirectional(true);
		this.setScale(2.0f);
		ImageInfo [] img_infos = ImageResource.avatars.stand.get(type);
		if(img_infos == null) return;
		for(ImageInfo info : img_infos){
			addImage(info);
		}
		AnimationInfo [] ani_infos = AnimationResource.avatars.walk.get(type);
		for(int i=0;i<ani_infos.length;i++){
			AnimationInfo info = ani_infos[i];
			addAnimation(ACTION_WALK+i,info);
			//Adjust the duration
			for(int j=0;j<this.getAnimation(i).getFrameCount();j++){
				this.getAnimation(i).setDuration(j, Stage.getMinDuration()*2);
			}
		}
	}
	
	@Override
	public boolean isActDirectional(int action) {
		// TODO Complete the function when new actions added.
		switch(action){
		case ACTION_WALK:
			return true;
		default:return false;
		}
	}

	@Override
	public void moveTo(float x, float y) {
		this.setRotation((float) Math.toDegrees(Math.atan2(x-this.getX(),this.getY()-y)));
		//System.out.println(x-this.getX());
		this.setX((this.getX()+x)/2.0f);
		this.setY((this.getY()+y)/2.0f);
		//this.setX(x);
		//this.setY(y);
		this.act(Avatar.ACTION_WALK);
		//System.out.println(this.getAction());
	}
}
