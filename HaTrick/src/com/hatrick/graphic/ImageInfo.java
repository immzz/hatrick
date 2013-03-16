package com.hatrick.graphic;

public class ImageInfo {
	private String src;
	private int direction;
	private int srcOffsetX;
	private int srcOffsetY;
	private int centerOffsetX;
	private int centerOffsetY;
	private int width;
	private int height;

	public ImageInfo(String src,int direction,int sofx,int sofy,int centerOffsetX,int centerOffsetY,int width,int height){
		this.setSrc(src);
		this.setDirection(direction);
		this.setSrcOffsetX(sofx);
		this.setSrcOffsetY(sofy);
		this.setCenterOffsetX(centerOffsetX);
		this.setCenterOffsetY(centerOffsetY);
		this.setWidth(width);
		this.setHeight(height);
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public int getSrcOffsetX() {
		return srcOffsetX;
	}
	public void setSrcOffsetX(int srcOffsetX) {
		this.srcOffsetX = srcOffsetX;
	}
	public int getSrcOffsetY() {
		return srcOffsetY;
	}
	public void setSrcOffsetY(int srcOffsetY) {
		this.srcOffsetY = srcOffsetY;
	}
	public int getCenterOffsetX() {
		return centerOffsetX;
	}
	public void setCenterOffsetX(int centerOffsetX) {
		this.centerOffsetX = centerOffsetX;
	}
	public int getCenterOffsetY() {
		return centerOffsetY;
	}
	public void setCenterOffsetY(int centerOffsetY) {
		this.centerOffsetY = centerOffsetY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
}
