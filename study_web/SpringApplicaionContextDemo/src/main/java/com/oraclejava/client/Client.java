package com.oraclejava.client;

import com.oraclejava.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        // 메모리를 많이 잡아서 먹는다...
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 구현체를 스프링의 컨테이너에 넣는다.
        Employee employee = context.getBean("employee", Employee.class);

        System.out.println("사번: " + employee.getEmployeeId());
        System.out.println("이름: " + employee.getEmployeeName());

        // AbstractApplicationContext는 ApplicationContext의 부모 클래스이다.
        // ApplicationContext가 메모리를 많이 잡아먹어서 이렇게 사용한다고 한다.
        ((AbstractApplicationContext)context).close();
    }
}
