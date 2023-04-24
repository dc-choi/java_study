package basic;

import java.util.Scanner;

public class OpTest08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력받아 짝수인지 홀수인지 판별하세요.");
		System.out.print("입력: ");
		int a = scan.nextInt();
		System.out.println(a % 2 == 0 ? "짝수입니다." : "홀수입니다.");
		scan.close();
	}
}
