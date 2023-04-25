package oop05.abstract01;

public class ShapeTest {
	public static void main(String[] args) {
		// Shape s = new Shape(); 추상 클래스는 인스턴스를 만들 수 없음.
		Circle c = new Circle();
		Rectangle r = new Rectangle();
		Triangle t = new Triangle();
		
		printArea(c);
		printArea(r);
		printArea(t);
	}

	/**
	 * instanceof 연산자
	 * 1. 매개변수의 타입을 부모 타입으로 선언
	 * 2. instanceof 연산자를 사용해 타입을 검사
	 * 3. 타입 변경 후 차별적인 작업 수행
	 */
	private static void printArea(Shape s) { // 다형성
		s.area();
		
		if (s instanceof Circle) {
			Circle c = (Circle)s;
			System.out.println("반지름이 " + c.r + "인 원의 넓이는 " + c.res);
		} else if (s instanceof Rectangle) {
			Rectangle r = (Rectangle)s;
			System.out.println("가로가 " + r.w + ", 세로가 " + r.h + "인 사각형의 넓이는 " + r.res);
		} else if (s instanceof Triangle) {
			Triangle t = (Triangle)s;
			System.out.println("밑변이 " + t.w + "세로가 " + t.h + "의 삼각형의 넓이는 " + t.res);
		} else {
			System.out.println("에러입니다.");
		}
	}

//	private static void printArea(Triangle t) {
//		t.area();
//		System.out.println("밑변이 " + t.w + "세로가 " + t.h + "의 삼각형의 넓이는 " + t.res);
//	}
//
//	private static void printArea(Rectangle r) {
//		r.area();
//		System.out.println("가로가 " + r.w + ", 세로가 " + r.h + "인 사각형의 넓이는 " + r.res);
//	}
//
//	private static void printArea(Circle c) {
//		c.area();
//		System.out.println("반지름이 " + c.r + "인 원의 넓이는 " + c.res);
//	}
}
