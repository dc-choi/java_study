package com.oraclejava.client;

import com.oraclejava.model.Employee;
import com.oraclejava.model.JuminCard;
import com.oraclejava.model.Notebook;
import com.oraclejava.model.Person;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonClient {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = context.getBean("person", Person.class);

        System.out.println("이름: " + person.getName());
        System.out.println("나이: " + person.getAge());
        System.out.println("==== 노트북 정보 ====");

        Notebook notebook = person.getNotebook();
        if (notebook != null) {
            System.out.println("이름: " + notebook.getName());
            System.out.println("가격: " + notebook.getPrice());
        } else {
            System.out.println("없음...");
        }

        context.close();
    }
}
