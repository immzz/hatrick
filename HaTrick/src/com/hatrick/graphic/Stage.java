package com.hatrick.graphic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.hatrick.logic.Bomb;
import com.hatrick.logic.ClientLogic;
import com.hatrick.logic.Hero;
import com.hatrick.logic.Potion;

public class Stage {
	private static HashMap<Integer,Sprite> elements = new HashMap<Integer,Sprite>();
	private static AppGameContainer container = null;
	private static final int FPS_MAX = 30;
	private static com.hatrick.graphic.Map map;
	private static Camera camera = new Camera(800,600);
	public static int depth_floor = 0;
	public static int depth_bubble = 1000;
	public static int depth_potion = 1500;
	public static int depth_asserts_avater = 2000;
	public static int depth_exposion = 4000;

	public Stage(AppGameContainer container){
		setContainer(container);
	}



	public static void setContainer(AppGameContainer agc){
		container = agc;
	}

	/*when create a sprite, init it's depth for display，print the deeper sprite*/
	public static void initDepth(Sprite sprt) {
		
		if (sprt.getType() >= 10013 && sprt.getType() <= 10035) {
			sprt.setDepth(depth_floor);
			depth_floor++;
		}
		else if (sprt.getType() == 500 || sprt.getType() == 501) {
			sprt.setDepth(depth_bubble);
			depth_bubble++;
		}
		else if (sprt.isPotion()) {
			sprt.setDepth(depth_potion);
			depth_potion++;
		}
		else if (sprt.isAssertsAvatar()) {
			sprt.setDepth(depth_asserts_avater);
			depth_asserts_avater++;
		}
		else if (sprt.getType() == 200) {
			sprt.setDepth(depth_exposion);
			depth_exposion++;
		}
		System.out.println("Type:"+sprt.getType()+" Depth:"+sprt.getDepth());
	}

	/*switch depth of two sprite when necessary*/
	public static void switchDepth(Sprite sprt1,Sprite sprt2) {
		int depth1,depth2;
		depth1 = sprt1.getDepth();
		depth2 = sprt2.getDepth();
		sprt1.setDepth(depth2);
		sprt2.setDepth(depth1);
	}

	/*public static void resortDepth() {
		boolean found = false;
		Sprite sprt = null;
		Iterator iter = elements.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer,Sprite> entry = (Map.Entry) iter.next();
			sprt = entry.getValue();
			if(sprt.getLogicId() == hero.id){
				found = true;
				break;
			}
		}
		if(!found) {
			sprt = new Avatar(Sprite.getNextClientSpriteId(),Avatar.ASSASSIN1B);
			sprt.setLogicId(hero.id);
			Stage.add(sprt);
		}
	}*/
	
	//鎶婄墿浣撳姞鍏ュ埌鑸炲彴
	public static void add(Sprite sprt){
		elements.put(sprt.getId(), sprt);
		initDepth(sprt);
	}

	public static void remove(int id){
		elements.remove(id);
	}
	public static Sprite get(int id){
		return elements.get(id);
	}
	public static Sprite getLogic(int logic_id){
		boolean found = false;
		Sprite sprt = null;
		Iterator iter = elements.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer,Sprite> entry = (Map.Entry) iter.next();
			sprt = entry.getValue();
			if(sprt.getLogicId() == logic_id){
				found = true;
				break;
			}
		}
		if(!found) return null;
		return sprt;
	}

	public static void loadMap(int id){
		map = new com.hatrick.graphic.Map(id);
		short floor[][] = map.getFloor();
		short assets[][] = map.getAssets();
		int width = map.getWidth();
		int height = map.getHeight();
		boolean flags[][] = new boolean[height][width];
		for(int i = 0;i<height;i++){
			for(int j=0;j<width;j++){
				flags[i][j] = false;
			}
		}

		//load floor
		for(int i = 0;i<height;i++){
			for(int j=0;j<width;j++){
				if(flags[i][j]) continue;
				if(floor[i][j] == 0) continue;
				Element ele = new Element(Sprite.getNextClientSpriteId(),floor[i][j]);
				ele.setGraphicPosition((j+ele.getMWidth())*70 - ele.getWidth(), (i+ele.getMHeight())*70 - ele.getHeight());
				add(ele);
				//System.out.println("DepthFloor:"+ele.getDepth());
				//System.out.println(ele.getX()+","+ele.getY());
				//System.out.println(ele.getWidth()+","+ele.getHeight());
				//System.out.println(ele.getMWidth()+","+ele.getMHeight());
				for(int l=i;l<i+ele.getMHeight();l++){
					for(int m=j;m<j+ele.getMWidth();m++){
						flags[l][m] = true;
					}
				}
			}
		}

		for(int i = 0;i<height;i++){
			for(int j=0;j<width;j++){
				flags[i][j] = false;
			}
		}

		//load assets
		for(int i = 0;i<height;i++){
			for(int j=0;j<width;j++){
				if(flags[i][j]) continue;
				if(assets[i][j] == 0) continue;
				Element ele = new Element(Sprite.getNextClientSpriteId(),assets[i][j]);
				ele.setGraphicPosition((j+ele.getMWidth())*70 - ele.getWidth(), (i+ele.getMHeight())*70 - ele.getHeight());
				add(ele);
				//System.out.println("DepthAssets:"+ele.getDepth());
				//System.out.println(ele.getX()+","+ele.getY());
				//System.out.println(ele.getWidth()+","+ele.getHeight());
				//System.out.println(ele.getMWidth()+","+ele.getMHeight());
				for(int l=i;l<i+ele.getMHeight();l++){
					for(int m=j;m<j+ele.getMWidth();m++){
						flags[l][m] = true;
					}
				}
			}
		}
	}
	public static com.hatrick.graphic.Map getMap(){
		return map;
	}
	public static void display(){
		//Display the elements in order of their depth.
		
		List<Map.Entry<Integer, Sprite>> sprites =
				new ArrayList<Map.Entry<Integer, Sprite>>(elements.entrySet());

		Collections.sort(sprites, new Comparator<Map.Entry<Integer, Sprite>>() {   
			public int compare(Map.Entry<Integer, Sprite> o1, Map.Entry<Integer, Sprite> o2) {      
				//return (o2.getValue() - o1.getValue()); 
				return (int) (o1.getValue().getDepth() - o2.getValue().getDepth());
			}
		});

		for(Entry<Integer, Sprite> sprt_entry : sprites){
			sprt_entry.getValue().draw();
		}
	}
	
	private static boolean hasHero(ArrayList<Hero> list,int logic_id){
		for(int i=0;i<list.size();i++){
			if(list.get(i).id == logic_id){
				return true;
			}
		}
		return false;
	}
	
	private static boolean hasBomb(ArrayList<Bomb> list,int logic_id){
		for(int i=0;i<list.size();i++){
			if(list.get(i).id == logic_id){
				return true;
			}
		}
		return false;
	}
	
	public static void update(){
		//Scan Hero List
		ArrayList<Hero> list = ClientLogic.get_heros();
		for(int i=0;i<list.size();i++){
			Hero hero = list.get(i);
			Sprite sprt = getLogic(hero.id);
			//System.out.println("hero id:"+hero.id);
			if(sprt == null){
				//System.out.println("hero not found!");
				sprt = new Avatar(Sprite.getNextClientSpriteId(),Avatar.ASSASSIN1B);
				sprt.setLogicId(hero.id);
				Stage.add(sprt);
			}
			sprt.moveTo((float)hero.pos_x,(float)hero.pos_y);
			sprt.setLogicDirection(convertDirection(hero.direction));
		}
		//Scan Bomb List
		ArrayList<Bomb> bomb_list = ClientLogic.get_bombs();
		for(int i=0;i<bomb_list.size();i++){
			Bomb bomb = bomb_list.get(i);
			Sprite sprt = getLogic(bomb.id);
			System.out.println("exploding:"+bomb.isExploring());
			if(!bomb.isExploring()){
				if(sprt == null){
					sprt = new Bubble(Sprite.getNextClientSpriteId(),Bubble.BUBBLE_1);
					sprt.setLogicId(bomb.id);
					Stage.add(sprt);
				}
				sprt.moveTo((float)bomb.p_x*70+35, (float)bomb.p_y*70+25);
			}else{
				if(sprt == null) continue;
				//Create Explosion Effects
				for(int j=0;j<Bubble.DAMAGE_AREA.length;j++){
					int damage_x = bomb.p_x+Bubble.DAMAGE_AREA[j][0];
					int damage_y = bomb.p_y+Bubble.DAMAGE_AREA[j][1];
					if(map.reachable(damage_x, damage_y)){
						Effect explosion = new Effect(Sprite.getNextClientSpriteId(),Effect.EXPLOSION_1);
						explosion.setPosition(damage_x*70+35, damage_y*70+35);
						Stage.add(explosion);
					}
				}
				remove(sprt.getId());
			}
		}
		//Scan Potion List
		ArrayList<Potion> potion_list = ClientLogic.get_potions();
		for(int i=0;i<potion_list.size();i++){
			Potion potion = potion_list.get(i);
			Sprite sprt = getLogic(potion.id);
			if(sprt == null){
				sprt = new com.hatrick.graphic.Potion(Sprite.getNextClientSpriteId(),com.hatrick.graphic.Potion.POTION_1);
				sprt.setLogicId(potion.id);
				Stage.add(sprt);
			}
			sprt.moveTo((float)potion.p_x*70+35, (float)potion.p_y*70+35);
		}
		
		
		//Clean Heros & Potions & Finished Effects
		Sprite sprt = null;
		Iterator iter = elements.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer,Sprite> entry = (Map.Entry) iter.next();
			sprt = entry.getValue();
			if(sprt.isBubble() && !hasBomb(bomb_list,sprt.getLogicId())){
				iter.remove();
			}
			if(sprt.isExposion() && !sprt.isActing()){
				System.out.println("remove effects");
				iter.remove();
			}
			//
		}
		//Adjust Camera
		if(ClientLogic.myhero != null){
			camera.caculateCameraXY(map.getWidth()*70,map.getHeight()*70,(float)ClientLogic.myhero.pos_x,(float)ClientLogic.myhero.pos_y-35);
		}
	}
	private static int convertDirection(int logic_direction){
		return (logic_direction+2)%4;
	}

	public static int getFPS() {
		return container.getFPS();
	}

	public static int getCurrentDuration(){
		return 1000/getFPS();
	}

	public static int getMaxFPS() {
		return FPS_MAX;
	}
	public static int getMinDuration(){
		return 1000/FPS_MAX;
	}
	public static Camera getCamera() {
		return camera;

	}

	public static void setCamera(Camera camera) {
		Stage.camera = camera;
	}


}
