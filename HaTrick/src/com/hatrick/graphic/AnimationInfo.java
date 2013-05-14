package com.hatrick.graphic;

public class AnimationInfo {
	private String src;
	private int cols;
	private int rows;
	private int startCol;
	private int endCol;
	private int startRow;
	private int endRow;
	private int centerOffsetX;
	private int centerOffsetY;
	public AnimationInfo(String src,int cols,int rows,int startCol,int endCol,int startRow,int endRow,int centerOffsetX,int centerOffsetY){
		this.src = src;
		this.cols = cols;
		this.rows = rows;
		this.startCol = startCol;
		this.endCol = endCol;
		this.startRow = startRow;
		this.endRow = endRow;
		this.setCenterOffsetX(centerOffsetX);
		this.setCenterOffsetY(centerOffsetY);
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getFrameCount() {
		return cols*(endRow-startRow)+endCol-startCol+1;
	}
	public int getStartCol() {
		return startCol;
	}
	public void setStartCol(int startCol) {
		this.startCol = startCol;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndCol() {
		return endCol;
	}
	public void setEndCol(int endCol) {
		this.endCol = endCol;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
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
	
}
