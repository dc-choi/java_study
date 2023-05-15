package basic;

public class MethodTest01 {
	// args는 외부의 매개변수를 의미한다.
	public static void main(String[] args) {
		print();
		print();
		print("son");
		print("ryu");
		
		int a = 7;
		int b = 4;
		
		System.out.println(a + " + " + b + " = " + add(a, b));
		System.out.println(a + " - " + b + " = " + sub(a, b));
		System.out.println(a + " * " + b + " = " + mul(a, b));
		System.out.println(a + " / " + b + " = " + div(a, b));
		System.out.println(a + " % " + b + " = " + mod(a, b));
	}

	private static void print() {
		System.out.println("Hello World");
		/**
		 * return의 목적
		 * 1. 메서드의 강제종료
		 * 2. 값의 반환
		 */
		return;
	}
	
	/**
	 * 메서드 오버로딩
	 * 같은 메서드의 매개변수를 다르게 선언할 수 있는 것
	 */
	private static void print(String name) {
		System.out.println("Hello " + name);
	}
	
	private static int add(int a, int b) {
		return a + b;
	}
	
	private static int sub(int a, int b) {
		return a - b;
	}
	
	private static int mul(int a, int b) {
		return a * b;
	}
	
	private static int div(int a, int b) {
		return a / b;
	}
	
	private static int mod(int a, int b) {
		return a % b;
	}
}
