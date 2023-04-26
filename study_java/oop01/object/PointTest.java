package oop01.object;

public class PointTest {
	public static void main(String[] args) {
		// 객체를 new 연산자를 이용해서 선언함.
		// Point3D pt = new Point3D();
		// 캡슐화를 통해 정보를 은닉함.
		// 객체에 직접 접근하지않고, getter, setter 메서드를 통해 접근함.
		// pt.x = 10;
		// pt.y = 20;
		// pt.setX(10);
		// pt.setY(20);
		// pt.setZ(30);
		// pt.print();
		
		// new를 사용해서 호출하게 되면 생성자를 호출하는 것
		// Point2D point = new Point2D();
		// point.print();
		// Point2D point2 = new Point2D(10, 20);
		// point2.print();
		
		// 하위 클래스에서는 반드시 부모 클래스를 호출하게 됨.
		Point3D point3 = new Point3D();
		point3.print();
		
		// Point3D point4 = new Point3D(100, 200, 300);
		// point4.print();
	}
}
