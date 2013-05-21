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

public class Stage {
	private static HashMap<Integer,Sprite> elements = new HashMap<Integer,Sprite>();
	private static AppGameContainer container = null;
	private static final int FPS_MAX = 30;
	private static com.hatrick.graphic.Map map;
	
	private static float c_x;	//camera左上角相对于地图的横坐标
	private static float c_y;	//camera左上角相对于地图的纵坐标
	private static int c_width;	//camera的宽度
	private static int c_height;	//camera的高度
	
	public static int depth = 0;
	
	public Stage(AppGameContainer container){
		setContainer(container);
		c_x = 0;
		c_y = 0;
	}
	
	//设置camera大小
	public void set_Camera_size(int width, int height) {
		c_width = width;
		c_height = height;
	}

	public static void setContainer(AppGameContainer agc){
		container = agc;
	}
	
	//根据物体的中心坐标m_x,m_y和地图的size来计算camera的x，y
	public static void Caculate_Camera_xy(int m_height, int m_width, float s_x, float s_y) {
		//计算camera的x
		if (s_x < c_width/2) {
			c_x = 0;
		}
		else if (s_x > m_width - c_width/2) {
			c_x = m_width - c_width;
		}
		else {
			c_x = s_x - c_width/2;
		}
		//计算camera的y
		if (s_y < c_height/2) {
			c_y = 0;
		}
		else if (s_y > m_height - c_height/2) {
			c_y = m_height - c_height;
		}
		else {
			c_y = s_y - c_height/2;
		}
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
	
	//把物体加入到舞台
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
		for(int i = 0;i<height;i++){
			for(int j=0;j<width;j++){
				if(flags[i][j]) continue;
				if(floor[i][j] == 0) continue;
				Element ele = new Element(Sprite.getNextClientSpriteId(),floor[i][j]);
				ele.setGraphicPosition((j+ele.getMWidth())*70 - ele.getWidth(), (i+ele.getMHeight())*70 - ele.getHeight());
				add(ele);
				System.out.println("Depth:"+ele.getDepth());
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
				return (int) (o2.getValue().getDepth() - o1.getValue().getDepth());
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
	
	//获得camera左上角的x和y
	public static float get_Camera_x() {
		return c_x;
	}

	public static float get_Camera_y() {
		return c_y;
	}
	
}
