package com.hatrick.graphic;


import java.util.ArrayList;
import java.util.HashMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public abstract class Sprite {
	
	public static final int DIRECTION_NONE = 100;
	public static final int DIRECTION_UP = 3;
	public static final int DIRECTION_DOWN = 0;
	public static final int DIRECTION_LEFT = 1;
	public static final int DIRECTION_RIGHT = 2;
	public static final int [] DIRECTIONS = new int[]{DIRECTION_DOWN,DIRECTION_LEFT,DIRECTION_RIGHT,DIRECTION_UP};
	
	private static int CLIENT_SPRITE_ID_AVAILABLE = 1000000;
	
	private static final int ACTION_NONE = 1000000;
	
	private int _id;
	private float _x;
	private float _y;
	private float _rotation;//This is the rotation of movement.
	private float _graphic_rotation;//This is the rotation of graphic.
	private float _scale;
	private float _alpha;
	private boolean _directional;
	private boolean _visible;
	private boolean _acting;
	private int _action;//Action that the sprite is performing
	private int _nextAction;
	
	private HashMap<Integer,Image> _imgs;//arrange by direction
	private HashMap<Integer,Animation> _actions;//arrange by key
	private Image _currentImg;
	private Animation _currentAnimation;
	
	public Sprite(){
		_id = 0;
		_x = 0;
		_y = 0;
		_rotation = 0;
		_graphic_rotation = 0;
		_scale = 1.0f;
		_alpha = 1.0f;
		_directional = false;
		_visible = true;
		_acting = false;
		_action = ACTION_NONE;
		_nextAction = ACTION_NONE;
		_imgs = new HashMap<Integer,Image>();
		_actions = new HashMap<Integer,Animation>();
		_currentImg = null;
		_currentAnimation = null;
	}
	
	public Sprite(Sprite sprt){
		this._id = getNextClientSpriteId();
		this._x = sprt._x;
		this._y = sprt._y;
		this._rotation = sprt._rotation;
		this._graphic_rotation = sprt._graphic_rotation;
		this._scale = sprt._scale;
		this._alpha = sprt._alpha;
		this._directional = sprt._directional;
		this._visible = sprt._visible;
		this._acting = sprt._acting;
		this._action = sprt._action;
		this._nextAction = sprt._nextAction;
		this._imgs = new HashMap<Integer,Image>();
		this._actions = new HashMap<Integer,Animation>();
		this._imgs.putAll(sprt._imgs);
		this._actions.putAll(sprt._actions);
		_currentImg = sprt._currentImg;
		_currentAnimation = sprt._currentAnimation;
	}
	
	public void addImage(ImageInfo img_info){
		Image img = null;
		try {
			img = new Image(img_info.getSrc()).getSubImage(img_info.getSrcOffsetX(), img_info.getSrcOffsetY(), img_info.getWidth(), img_info.getHeight());
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		img.setCenterOfRotation(img_info.getCenterOffsetX(), img_info.getCenterOffsetY());
		_imgs.put(img_info.getDirection(), img);
	}
	
	public void addAnimation(int action_type,AnimationInfo ani_info){
		Image img = null;
		try {
			img = new Image(ani_info.getSrc());
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpriteSheet ss = new SpriteSheet(img,img.getWidth()/ani_info.getCols(),img.getHeight()/ani_info.getRows());
		Animation ani = new Animation(ss,ani_info.getStartCol(),ani_info.getStartRow(),ani_info.getEndCol(),ani_info.getEndRow(),true,Stage.getMinDuration(),true);
		for(int i=0;i<ani.getFrameCount();i++){
			ani.getImage(i).setCenterOfRotation(ani_info.getCenterOffsetX(), ani_info.getCenterOffsetY());
		}
		_actions.put(action_type, ani);
	}
	
	public void show(){
		_visible = true;
	}
	
	public void hide(){
		_visible = false;
	}
	
	public void draw(){
		if(!_visible) return;
		if(_acting){
			Animation _prevAnimation = _currentAnimation;
			if(isActDirectional(_action)){
				_currentAnimation = _actions.get(_action+getDirection());
			}else{
				_currentAnimation = _actions.get(_action);
			}
			if(_prevAnimation != null && _prevAnimation != _currentAnimation){
				//Simply check if the two animation point to the same object
				_prevAnimation.stop();
			}
			
			if(_currentAnimation.isStopped()){
				_currentAnimation.restart();
			}

			Image next_frame = _currentAnimation.getImage((1+_currentAnimation.getFrame())%_currentAnimation.getFrameCount());
			next_frame.setAlpha(_alpha);
			next_frame.setRotation(_graphic_rotation);
			Image current_frame = _currentAnimation.getCurrentFrame();
			current_frame.setAlpha(_alpha);
			current_frame.setRotation(_graphic_rotation);
			
			_currentAnimation.draw((int)(_x-current_frame.getCenterOfRotationX()*_scale),(int)(_y-current_frame.getCenterOfRotationY()*_scale), current_frame.getWidth()*_scale, current_frame.getHeight()*_scale);
			
			//Check if this animation is finished and if so switch to the next animation
			if(_currentAnimation.getFrame() == _currentAnimation.getFrameCount()-1){
				_currentAnimation.stop();
				_acting = false;
				_action = _nextAction;
				_nextAction = ACTION_NONE;
			}
		}else{
			if(_directional){
				_currentImg = _imgs.get(getDirection());
			}else{
				_currentImg = _imgs.get(DIRECTION_NONE);
			}
			_currentImg.setAlpha(_alpha);
			_currentImg.setRotation(_graphic_rotation);
			_currentImg.draw((int)(_x-_currentImg.getCenterOfRotationX()*_scale),(int)(_y-_currentImg.getCenterOfRotationY()*_scale), _currentImg.getWidth()*_scale, _currentImg.getHeight()*_scale);
		}
	}

	public void act(int type){
		if(_acting){
			_nextAction = type;
		}else{
			_acting = true;
			_action = type;
			_nextAction = ACTION_NONE;
		}
	}
	private void setCurrentImg(Image img){
		
	}
	private void setCurrentAnimation(Animation anmi){
		
	}
	protected int getDirection(){
		float real_deg =  ( 360 + (_rotation % 360 )) % 360;
		if(real_deg<=45||real_deg>=315){
			return DIRECTION_UP;
		}else if(real_deg>45&&real_deg<135){
			return DIRECTION_RIGHT;
		}else if(real_deg>=135&&real_deg<225){
			return DIRECTION_DOWN;
		}else{
			return DIRECTION_LEFT;
		}
	}
	
	public static int getNextClientSpriteId(){
		return CLIENT_SPRITE_ID_AVAILABLE++;
	}
	
	public float getX() {
		return _x;
	}
	public void setX(float _x) {
		this._x = _x;
	}
	public float getY() {
		return _y;
	}
	public void setY(float _y) {
		this._y = _y;
	}
	public void setPosition(float _x,float _y){
		this._x = _x;
		this._y = _y;
	}
	/** Get the rotation of movement.
	 * @return
	 */
	public float getRotation() {
		return _rotation;
	}
	/**Set the rotation of movement.
	 * @param _rotation
	 */
	public void setRotation(float _rotation) {
		this._rotation = _rotation;
	}
	/**Rotate the movement.
	 * @param deg
	 */
	public void rotate(float deg){
		this._rotation = (_rotation+deg)%360;
	}
	/** Get the rotation of graph.
	 * @return
	 */
	public float getGraphicRotation() {
		return _graphic_rotation;
	}
	/**Set the rotation of graph.
	 * @param _rotation
	 */
	public void setGraphicRotation(float _graphic_rotation) {
		this._graphic_rotation = _graphic_rotation;
	}
	/**Rotate the graph.
	 * @param deg
	 */
	public void rotateGraph(float deg){
		this._graphic_rotation = (_graphic_rotation+deg)%360;
	}
	public float getScale() {
		return _scale;
	}
	public void setScale(float _scale) {
		this._scale = _scale;
	}
	public float getAlpha() {
		return _alpha;
	}
	public void setAlpha(float _alpha) {
		this._alpha = (_alpha>1)?1:_alpha;
	}
	public boolean isVisible() {
		return _visible;
	}
	public int getWidth() {
		if(_acting){
			return (int) (_currentAnimation.getCurrentFrame().getWidth()*_scale);
		}
		return (int) (_currentImg.getWidth()*_scale);
	}
	public int getHeight() {
		if(_acting){
			return (int) (_currentAnimation.getCurrentFrame().getHeight()*_scale);
		}
		return (int) (_currentImg.getHeight()*_scale);
	}
	
	public boolean isActing() {
		return _acting;
	}

	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public int getAction() {
		return _action;
	}

	public void setAction(int _action) {
		this._action = _action;
	}
	
	protected void setDirectional(boolean _directional){
		this._directional = _directional;
	}
	protected Animation getAnimation(int ani_type){
		return _actions.get(ani_type);
	}

	/** Tell if the action is directional, must be implemented in subclasses.
	 * @param action
	 * @return
	 */
	public abstract boolean isActDirectional(int action);
	
	/**Move the sprite to the given position.
	 * @param f
	 * @param g
	 */
	public abstract void moveTo(float f,float g);
	
}
