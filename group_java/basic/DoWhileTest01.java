package basic;

public class DoWhileTest01 {
	public static void main(String[] args) {
		/**
		 * 1부터 1000가지 정수 중 3의 배수의 합계를 구하시오.
		 */
		int sum = 0;
		int i = 0;
		
		do {
			sum += i;
			i += 3;
		}
		while (i <= 1000);
		
		System.out.println("sum: " + sum);
	}
}
