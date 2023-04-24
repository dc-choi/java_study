package basic;

import java.util.Scanner;

public class SwitchTest02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		int num = scan.nextInt();
		scan.close();
		
		switch (num % 2) {
			case 0:
				System.out.println("여자");
				break;
			case 1:
				System.out.println("남자");			
				break;
			default:
				System.out.println("에러");			
				break;
		}
	}
}
