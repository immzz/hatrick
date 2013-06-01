package com.hatrick.graphic;


import java.util.ArrayList;
import java.util.HashMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public abstract class Sprite {
	
	/* Avatars */
	public static final int CRUSADER1A = 6;
	public static final int CRUSADER1B = 7;
	public static final int DAEMON2A = 8;
	public static final int WITCH3A = 9;
	public static final int MUMMY4A = 10;
	public static final int COLLABO1A = 11;
	public static final int COLLABO1B = 12;
	public static final int DANCER1A = 13;
	public static final int DANCER1B = 14;
	public static final int GUNSLINGER1A = 17;
	public static final int GUNSLINGER1B = 18;
	public static final int KNIGHT1A = 19;
	public static final int KNIGHT1B = 20;
	public static final int KNIGHT2A = 21;
	public static final int KNIGHT2B = 22;
	public static final int KNIGHT3A = 23;
	public static final int KNIGHT3B = 24;
	public static final int KNIGHT4A = 25;
	public static final int KNIGHT5A = 26;
	public static final int MAGICIAN1A = 27;
	public static final int MAGICIAN2A = 28;
	public static final int MAGICIAN3A = 29;
	public static final int MAGICIAN3B = 30;
	public static final int MAGICIAN4A = 31;
	public static final int MAGICIAN4B = 32;
	public static final int MAGICIAN5A = 33;
	public static final int MAGICIAN5B = 34;
	public static final int MAGICIAN6A = 35;
	public static final int MAGICIAN6B = 36;
	public static final int MONK1A = 37;
	public static final int MONK1B = 38;
	public static final int PRIEST1A = 39;
	public static final int PRIEST1B = 40;
	public static final int PRIEST2A = 41;
	public static final int PRIEST2B = 42;
	public static final int PRIEST3A = 43;
	public static final int ASSASSIN1A = 44;
	public static final int ASSASSIN1B = 45;
	public static final int ASSASSIN2A = 46;
	public static final int ASSASSIN3A = 47;
	public static final int ASSASSIN3B = 48;
	public static final int ASSASSIN4A = 49;
	
	/* Explosions */
	public static final int EXPLOSION_1 = 200;
	
	/* Bubbles */
	public static final int BUBBLE_1 = 500;
	public static final int BUBBLE_2 = 501;
	/* Elements */
	public static final int SNOW_DUCK_1 = 10000;/* 2��1 */
	public static final int SNOW_DUCK_2 = 10001;/* 2��1 */
	public static final int SNOW_DUCK_3 = 10002;/* 2��1 */
	public static final int SNOW_ICEBLOCK_1 = 10003;/* 1��1 */
	public static final int SNOW_ICEBLOCK_2 = 10004;/* 1��1 */
	public static final int SNOW_ICEBLOCK_3 = 10005;/* 1��1 */
	public static final int SNOW_ICEBLOCK_4 = 10006;/* 1��1 */
	public static final int SNOW_CAGE = 10007;/* 1��1 */
	//public static final int SNOW_STATUE_1 = 10008;/* 2��4 */
	public static final int SNOW_STATUE_2 = 10009;/* 2��4 */
	public static final int SNOW_PLANT = 10010;/* 2��1 */
	public static final int SNOW_GRASS_1 = 10011;/* 1��1 */
	public static final int SNOW_GRASS_2 = 10012;/* 1��1 */
	public static final int SNOW_FLOOR_1 = 10013;/* 1��1 */
	public static final int SNOW_FLOOR_2 = 10014;/* 1��1 */
	public static final int SNOW_FLOOR_3 = 10015;/* 1��1 */
	public static final int SNOW_FLOOR_4 = 10016;/* 1��1 */
	public static final int SNOW_FLOOR_5 = 10017;/* 1��1 */
	public static final int SNOW_FLOOR_6 = 10018;/* 1��1 */
	public static final int SNOW_FLOOR_7 = 10019;/* 1��1 */
	public static final int SNOW_FLOOR_8 = 10020;/* 1��1 */
	public static final int SNOW_ROAD_CURVE_1 = 10021;/* 2��2 */
	public static final int SNOW_ROAD_CURVE_2 = 10022;/* 2��2 */
	public static final int SNOW_ROAD_CURVE_3 = 10023;/* 2��2 */
	public static final int SNOW_ROAD_CURVE_4 = 10024;/* 2��2 */
	public static final int SNOW_ROAD_CURVE_5 = 10025;/* 2��2 */
	public static final int SNOW_ROAD_CURVE_6 = 10026;/* 2��2 */
	public static final int SNOW_ROAD_CURVE_7 = 10027;/* 2��2 */
	public static final int SNOW_ROAD_CURVE_8 = 10028;/* 2��2 */
	//public static final int SNOW_ROAD_HOR_1 = 10029;
	public static final int SNOW_ROAD_HOR_2 = 10030;/* 1��1 */
	//public static final int SNOW_ROAD_HOR_3 = 10031;
	public static final int SNOW_ROAD_HOR_4 = 10032;/* 1��1 */
	//public static final int SNOW_ROAD_VER_1 = 10032;
	public static final int SNOW_ROAD_VER_2 = 10033;/* 1��1 */
	//public static final int SNOW_ROAD_VER_3 = 10034;
	public static final int SNOW_ROAD_VER_4 = 10035;/* 1��1 */
	
	
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
	private float _graphicRotation;//This is the rotation of graphic.
	private float _scale;
	private float _alpha;
	private boolean _directional;
	private boolean _visible;
	private boolean _acting;
	private int _action;//Action that the sprite is performing
	private int _nextAction;
	private boolean _loop;
	private int _depth; //sprite's depth to control display, less deeper,later display  
	private int m_width;
	private int m_height;
	
	private HashMap<Integer,Image> _imgs;//arrange by direction
	private HashMap<Integer,Animation> _actions;//arrange by key
	private Image _currentImg;
	private Animation _currentAnimation;
	
	public Sprite(){
		_id = 0;
		_x = 0;
		_y = 0;
		_rotation = 0;
		_graphicRotation = 0;
		_scale = 1.0f;
		_alpha = 1.0f;
		_directional = false;
		_visible = true;
		_acting = false;
		_action = ACTION_NONE;
		_nextAction = ACTION_NONE;
		_loop = false;
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
		this._graphicRotation = sprt._graphicRotation;
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
		if(_currentImg == null) _currentImg = img;
		m_width = img_info.getMWidth();
		m_height = img_info.getMHeight();
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
			next_frame.setRotation(_graphicRotation);
			Image current_frame = _currentAnimation.getCurrentFrame();
			current_frame.setAlpha(_alpha);
			current_frame.setRotation(_graphicRotation);
			
			/*draw参数是相对于舞台左上角，x，y是相对与地图左上角，换成camera视角*/
			_currentAnimation.draw((int)((_x-current_frame.getCenterOfRotationX()*_scale)-Stage.getCamera().getCameraX()),(int)((_y-current_frame.getCenterOfRotationY()*_scale)-Stage.getCamera().getCameraY()), current_frame.getWidth()*_scale, current_frame.getHeight()*_scale);

			
			//Check if this animation is finished and if so switch to the next animation
			if(_currentAnimation.getFrame() == _currentAnimation.getFrameCount()-1){
				if(!_loop){
					_currentAnimation.stop();
					_acting = false;
					_action = _nextAction;
					_nextAction = ACTION_NONE;
				}
			}
		}else{
			if(_currentImg == null) return;
			if(_directional){
				_currentImg = _imgs.get(getDirection());
			}else{
				_currentImg = _imgs.get(DIRECTION_NONE);
			}
			_currentImg.setAlpha(_alpha);
			_currentImg.setRotation(_graphicRotation);
			_currentImg.draw((int)((_x-_currentImg.getCenterOfRotationX()*_scale)-Stage.getCamera().getCameraX()),(int)((_y-_currentImg.getCenterOfRotationY()*_scale)-Stage.getCamera().getCameraY()), _currentImg.getWidth()*_scale, _currentImg.getHeight()*_scale);
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
	/** Set the topleft corner to the given position
	 * @param _x
	 * @param _y
	 */
	public void setGraphicPosition(float _x,float _y){
		if(_acting){
			Image current_frame = _currentAnimation.getCurrentFrame();
			this._x = _x + current_frame.getCenterOfRotationX()*_scale;
			this._y = _y + current_frame.getCenterOfRotationY()*_scale;
		}else{
			this._x = _x + _currentImg.getCenterOfRotationX()*_scale;
			this._y = _y + _currentImg.getCenterOfRotationY()*_scale;
		}
		
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
		return _graphicRotation;
	}
	/**Set the rotation of graph.
	 * @param _rotation
	 */
	public void setGraphicRotation(float _graphicRotation) {
		this._graphicRotation = _graphicRotation;
	}
	/**Rotate the graph.
	 * @param deg
	 */
	public void rotateGraph(float deg){
		this._graphicRotation = (_graphicRotation+deg)%360;
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

	public void setMWidth(int m_width) {
		this.m_width = m_width;
	}

	public int getMHeight() {
		return m_height;
	}

	public void setMHeight(int m_height) {
		this.m_height = m_height;
	}

	public int getMWidth() {
		return m_width;
	}
	
	public void setDepth(int depth) {
		this._depth = depth;
	}
	
	public int getDepth() {
		return this._depth;
	}

	public boolean isLoop() {
		return _loop;
	}

	public void setLoop(boolean _loop) {
		this._loop = _loop;
	}
}

