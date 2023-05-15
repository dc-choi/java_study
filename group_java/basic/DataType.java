package basic;

public class DataType {
	public static void main(String[] args) {
		/**
		 * 기본 자료형
		 * boolean: 1Byte
		 * char: 2Byte (유니코드 기반, 아스키코드와 다르게 더 많이 표현 가능)
		 * byte(1), short(2), int(4), long(8)
		 * float(4), double(8)
		 * 
		 * 참조 자료형
		 * 클래스, 인터페이스, 배열
		 * 
		 * 변수이름 작성시 주의사항
		 * 1. 숫자로 시작하면 안됨.
		 * 2. 특수문자는 $, _만 가능함.
		 * 3. 키워드는 선언할 수 없다.
		 */
		boolean check = false;
		System.out.println("check: " + check);
		
		// char character = 'A';
		char character = 65;
		System.out.println("character: " + character);
		
		byte b = 127;
		System.out.println("byte: " + b);
		
		short s = 32767;
		System.out.println("short: " + s);
		
		int i = 2147483647;
		System.out.println("int: " + i);
		
		// 정수 리터럴은 기본적으로 int타입으로 인식해서 에러 발생
		// long l = 2147483648; 
		long l = 2147483648L;
		System.out.println("long: " + l);
		
		double d = 3.1415926535;
		System.out.println("double: " + d);
		
		// 실수 리터럴은 기본적으로 double타입으로 인식해서 에러 발생
		// float f = 3.1415926535;
		float f = 3.1415926535f;
		System.out.println("float: " + f);
		
		/**
		 * escape sequence
		 * 특수문자로 키보드에서 제어기능을 담당하는 키들을 문자로 표현한 것.
		 */
		System.out.println("그가 말했다. \"안녕하세요~!\"");
		System.out.println("안녕하세요.\n반갑습니다.");
		System.out.println("0\t1\t2\t3\t4");
	}
}
