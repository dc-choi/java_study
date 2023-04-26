package oop06.inter02;

public interface BodySign {
	// public static final은 컴파일러가 자동으로 붙여준다고 함.
	public static final int CENTER = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int DOWN = 4;
	public static final int UP = 5;
	
	public void throwBall(int how);
}
