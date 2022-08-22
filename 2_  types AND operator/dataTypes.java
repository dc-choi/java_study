public class dataTypes {
	public static void main(String[] args) {
		System.out.println("문제 1");
		/**
		 * 문제: 자바의 데이터타입에 대해서 각 타입의 사이즈와 함께 설명해보시오.
		 * 정수형의 경우 사이즈와 범위도 말해보시오.
		 * 이 문제는 자바의 자료형 종류와 각 타입의 사이즈에 대해서 아는지를 묻는 문제이다.
		 * 
		 * 답변: 원시 타입은 다음과 같다.
		 * 정수: byte(1 byte), char(2 byte), short(2 byte), int(4 byte), long(8 byte)
		 * -128 ~ 127, 0 ~ 65535, -32,768 ~ 32,767, -2,147,483,648 ~ 2,147,483,647, 2의 63승 - 1
		 * 실수: float(4 byte), double(8 byte)
		 * 논리: boolean(1 byte)
		 * 참조 타입은 원사타입을 제외한 나머지로 Class(String, Wrapper), Interface, Array, Enum이 있습니다.
		 */
		System.out.println("문제 2");
		/**
		 * 문제: 자바의 Prinitive Data Type의 바이트 크기와 비트 크기를 출력하는 코드를 구현하시오.
		 * 정수형 타입과 문자열 타입에 대해서만 구현한다.
		 * 이때, 각 타입의 최댓값과 최솟값도 같이 구하여 출력하시오.
		 * 아래 결과에서 문자형의 최댓값, 최솟값이 재대로 출력이 안되었는데 그 이유를 설명하고 수정해보시오.
		 * 
		 * 답변: char의 값은 int로 형변환을 해줘야하는거 같다.
		 */
		System.out.println("byte\t\t: 1byte --> 8bit\t\t" + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		System.out.println("short\t\t: 2byte --> 16bit\t\t" + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		System.out.println("int\t\t: 4byte --> 32bit\t\t" + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println("long\t\t: 8byte --> 64bit\t\t" + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		System.out.println("char\t\t: 2byte --> 16bit\t\t" + (int)Character.MIN_VALUE + " ~ " + (int)Character.MAX_VALUE);

		System.out.println("문제 3");
		/**
		 * 문제: 정수, 실수, 문자형 타입의 변수 사용에서 틀린곳을 찾아서 모두 수정하시오.
		 * 혹, 에러가 안나더라도 올바르게 수정해주시오.
		 * 이 문제는 변수 선언과 사용시 주의할 점에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변:
		 */
		int a;
		int b = 50, c = 90;
		double d;
		char e;
		
		a = 10;
		d = 10;
		e = 'A';

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);

		System.out.println("문제 4");
		/**
		 * 문제: 기본형 타입의 값을 초기화한 아래의 코드에서 틀린 곳을 찾아 수정하시오.
		 * 이 문제는 기본형 타입의 값을 초기화하는 방법에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변:
		 */
		byte b1 = 100;
		short s = 30000;
		int i = 2100000000;
		long l = 7000000000L;
		float f = 9.8f;
		double d1 = 3.14;
		char c1 = 'A';
		boolean bl = false;
		
		System.out.println(b1);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d1);
		System.out.println(c1);
		System.out.println(bl);

		System.out.println("문제 5");
		/**
		 * 문제: System.out.print(), printf(), println() 등에 대해서 예제를 통해 설명해보시오.
		 * 이떄 10진수 10에 대해서 8진수, 16진수로 각각 출력해보시오.
		 * 이 문제는 출력시 많이 사용되는 print(), printf(), println() 형식에 대해서 알고 있는지를 묻는 문제이다.
		 * 
		 * 답변:
		 * print() == 그냥 출력
		 * printf() == 형식에 맞춰서 출력 C언어의 printf와 같다.
		 * println() == 출력을 마치고 \n이 추가된거
		 */

		System.out.print(127);
		System.out.print(',');
		System.out.print(' ');
		System.out.print(32767);
		System.out.print(',');
		System.out.print(' ');
		System.out.print(2100000000);
		System.out.print(',');
		System.out.print(' ');
		System.out.print(7000000000L);
		System.out.print(',');
		System.out.print(' ');
		System.out.print(9.8);
		System.out.print(',');
		System.out.print(' ');
		System.out.print(3.14);
		System.out.print(',');
		System.out.print(' ');
		System.out.print('A');
		System.out.print(',');
		System.out.print(' ');
		System.out.print(false);
		System.out.println();

		String octalString = Integer.toOctalString(10);
		String hexString = Integer.toHexString(10);
		System.out.println("10 to 8 == " + octalString + ", 10 to 16 == " + hexString);

		System.out.println("문제 6");
		/**
		 * 문제: 정수형을 문자열로 변환하여 정수의 자릿수를 구하는 코드를 구현해보시오.
		 * 정수 12345를 입력하면 자릿수가 5로 출력되도록 한다.
		 * 이 문제는 정수형을 문자열로 문자열을 장수형으로 변환하는 방법에 대해서 아는지를 묻는 문제이다.
		 * 
		 * 답변:
		 */
		String str = Integer.toString(12345);
		int num = Integer.parseInt(str);
		System.out.println(str.length());
		System.out.println(num);
	}
}