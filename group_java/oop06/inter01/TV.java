package oop06.inter01;

/**
 * JAVA에서는 클래스의 다중 상속을 허용하지 않음.
 * 
 * 인터페이스
 * 모든 변수는 상수
 * 모든 메서드는 추상 메서드
 * 
 * 인터페이스를 구현할 때는 implements 키워드 사용
 * 
 * 인터페이스를 구현하는 모든 하위 클래스는 추상 메서드를 하나도 빠짐없이 모두 오버라이딩 해야 한다.
 * 
 * 인터페이스는 동시에 여러 개 구현 가능
 * 
 * 인터페이스끼리 상속, 다중 상속이 가능함.
 */
public interface TV {
	public void turnOn();
	public void turnOff();
	public void channelUp();
	public void channelDown();
	public void soundUp();
	public void soundDown();
}
