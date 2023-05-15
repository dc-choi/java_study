package oop02.static01;

public class Account {
	// static 키워드가 붙으면 메모리의 code 영역에 할당됨.
	static int money1;
	int money2;
	
	public Account(int money) {
		money1 += money;
		money2 += money;
	}
}
