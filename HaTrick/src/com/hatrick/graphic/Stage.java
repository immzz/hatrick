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
	private static Camera camera = new Camera(0,0);
	
	private static float c_x;	//camera宸︿笂瑙掔浉瀵逛簬鍦板浘鐨勬í鍧愭爣
	private static float c_y;	//camera宸︿笂瑙掔浉瀵逛簬鍦板浘鐨勭旱鍧愭爣
	private static int c_width;	//camera鐨勫搴�
	private static int c_height;	//camera鐨勯珮搴�
	
	public static int depth = 0;
	
	public Stage(AppGameContainer container){
		setContainer(container);
		c_x = 0;
		c_y = 0;
	}
	
	//璁剧疆camera澶у皬
	public void set_Camera_size(int width, int height) {
		c_width = width;
		c_height = height;
	}

	public static void setContainer(AppGameContainer agc){
		container = agc;
	}
	
	//鏍规嵁鐗╀綋鐨勪腑蹇冨潗鏍噈_x,m_y鍜屽湴鍥剧殑size鏉ヨ绠梒amera鐨剎锛寉
	public static void Caculate_Camera_xy(int m_height, int m_width, float s_x, float s_y) {
		//璁＄畻camera鐨剎
		if (s_x < c_width/2) {
			c_x = 0;
		}
		else if (s_x > m_width - c_width/2) {
			c_x = m_width - c_width;
		}
		else {
			c_x = s_x - c_width/2;
		}
		//璁＄畻camera鐨剏
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
	
	//鑾峰緱camera宸︿笂瑙掔殑x鍜寉
	public static float get_Camera_x() {
		return c_x;
	}

	public static float get_Camera_y() {
		return c_y;
	}

	public static Camera getCamera() {
		return camera;
	}

	public static void setCamera(Camera camera) {
		Stage.camera = camera;
	}
	
}
