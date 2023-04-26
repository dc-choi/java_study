package oop04.poly02;

public class AnimalTest {
	public static void main(String[] args) {
		/**
		 * 다형성
		 * 하위 클래스 타입의 객체(인스턴스)를 상위 클래스 타입의 변수로 참조 가능
		 * 
		 * 정말 매우 중요하다고 하심
		 */
		Animal a = new Dog();
		a.eat();
		a.sleep();
		// a.bark();
		
		Dog dog = (Dog)a;
		dog.eat();
		dog.sleep();
		dog.bark();
	}
}
