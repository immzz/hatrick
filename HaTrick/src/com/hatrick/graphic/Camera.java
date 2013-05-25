package com.hatrick.graphic;

public class Camera {
	private float c_x;	//camera宸︿笂瑙掔浉瀵逛簬鍦板浘鐨勬í鍧愭爣
	private float c_y;	//camera宸︿笂瑙掔浉瀵逛簬鍦板浘鐨勭旱鍧愭爣
	private int c_width;	//camera鐨勫搴�
	private int c_height;	//camera鐨勯珮搴�
	
	//鍒濆鍖朿amera鐨勮捣濮嬩綅缃负(0,0)鍜岀獥鍙ｅぇ灏�
		public Camera(int width, int height) {
			c_x = 0;
			c_y = 0;
			c_width = width;
			c_height = height;
		}
	
	//鍙洿鎺ユ墜宸ュ垵濮嬪寲camera鐨勮捣濮嬩綅缃拰绐楀彛澶у皬
	public Camera(int x, int y,int width, int height) {
		c_x = x;
		c_y = y;
		c_width = width;
		c_height = height;
	}
	
	//鏍规嵁鐗╀綋鐨勪腑蹇冨潗鏍噈_x,m_y鍜屽湴鍥剧殑size鏉ヨ绠梒amera鐨剎锛寉
	public void Caculate_Camera_xy(int m_height, int m_width, float s_x, float s_y) {
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
	
	public void set_Camera_x(float x) {
		this.c_x = x;
	}

	public void set_Camera_y(float y) {
		this.c_y = y;
	}
	public void setPosition(float x,float y){
		this.c_x = x;
		this.c_y = y;
	}
	public float get_Camera_x() {
		return c_x;
	}

	public float get_Camera_y() {
		return c_y;
	}
	
}
