package oop05.abstract01;

/**
 * 추상 메서드만 사용할 수 없다. 추상 메서드는 추상 클래스에 안에서 선언되어야 함.
 * 추상 클래스를 상속받는 하위 클래스는 반드시 추상 메서드를 강제로 오버라이딩 해야 함.
 */
public abstract class Shape {
	double res;
	public abstract void area();
}
