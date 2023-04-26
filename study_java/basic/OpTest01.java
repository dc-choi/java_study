package basic;

import java.util.Scanner;

public class OpTest01 {
	public static void main(String[] args) {
		/**
		 * 연산자
		 * 1. 산술 연산자
		 * 2. 관계 연산자
		 * 3. 논리 연산자
		 * 4. 증감 연산자
		 * 5. 복합대입 연산자
		 * 6. 삼항 연산자
		 * 7. 형변환 연산자
		 */
		int a = 7; // 지역변수로서 스택에 할당된다.
		int b = 4;
		
		// 정수와 +가 있으면 문자열로 결합되어 버림
		System.out.println(a + "+" + b + "=" + a + b);
		// 이 코드들은 우리가 예상하는 값이 나옴
		System.out.println(a + "+" + b + "=" + (a + b));
		System.out.println(a + "-" + b + "=" + (a - b));
		System.out.println(a + "*" + b + "=" + (a * b));
		System.out.println(a + "/" + b + "=" + (a / b)); // 정수 / 정수는 결과도 정수
		System.out.println(a + "%" + b + "=" + (a % b));
		
		// System.in은 콘솔(표준) 입력. 즉, 키보드 입력을 의미함.
		// 참조 자료형은 힙영역에 할당된다.
		// 지역변수로 스택에 선언해놓아서 힙에 선언된 참조 자료형에 접근 가능함.
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 a값 입력: ");
		int sca = scan.nextInt();
		System.out.print("정수 b값 입력: ");
		int scb = scan.nextInt();
		
		// 정수와 +가 있으면 문자열로 결합되어 버림
		System.out.println(sca + "+" + scb + "=" + (sca + scb));
		System.out.println(sca + "-" + scb + "=" + (sca - scb));
		System.out.println(sca + "*" + scb + "=" + (sca * scb));
		System.out.println(sca + "/" + scb + "=" + (sca / scb)); // 정수 / 정수는 결과도 정수
		System.out.println(sca + "%" + scb + "=" + (sca % scb));
		
		scan.close();
	}
}
