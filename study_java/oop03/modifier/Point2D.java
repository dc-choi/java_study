package oop03.modifier;

public class Point2D {
	private int x; // 클래스 내부
	// (default) int x; // 클래스 내부, 같은 패키지
	// protected int x; // 클래스 내부, 같은 패키지, 상속
	// public int x; // 전부
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
