package com.oraclejava.client;

import com.oraclejava.service.Communication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageClient {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Communication comm = context.getBean("communication", Communication.class);
        comm.communicate();

        context.close();
    }
}
