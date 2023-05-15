package oop06.inter01;

public class LgTV implements TV {
	private Speaker speaker = new BoseSpeaker();
	
	@Override
	public void turnOn() {
		System.out.println("LgTV: 전원을 켭니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("LgTV: 전원을 끕니다.");
	}
	
	@Override
	public void channelUp() {
		System.out.println("LgTV: 채널을 올립니다.");
	}
	
	@Override
	public void channelDown() {
		System.out.println("LgTV: 채널을 내립니다.");
	}
	
	@Override
	public void soundUp() {
		speaker.soundUp();
		// System.out.println("LgTV: 소리를 키웁니다.");
	}
	
	@Override
	public void soundDown() {
		speaker.soundDown();
		// System.out.println("LgTV: 소리를 줄입니다.");
	}
}
