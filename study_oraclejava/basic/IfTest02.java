package basic;

import java.util.Scanner;

public class IfTest02 {
	public static void main(String[] args) {
		/**
		 * 0부터 100까지 점수를 입력받아서
		 * 90점 이상이면 A
		 * 80점 이상 90점미만이면 B
		 * 70점 이상 80점미만이면 C
		 * 60점 이상 70점미만이면 D
		 * 나머지는 F
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("0부터 100까지 입력: ");
		int score = scan.nextInt();
		scan.close();
		
		if (score >= 90) System.out.println("성적은 A입니다.");
		else if (score >= 80 && score < 90) System.out.println("성적은 B입니다.");
		else if (score >= 70 && score < 80) System.out.println("성적은 C입니다.");
		else if (score >= 60 && score < 70) System.out.println("성적은 D입니다.");
		else System.out.println("성적은 F입니다.");		
	}
}
