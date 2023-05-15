public class operator {
	public static void main(String[] args) {
		System.out.println("문제 1");
		/**
		 * 문제: 수치 연산자에 대해서 설명해보시오.
		 * 이 문제는 자바의 기본적인 수치 연산자에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 */
		int a, b;
		a = 60;
		b = 80;

		System.out.println(a + b); // 일반적으로 생각하는 것 처럼 동작함.
		System.out.println("a + b = " + a + b); // 6080 (JS처럼 동작함.)
		System.out.println("a + b = " + (a + b)); // 140 (add)
		System.out.println("a - b = " + (a - b)); // -20 (sub)
		System.out.println("a * b = " + (a * b)); // 4800 (mul)
		System.out.println("a / b = " + (a / b)); // 0 (div)
		System.out.println("a % b = " + (a % b)); // 60 (mod)

		System.out.println("문제 2");
		/**
		 * 문제: 수치 연산자를 사용한 연산에서 소숫점 결과가 예상과 다르게 나오는 것에 대해서 설명해보시오.
		 * 아래의 코드 결과가 올바르게 나오도록 수정해보시오.
		 * 이 문제는 자바의 기본적인 수치 연산자에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 */
		double c = 60, d = 8;
		double rst1 = c / d;

		System.out.println(rst1);
		System.out.println((double)rst1);

		System.out.println("문제 3");
		/**
		 * 문제: 축약된 형태의 연산자를 사용하여 변수 a의 값을 증가시켜보시오.
		 * 이 문제는 수의 연산시 축약된 형태로 사용하는 방법에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 */
		int e = 0;
		e++;
		System.out.println(e);

		System.out.println("문제 4");
		/**
		 * 문제: 관계 연산자에 대해서 설명해보시오.
		 * 이 문제는 자바의 기본적인 관계 연산자에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 * ==: 두 식이 같은지 비교하는 연산자이다.
		 * !=: 두 식이 다른지 비교하는 연산자이다.
		 * >: 왼쪽의 식이 더 큰지 비교하는 연산자이다.
		 * >=: 왼쪽의 식이 더 크거나 같은지 비교하는 연산자이다.
		 * <: 오른쪽의 식이 더 큰지 비교하는 연산자이다.
		 * <=: 오른쪽의 식이 더 크거나 같은지 비교하는 연산자이다.
		 */

		System.out.println("문제 5");
		/**
		 * 문제: 논리 연산자에 대해서 설명해보시오.
		 * 참, 거짓을 판단하는 문장을 가지고 논리 연산자를 사용해보시오.
		 * 이 문제는 자바의 기본적인 논리 연산자에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 */

		boolean tt = true;
		boolean ff = false;

		System.out.println(tt && ff);
		System.out.println(tt || ff);
		System.out.println(!tt);
		System.out.println(!ff);
	}
}