package com.oraclejava.client;

import com.oraclejava.model.Employee;
import com.oraclejava.model.JuminCard;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpClient {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Employee employee = context.getBean("employee", Employee.class);

        System.out.println("사번: " + employee.getEmployeeId());
        System.out.println("이름: " + employee.getEmployeeName());
        System.out.println("==== 주민 등록 정보 ====");

        JuminCard card = employee.getCard();
        if (card != null) {
            System.out.println("주민번호: " + card.getJuminNo());
            System.out.println("본명: " + card.getJuminName());
        } else {
            System.out.println("없음...");
        }

        context.close();
    }
}
