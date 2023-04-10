class TestNumber {
	int num;
	TestNumber(int num) { this.num = num; } // 생성자
}

public class Method {
	public static void helloWorld() {
		System.out.println("Hello World!");
	}

	public static void add(int a, int b) {
		System.out.println(a + b);
	}

	public static String upper(String param) {
		System.out.println(param.toUpperCase());
		return param.toUpperCase();
	}

	public void world() {
		System.out.println("world");
	}

	public static void sum(int c) {
		c += 400;
	}

	public static void sum(TestNumber c) {
		c.num += 400;
	}

	public static int[] test() {
		int i = 1;
		int j = 2;

		return new int[] { i, j };
	}

	public static void main(String[] args) {
		/*
		 * 문제: 아래의 메서드 구현 코드에서 틀린 곳을 찾아 올바르게 수정하시오.
		 * 이 문제는 자바의 메서드 구현시 기본적인 주의점에 대해서 아는지를 묻는 문제이다.
		 * 
		 * 답변: 반환값이 void이고, 입력값이 없기에 함수 자체는 다르지 않다.
		 * 하지만, static 키워드가 아니기에 new 연산자를 통해서 인스턴스를 생성해야 한다.
		 */
		helloWorld();

		/**
		 * 문제: 메서드의 정의와 기본적인 자바의 메서드를 작성해보시오.
		 * 이 문제는 자바의 메서드 개념과 메서드가 가지는 여러 특징들에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: 메서드란 일반적인 함수와는 다르게 객체에 종속된 함수를 말한다.
		 * add()의 경우 단순히 더하기라는 함수이지만, Calculator Class의 add()의 경우 메서드이다.
		 * JAVA는 객체지향언어이며, Class를 통해 Method를 구현한다.
		 */
		System.out.println("문제2");

		/**
		 * 문제: 반환값이 없고 받는 인자값이 2개 있는 덧셈 메서드를 구현하시오.
		 * 이 문제는 자바의 메서드 작성법과 반환값, 인자값에 대한 이해가 있는지를 묻는 문제이다.
		 */
		int a = 1;
		int b = 2;

		add(a, b);

		/**
		 * 문제: 반환값이 있고 받는 인자값이 있는 대문자 출력 메서드를 구현해보시오.
		 * 메서드는 소문자로 입력시 대문자로 출력되도록 구현한다.
		 * 이 문제는 자바의 메서드 작성법과 반환값, 인자값에 대한 이해가 있는지를 묻는 문제이다.
		 */
		String str = "qwerqwerqwer";
		upper(str);

		/**
		 * 문제: static 선언이 안되어있는 메서드를 사용하는 방법에 대해서 코드로 구현해보시오.
		 * 이 문제는 main()에서 static 선언이 없는 메서드를 사용하는 방법에 대해서 아는지를 묻는 문제이다.
		 * 클래스와 객체에 대한 선행 학습이 필요하므로 이에 대한 학습후 문제를 푸는 것이 좋다.
		 */
		new Method().world();

		/**
		 * 문제: 메서드로 인자 전달시 정수 100을 보냈을 때의 아래 코드의 결과를 말해보시오.
		 * 이 문제는 자바의 기본형 타입과 참조형 타입의 다양한 메서드 호출 방식에 대해서 아는지를 묻는 문제이다.
		 * 
		 * 문제: 메인 메서드에서 정수 100을 Call by reference 방식으로 메서드 호출하는 코드를 구현하시오.
		 * 이 문제는 앞서 다뤘던 문제의 Call by value 방식을 Call by reference 방식으로 수정해서 보내라는 의미다.
		 */
		int c = 100; // 지금처럼 선언한 것은 기본형이다. 메모상의 값에 직접 접근한다.
		TestNumber d = new TestNumber(100); // 참조형이다. 메모리상의 주소에 접근하여 값을 참조한다.
		sum(c);
		sum(d);
		System.out.println(c);
		System.out.println(d); // 주소값이 나옴.
		System.out.println(d.num);

		/**
		 * 문제: 2개의 정수형 값을 리턴하는 메서드를 구현하시오.
		 * 이 문제는 두개의 리턴 값을 반환하는 메서드 작성법을 아는지에 대해서 묻는 문제이다.
		 * 아래의 코드에서 2개의 리턴 값을 받는 코드는 어떤 것인가?
		 * 
		 * 답변: return을 한번 하게 되면 무조건 메서드가 종료되면서 값을 반환함. 두개를 동시하게 하기 위해서는 다음처럼 해야함.
		 * return new int[] { 1, 2 };
		 */
		test();
	}
}
