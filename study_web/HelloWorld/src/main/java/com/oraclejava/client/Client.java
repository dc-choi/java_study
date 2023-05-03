package com.oraclejava.client;

import com.oraclejava.model.Message;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("Beans.xml");
        BeanFactory beans = new XmlBeanFactory(resource);

        Object obj = beans.getBean("message");

        if (obj != null) {
            Message msg = (Message) obj;
            System.out.println(msg.getMessageId() + "\t" + msg.getMessage());
        }
    }
}
