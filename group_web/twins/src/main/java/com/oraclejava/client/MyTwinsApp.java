package com.oraclejava.client;

import com.oraclejava.model.MyTwins;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTwinsApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");

        MyTwins bean = new MyTwins();
        bean.setName("함덕주");
        bean.setDob("1995년 1월 13일");
        System.out.println(bean);

        MyTwins mybean1 = context.getBean("mybean1", MyTwins.class);
        System.out.println(mybean1);

        context.close();
    }
}
