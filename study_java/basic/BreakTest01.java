package basic;

public class BreakTest01 {
	public static void main(String[] args) {
		int sum = 0;
		int count = 1;
		
		while (true) {
			sum += count;
			if (sum >= 100) break;
			count++;
		}
		
		System.out.println("1부터 " + count + "까지의 sum: " + sum);
	}
}
