package com.oraclejava.message;

public class KakaoMessage implements Message {
    @Override
    public void sendMessage() {
        System.out.println("카카오톡 메시지를 보냅니다.");
    }
}
