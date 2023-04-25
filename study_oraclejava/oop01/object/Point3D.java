package oop01.object;

/**
 * 상속을 통해 부모 클래스의 프로퍼티와 메서드를 사용할 수 있음.
 * 단, 부모 클래스의 프로퍼티가 private면 직접 접근은 불가능하고 메서드를 통해 접근가능
 */
public class Point3D extends Point2D {
	private int z;
	
	public Point3D() {
		// 부모 클래스의 기본 생성자 호출 (주석처리해도 자동으로 호출)
		// super();
		// z = 30;
		this(10, 20, 30);
		System.out.println("Point3D() 수행 중");
	}

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
		System.out.println("Point3D(x, y, z) 수행 중");
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * 메서드 오버라이딩
	 * 부모 클래스의 메서드를 자식 클래스에서 재정의 하는 것
	 */
	@Override
	public void print() {
		// super로 부모 클래스를 가리킨다.
		super.print();
		System.out.println("z = " + getZ());
	}
}
