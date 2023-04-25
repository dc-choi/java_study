package oop06.inter03;

public class RemoteTest {
	public static void main(String[] args) {
		RemoteControl rc = new LgRemoteTV();
		rc.powerOn();
		rc.channelUp();
		rc.channelDown();
		rc.powerOff();
	}
}
