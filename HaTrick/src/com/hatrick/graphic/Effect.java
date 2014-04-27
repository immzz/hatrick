package com.hatrick.graphic;

import com.hatrick.resource.AnimationResource;
import com.hatrick.resource.ImageResource;
import com.hatrick.graphic.AnimationInfo;

public class Effect extends Sprite{
	
	public static final int [] EXPLOSIONS = new int[]{EXPLOSION_1};
	
	public Effect(int id,int type){
		setId(id);
		setType(type);
		this.setDirectional(false);
		this.setScale(1.0f);
		AnimationInfo [] ani_infos = null;
		switch(type){
		case EXPLOSION_1:
			ani_infos = AnimationResource.effects.explosions.get(type);
		break;
		default:break;
		}
		
		addAnimation(0,ani_infos[0]);
		//Adjust the duration
		for(int j=0;j<this.getAnimation(0).getFrameCount();j++){
			this.getAnimation(0).setDuration(j, Stage.getMinDuration()*2);
		}
		
		this.act(0);
	}
	
	@Override
	public boolean isActDirectional(int action) {
		return false;
	}

	@Override
	public void moveTo(float x, float y) {
		this.setRotation((float) Math.toDegrees(Math.atan2(x-this.getX(),this.getY()-y)));
		//System.out.println(x-this.getX());
		//this.setX((this.getX()+x)/2.0f);
		//this.setY((this.getY()+y)/2.0f);
		this.setX(x);
		this.setY(y);
		
		//System.out.println(this.getAction());
	}
}
