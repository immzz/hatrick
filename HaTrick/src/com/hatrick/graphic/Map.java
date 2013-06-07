package com.hatrick.graphic;

import com.hatrick.resource.MapResource;

public class Map {
	public static int SNOW = 1;
	private short floor[][];
	private short assets[][];
	private int height;
	private int width;
	
	public Map(int id){
		this.floor = MapResource.floors.get(id);
		this.assets = MapResource.assets.get(id);
		this.height = floor.length;
		this.width = floor[0].length;
	}

	public short[][] getFloor() {
		return floor;
	}

	public void setFloor(short floor[][]) {
		this.floor = floor;
	}

	public short[][] getAssets() {
		return assets;
	}

	public void setAssets(short assets[][]) {
		this.assets = assets;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public boolean reachable(int x,int y){
		return (assets[x][y] == 0);
	}
}
