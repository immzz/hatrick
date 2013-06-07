package com.hatrick.graphic;

import com.hatrick.resource.AnimationResource;
import com.hatrick.resource.ImageResource;
import com.hatrick.graphic.AnimationInfo;

public class Potion extends Sprite{
	
	public static final int [] POTIONS = new int[]{POTION_1};
	public Potion(int id,int type){
		setId(id);
		setType(type);
		this.setDirectional(false);
		this.setLoop(true);
		this.setScale(1.0f);
		AnimationInfo [] ani_infos = AnimationResource.bubbles.still.get(type);
		AnimationInfo info = ani_infos[0];
		addAnimation(0,info);
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
