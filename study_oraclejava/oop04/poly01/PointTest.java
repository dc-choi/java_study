package oop04.poly01;

public class PointTest {
	public static void main(String[] args) {
		// up casting (컴파일러가 착각함.)
		Point2D up = new Point3D();
		up.x = 10;
		up.y = 20;
		// up.z = 30;
		
		// down casting
		Point3D dn = (Point3D)up;
		dn.x = 1000;
		dn.y = 2000;
		dn.z = 3000;
	}
}
