package com.oraclejava.message;

public class LineMessage implements Message {
    @Override
    public void sendMessage() {
        System.out.println("라인 메시지를 보냅니다.");
    }
}
