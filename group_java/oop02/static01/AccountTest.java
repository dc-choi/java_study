package oop02.static01;

public class AccountTest {
	public static void main(String[] args) {
		System.out.println("ac.money1: " + Account.money1);

		Account ac = new Account(10000);
		System.out.println("ac.money2: " + ac.money2);
		
		Account ac2 = new Account(10000);
		System.out.println("ac.money2: " + ac2.money2);
		
		Account ac3 = new Account(10000);
		System.out.println("ac.money2: " + ac3.money2);
		
		System.out.println("ac.money1: " + Account.money1);
		
		/**
		 * 대표적인 static 프로퍼티, 메서드
		 */
		System.out.println(System.in);
		System.out.println(Math.random());
	}
}
