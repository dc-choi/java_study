package basic;

public class ForTest03 {
	public static void main(String[] args) {
		/**
		 * 1부터 1000가지 정수 중 3의 배수의 합계를 구하시오.
		 */
		int sum = 0;
		
		for (int i = 1; i <= 1000; i++) {
			if (i % 3 == 0) sum += i;
		}
		
		System.out.println("sum: " + sum);
		sum = 0;
		
		for (int i = 0; i <= 1000; i+=3) {
			sum += i;
		}
		
		System.out.println("sum: " + sum);
	}
}
