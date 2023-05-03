package com.oraclejava.service;

import com.oraclejava.message.KakaoMessage;
import com.oraclejava.message.Message;
import org.springframework.beans.factory.annotation.Autowired;

public class Communication {
    private Message message;

    // DI 생성자 패턴
    // public Communication(KakaoMessage kakaoMessage) {
    //     this.kakaoMessage = kakaoMessage;
    // }

    // DI setter 패턴
    public void setMessage(Message message) {
        this.message = message;
    }

    public void communicate() {
        this.message.sendMessage();
    }
}
