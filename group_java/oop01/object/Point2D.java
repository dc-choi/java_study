package oop01.object;

/**
 * final
 * 클래스에 final이 붙으면 상속되지 않음
 * 메서드에 final이 붙으면 오버라이딩 되지 않음
 * 변수에 final이 붙으면 값을 재할당할 수 없음
 */
public class Point2D {
	private int x;
	private int y;
	
	// 기본 생성자라서 명시하지 않으면 컴파일러가 자동으로 생성함.
	// 개발자가 다른 생성자를 정의하면 컴파일러가 기본 생성자를 자동으로 생성해주지 않음.
	public Point2D() {
		// x = 1;
		// y = 2;
		// this로 오버로딩된 아래 생성자를 호출할 수 있음.
		this(10, 20);
		System.out.println("Point2D() 수행 중");
	}
	
	// 개발자가 직접 정의한 생성자 (생성자도 오버로딩이 가능하다.)
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Point2D(x, y) 수행 중");
	}
	
	// getter
	public int getX() {
		return x;
	}
	
	// setter
	public void setX(int x) {
		// this로 이 클래스의 프로퍼티를 바라볼 수 있음.
		this.x = x;
	}

	// getter
	public int getY() {
		return y;
	}

	// setter
	public void setY(int y) {
		this.y = y;
	}
	
	public void print() {
		System.out.println("x = " + getX());
		System.out.println("y = " + getY());
	}
}
