package oop06.inter01;

public class BoseSpeaker implements Speaker {
	@Override
	public void soundUp() {
		System.out.println("BoseSpeaker: 볼륨을 키웁니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("BoseSpeaker: 볼륨을 줄입니다.");
	}
}
