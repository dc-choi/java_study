package oop05.abstract02;

public class AnimalTest {
	public static void main(String[] args) {
		// 추상 클래스를 타입으로 지정 가능
		Animal a = new Dog();
		a.sleep();
		
		a = new Cat();
		a.sleep();
		
		a = new Tiger();
		a.sleep();
	}
}
