public class Oop {
	public static void main(String[] args) {
		/**
		 * 문제: 클래스란 무엇이고 어떤 역할을 하는지에 대해서 설명해보시오.
		 * 이 문제는 클래스의 개념과 역할, 용도등에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: 클래스란 쉽게 말하면 객체를 만들기 위한 틀이다.
		 * 예를 들어서 사람이라는 객체를 만들기 위해서는 사람이라는 클래스가 필요하다.
		 * 이 클래스 안에는 사람이라는 객체가 가지고 있는 속성과 기능을 정의한다.
		 * 그 속성을 프로퍼티라고 하고 기능은 메소드라고 한다.
		 */

		/**
		 * 문제: FarmMachine의 속성과 동작들을 가지는 클래스를 코드로 구현하고 객체를 생성하여 동작시켜보시오.
		 * 이 문제는 어떤 사물에 대한 클래스를 실제 코드로 구현할 수 있는지를 묻는 문제이다.
		 * 
		 * 답변: FarmMachine 클래스를 구현하고 객체를 생성하여 동작시켰다.
		 */
		FarmMachine machine = new FarmMachine(10000000, 2019, "red");
		machine.printInfo();
		machine.setStatus("moving");
		machine.printStatus();
		machine.setStatus("digging");
		machine.printStatus();
		machine.setStatus("grinding");
		machine.printStatus();
	}
}
