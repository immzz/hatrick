
package com.hatrick.server;

import java.io.Serializable;

 public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1712336124771016842L;
	public static final int TYPE_HEART_BEAT = 1;
	public static final int TYPE_OPERATION = 2;
	public static final int TYPE_HERO = 3;
	public static final int TYPE_INIT = 4;
	public static final int TYPE_BOMB = 5;

	public int type;
	private Long time;
	private Serializable obj;

	public Message(int type, Long time, Serializable obj) {
		this.set_obj(obj);
		this.set_time(time);
		this.set_type(type);
	}
	public Message(){
		
	}
	public void set_time(Long time) {
		this.time = time;
	}

	public void set_obj(Serializable obj) {
		this.obj = obj;
	}

	public void set_type(int type) {
		this.type = type;
	}

	public int get_type() {
		return type;
	}

	public Long get_time() {
		return time;
	}

	public Serializable get_obj() {
		return obj;
	}
}

