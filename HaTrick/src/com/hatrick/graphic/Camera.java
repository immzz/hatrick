package com.hatrick.graphic;

public class Camera {
	private float c_x;	//camera左上角相对于地图的横坐标
	private float c_y;	//camera左上角相对于地图的纵坐标
	private int c_width;	//camera的宽度
	private int c_height;	//camera的高度
	
	//初始化camera的起始位置为(0,0)和窗口大小
		public Camera(int width, int height) {
			c_x = 0;
			c_y = 0;
			c_width = width;
			c_height = height;
		}
	
	//可直接手工初始化camera的起始位置和窗口大小
	public Camera(int x, int y,int width, int height) {
		c_x = x;
		c_y = y;
		c_width = width;
		c_height = height;
	}
	
	//根据物体的中心坐标m_x,m_y和地图的size来计算camera的x，y
	public void Caculate_Camera_xy(int m_height, int m_width, float s_x, float s_y) {
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
	
	public void set_Camera_x(float x) {
		this.c_x = x;
	}

	public void set_Camera_y(float y) {
		this.c_y = y;
	}
	
	public float get_Camera_x() {
		return c_x;
	}

	public float get_Camera_y() {
		return c_y;
	}
	
}
