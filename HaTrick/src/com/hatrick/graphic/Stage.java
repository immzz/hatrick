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

import com.hatrick.logic.ClientLogic;
import com.hatrick.logic.Hero;

public class Stage {
	private static HashMap<Integer,Sprite> elements = new HashMap<Integer,Sprite>();
	private static AppGameContainer container = null;
	private static final int FPS_MAX = 30;
	private static com.hatrick.graphic.Map map;
	private static Camera camera = new Camera(800,600);
	public static int depth = 0;

	public Stage(AppGameContainer container){
		setContainer(container);
	}



	public static void setContainer(AppGameContainer agc){
		container = agc;
	}

	/*when create a sprite, init it's depth for display*/
	public static void initDepth(Sprite sprt) {
		sprt.setDepth(depth);
		depth++;
	}

	/*switch depth of two sprite when necessary*/
	public static void switchDepth(Sprite sprt1,Sprite sprt2) {
		int depth1,depth2;
		depth1 = sprt1.getDepth();
		depth2 = sprt2.getDepth();
		sprt1.setDepth(depth2);
		sprt2.setDepth(depth1);
	}

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
				System.out.println("DepthFloor:"+ele.getDepth());
				System.out.println(ele.getX()+","+ele.getY());
				System.out.println(ele.getWidth()+","+ele.getHeight());
				System.out.println(ele.getMWidth()+","+ele.getMHeight());
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
				System.out.println("DepthAssets:"+ele.getDepth());
				System.out.println(ele.getX()+","+ele.getY());
				System.out.println(ele.getWidth()+","+ele.getHeight());
				System.out.println(ele.getMWidth()+","+ele.getMHeight());
				for(int l=i;l<i+ele.getMHeight();l++){
					for(int m=j;m<j+ele.getMWidth();m++){
						flags[l][m] = true;
					}
				}
			}
		}
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
	public static void update(){
		ArrayList<Hero> list = ClientLogic.get_heros();
		for(int i=0;i<list.size();i++){
			boolean found = false;
			Hero hero = list.get(i);
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
			if(!found){
				sprt = new Avatar(Sprite.getNextClientSpriteId(),Avatar.ASSASSIN1B);
				sprt.setLogicId(hero.id);
				Stage.add(sprt);
			}
			sprt.moveTo((float)hero.pos_x,(float)hero.pos_y);
			
		}
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
