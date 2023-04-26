package basic;

public class Hello {
	public static void main(String[] args) {
		// System.out.println("hello world~!");
		for (int i = 0; i < args.length; i++) {
			System.out.println("args:[" + i + "]: " + args[i]);
		}
	}
	/**
	 * 자바의 특징
	 * 한번 프로그램을 작성하면 어디에서든 실행 가능함.
	 * 그래서 플랫폼에 영향을 받지 않는다.
	 * JVM에서 컴파일된 바이트코드를 실행시킬 수 있다.
	 */
}
