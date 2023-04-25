package oop06.inter01;

public class TvUser {
	public static void main(String[] args) {
		// 인터페이스는 타입으로 선언 가능
		TV tv = new LgTV();
		tv.turnOn();
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.soundUp();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}
}
