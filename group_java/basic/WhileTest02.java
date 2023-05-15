package basic;

public class WhileTest02 {
	public static void main(String[] args) {
		/**
		 * 1부터 1000가지 정수 중 3의 배수의 합계를 구하시오.
		 */
		int sum = 0;
		int i = 0;
		
		while (i <= 1000) {
			sum += i;
			i += 3;
		}
		
		System.out.println("sum: " + sum);
	}
}
