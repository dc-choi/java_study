package basic;

public class OpTest03 {
	public static void main(String[] args) {
		boolean a = true, b = true;
		System.out.println(a && b);
		System.out.println(a || b);
		System.out.println(!a);
		
		a = false;
		b = true;
		System.out.println(a && b);
		System.out.println(a || b);
		
		a = true;
		b = false;
		System.out.println(a && b);
		System.out.println(a || b);
		System.out.println(!b);
		
		a = false;
		b = false;
		System.out.println(a && b);
		System.out.println(a || b);
	}
}
