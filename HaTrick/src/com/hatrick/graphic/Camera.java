package com.hatrick.graphic;

public class Camera {
	private float c_x;	//camera宸︿笂瑙掔浉瀵逛簬鍦板浘鐨勬í鍧愭爣
	private float c_y;	//camera宸︿笂瑙掔浉瀵逛簬鍦板浘鐨勭旱鍧愭�?
	private int c_width;	//camera鐨勫搴�?
	private int c_height;	//camera鐨勯珮搴�?
	
	//初始化camera的起始位置为(0,0)和窗口大�?
	public Camera(int width, int height) {
			c_x = 0;
			c_y = 0;
			c_width = width;
			c_height = height;
	}
	
	//鍙洿鎺ユ墜宸ュ垵濮嬪寲camera鐨勮捣濮嬩綅缃拰绐楀彛澶у�?
	public Camera(int x, int y,int width, int height) {
		c_x = x;
		c_y = y;
		c_width = width;
		c_height = height;
	}
	//根据物体的中心坐标m_x,m_y和地图的size来计算camera的x，y
	public void caculateCameraXY(int m_width, int m_height, float s_x, float s_y) {
		//计算camera的x
		float new_c_x;
		float new_c_y;
		if (s_x < c_width/2) {
			new_c_x = 0;
		}
		else if (s_x > m_width - c_width/2) {
			new_c_x = m_width - c_width;
		}
		else {
			new_c_x = s_x - c_width/2;
		}
		//璁＄畻camera鐨剏
		if (s_y < c_height/2) {
			new_c_y = 0;
		}
		else if (s_y > m_height - c_height/2) {
			new_c_y = m_height - c_height;
		}
		else {
			new_c_y = s_y - c_height/2;
		}
		c_x = (c_x+new_c_x)/2.0f;
		c_y = (c_y+new_c_y)/2.0f;
		
	}
	
	public void setCameraX(float x) {
		this.c_x = x;
	}

	public void setCameraY(float y) {
		this.c_y = y;
	}
	
	public void setPosition(float x,float y) {
		this.c_x = x;
		this.c_y = y;
	}
	
	public float getCameraX() {

		return c_x;
	}

	public float getCameraY() {
		return c_y;
	}
	
}
