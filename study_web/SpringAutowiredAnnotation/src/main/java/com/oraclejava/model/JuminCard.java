package com.oraclejava.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component
public class JuminCard {
    // @Value("960805-1111111")
    private String juminNo; // 주민번호(외국인등록번호)
    // @Value("최동철")
    private String juminName; // 이름(주민카드내에 설명)

    public String getJuminNo() {
        return juminNo;
    }

    public void setJuminNo(String juminNo) {
        this.juminNo = juminNo;
    }

    public String getJuminName() {
        return juminName;
    }

    public void setJuminName(String juminName) {
        this.juminName = juminName;
    }
}
