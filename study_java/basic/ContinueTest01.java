package basic;

public class ContinueTest01 {
	public static void main(String[] args) {
		int sum = 0;
		
		for (int i = 1; i <= 10; i++) {
			// continue를 사용하면 밑의 문장을 전부 생략하고 다음 loop로 넘어간다.
			if (i % 3 != 0) continue;
			sum += i;
		}
		
		System.out.println("sum: " + sum);
	}
}
