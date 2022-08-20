public class java100_variable_HelloWorld {
	public static void main(String[] args) {
		// system.out.println( 'Hello World~' )
		System.out.println("Hello World~");
		/**
		 * 문제: 자바의 기본적은 코드를 작성한 것인데 에러가 많이 나온다. 에러를 모두 찾아서 수정하시오.
		 * 이 문제는 자바의 기본적인 코드 작성 규칙을 알고 있는지와 그에 따라 작성할 수 있는지를 묻는 문제이다.
		 * 
		 * 답변: system이라는 패키지는 없어서, System으로 변경했고, ''는 자료형 char에서만 쓰이는데,
		 * println()이라는 메서드는 무조건 문자열을 받아와야 한다. 그리고 마지막으로는 세미콜론을 붙이지 않았음.
		 */
	}
}