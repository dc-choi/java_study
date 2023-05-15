package basic;

public class OpTest04 {
	public static void main(String[] args) {
		int a = 5;
		// ++a; // prefix
		// a++; // postfix
		
		int b = ++a; // b = (a = a + 1)
		System.out.println(a);
		System.out.println(b);
	}
}
