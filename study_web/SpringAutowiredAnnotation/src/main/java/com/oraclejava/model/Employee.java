package com.oraclejava.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component // Employee employee = new Employee();
public class Employee {
    // @Value("960805")
    private Integer employeeId;
    // @Value("최동철")
    private String employeeName;
    @Autowired // JuminCard라는 Bean을 찾고 없으면 이름으로 찾는다.
    private JuminCard card;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public JuminCard getCard() {
        return card;
    }

    public void setCard(JuminCard card) {
        this.card = card;
    }
}
