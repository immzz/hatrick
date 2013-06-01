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

	public Stage(AppGameContainer container){
		setContainer(container);
	}

	public static void setContainer(AppGameContainer agc){
		container = agc;
	}

	public static void add(Sprite sprt){
		elements.put(sprt.getId(), sprt);
	}

	public static void remove(int id){
		elements.remove(id);
	}
	public static Sprite get(int id){
		return elements.get(id);
	}
	public static Sprite getLogic(int id){
		Iterator iter = elements.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<Integer, Sprite> entry = (Entry<Integer, Sprite>) iter.next();
			Sprite sprt = entry.getValue();
			System.out.println(sprt.getId());
			if(sprt.getLogicId() == id){
				return sprt;
			}
		}
		return null;
	}
	
	public static void clean(){
		elements.clear();
	}
	
	public static void update(){
		ArrayList<Hero> heroes = ClientLogic.get_heros();
		//System.out.println("size:"+heroes.size());
		
		for(Hero hero: heroes){
			Sprite sprt = Stage.getLogic(hero.id);
			if(sprt == null){
				System.out.println("new sprite");
				Avatar avt = new Avatar(Sprite.getNextClientSpriteId(), Sprite.DAEMON2A);
				avt.setLogicId(hero.id);
				avt.setPosition(hero.pos_x, hero.pos_y);
				Stage.add(avt);
				sprt = avt;
			}
			sprt.moveTo((float)hero.pos_x,(float)hero.pos_y);
		}
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
		for(int i = 0;i<height;i++){
			for(int j=0;j<width;j++){
				if(flags[i][j]) continue;
				if(floor[i][j] == 0) continue;
				Element ele = new Element(Sprite.getNextClientSpriteId(),floor[i][j]);
				ele.setGraphicPosition((j+ele.getMWidth())*70 - ele.getWidth(), (i+ele.getMHeight())*70 - ele.getHeight());
				add(ele);
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
				return (int) (o1.getValue().getY() - o2.getValue().getY());
			}
		});

		for(Entry<Integer, Sprite> sprt_entry : sprites){
			sprt_entry.getValue().draw();
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
}
