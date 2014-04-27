package com.hatrick.graphic;

import com.hatrick.resource.AnimationResource;
import com.hatrick.resource.ImageResource;

public class Element extends Sprite{
	
	
	public Element(int id,int type){
		setId(id);
		this.setType(type);
		this.setDirectional(false);
		//this.setScale(2.0f);
		ImageInfo [] img_infos = ImageResource.elements.still.get(type);
		for(ImageInfo info : img_infos){
			addImage(info);
		}
		/*AnimationInfo [] ani_infos = AnimationResource.avatars.walk.get(type);
		for(int i=0;i<ani_infos.length;i++){
			AnimationInfo info = ani_infos[i];
			addAnimation(ACTION_WALK+i,info);
			//Adjust the duration
			for(int j=0;j<this.getAnimation(i).getFrameCount();j++){
				this.getAnimation(i).setDuration(j, Stage.getMinDuration()*2);
			}
		}*/
	}
	
	@Override
	public boolean isActDirectional(int action) {
		// TODO Complete the function when new actions added.
		return false;
	}

	@Override
	public void moveTo(float x, float y) {
		this.setRotation((float) Math.toDegrees(Math.atan2(x-this.getX(),this.getY()-y)));
		//System.out.println(x-this.getX());
		this.setX((this.getX()+x)/2.0f);
		this.setY((this.getY()+y)/2.0f);
		//this.setX(x);
		//this.setY(y);
		//this.act(Element.ACTION_WALK);
		//System.out.println(this.getAction());
	}
}
