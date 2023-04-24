package basic;

import java.util.Scanner;

public class SwitchTest03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		int score = scan.nextInt();
		scan.close();
		
		switch(score / 10) {
			case 10:
				System.out.println("성적은 A입니다.");
				break;
			case 9:
				System.out.println("성적은 A입니다.");
				break;
			case 8:
				System.out.println("성적은 B입니다.");
				break;
			case 7:
				System.out.println("성적은 C입니다.");
				break;
			case 6:
				System.out.println("성적은 D입니다.");
				break;
			default:
				System.out.println("성적은 F입니다.");
				break;
		}
	}
}
