public class ifANDfor {
	public static void main(String[] args) {
		System.out.println("문제 1");
		/**
		 * 문제: if 조건문의 사용법을 예제로 설명해보시오.
		 * 이 문제는 JAVA의 if 조건문을 사용할 수 있는지에 대해서 묻는 문제이다.
		 * 
		 * 답변: if는 ()안의 값이 참일 경우에만 실행이 됩니다. 만약 거짓이라면 넘어가게 됩니다.
		 * 한줄만 있을 경우 {}를 생략해도 됩니다.
		 */
		if (true) {
			System.out.println("값이 참일 경우 실행됩니다.");
		}

		if (true)
			System.out.println("값이 참일 경우 실행됩니다.");

		System.out.println("문제 2");
		/**
		 * 문제: if ~ else 조건문의 사용법을 예제로 설명해보시오.
		 * 아래 코드에서 틀린 곳을 찾아서 수정하시오.
		 * 이 문제는 자바의 if ~ else 조건문을 사용할 수 있는지에 대해서 묻는 문제이다.
		 * 
		 * 답변: 아래 코드의 경우는 두줄 이상의 경우 {}로 감싸줘야 합니다.
		 */
		int eng = 90;
		
		System.out.println((eng > 90) ? "true" : "false");
		
		if (eng > 90) {
			System.out.println( "A 학점입니다." );
			System.out.println( "축하해요~" );
		}
		else
			System.out.println( "90점 미만이네요..ㅠ.ㅠ" );

		System.out.println("문제 3");
		/**
		 * 문제: if ~ else if ~ else 조건문의 사용법을 예제로 설명해보시오.
		 * 이 문제는 JAVA의 if ~ else if ~ else 조건문을 사용할 수 있는지에 대해서 묻는 문제이다.
		 * 
		 * 답변: else if나 else로 if()안의 조건과 맞지 않다면 다른 로직으로 넘어가는 것도 가능합니다.
		 * 위 두가지의 경우도 마찬가지로 참일 경우에만 실행이 됩니다.
		 */
		boolean fail = false;
		
		if (fail) {
			System.out.println("그냥 넘어갑니다.");
		} else if (fail) {
			System.out.println("그냥 넘어갑니다.");
		} else {
			System.out.println("HI");
		}
		
		System.out.println("문제 4");
		/**
		 * 문제: 중첩된 if 조건문을 사용하는 예제를 만들어보시오.
		 * 아래의 코드는 {}가 없이 중첩되서 if ~ else 조건문을 쓰고 있는데 틀린 곳이 있는지 말해보시오.
		 * 이 문제는 if 조건문을 중첩하여 사용하는 방법에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변: 딱히 잘못된 부분이...
		 */
		int totalScore = 180;

		if (fail) {
			System.out.println("그냥 넘어갑니다.");
		} else {
			if (totalScore >= 180)
				System.out.println("매우 노력하세요. 재수강 대상자는 아닙니다.");
				else
				System.out.println("매우 노력하세요. 재수강 대상자입니다.");
		}
			
		System.out.println("문제 5");
		/**
		 * 문제: switch 조건문의 사용법을 예제로 설명해보시오.
		 * 사용자가 자신의 연령대를 입력하면 해당 연령대에 맞는 책을 추천하는 코드를 만들어보시오.
		 * 이 문제는 JAVA의 switch 조건문을 사용할 수 있는지에 대해서 묻는 문제이다.
		 * 
		 * 답변: 
		 */
		int age = 10;

		switch (age) {
			case 10:
				System.out.println("10대입니다.");
				break;
			case 20:
				System.out.println("20대입니다.");
				break;
			default:
				System.out.println("30대 이상입니다.");
				break;
		}

		System.out.println("문제 5");
		/**
		 * 문제: 삼항 연산자를 이용하여 12시보다 작으면 오전, 크면 오후를 출력하도록 구현해보시오.
		 * 이 문제는 삼항 연산자의 사용법에 대해서 아는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 */
		int hour = 10;
		// [2] : 삼항 연산자 테스트 --> 10보다 작거나 같으면 100을 곱하시오.
		int test = hour <= 10 ? hour * 100 : hour;
		System.out.println( "[2]" + test );
		// [3] : 삼항 연산자를 이용하여 12시 보다 작으면 오전, 크면 오후 출력
		String ampm = hour < 12 ? "AM" : "PM";
		System.out.println( "[3]" + ampm );

		/**
		 * 문제: JAVA의 반복문 종류를 열거해보시고, 각각의 기본적인 사용법을 코드로 구현해보시오.
		 * 이 문제는 JAVA의 여러 반복문 종류와 각각의 개념과 기본 사용법에 대해서 아는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 */
		for (int idx = 0; idx < 10; idx++) {
			System.out.print(idx);
		}
		System.out.println();

		int idx = 0;
		while (idx < 10) {
			System.out.print(idx);
			idx++;
		}
		System.out.println();

		int idx2 = 0;
		do {
			System.out.print(idx2);
			idx2++;
		} while (idx2 < 10);
		System.out.println();

		/**
		 * 문제: 알파벳 26개 문자를 대문자로 출력하는 반복문을 구현하시오.
		 * 이 문제는 알파벳 문자중 대문자 아스키 코드에 대해서 알고 반복문으로 출력할 수 있는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 */
		for (int i = 65; i <= 90; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();

		int i = 65;
		while (i <= 90) {
			System.out.print((char)i + " ");
			i++;
		}
		System.out.println();

		int i2 = 65;
		do {
			System.out.print((char)i2 + " ");
			i2++;
		} while (i2 <= 90);
		System.out.println();

		/**
		 * 문제: 홀수, 짝수 구하기 문제를 while 반복문을 사용하여 구현해보시오.
		 * 이 문제는 while 반복문과 그 안에서 조건문을 사용할 수 있는지를 묻는 문제이다.
		 * 
		 * 답변: 
		 */
		int iii = 1;
		while (iii < 30) {
			if (iii % 2 == 0)
				System.out.print(iii + " ");
			iii++;
		}

	}
}