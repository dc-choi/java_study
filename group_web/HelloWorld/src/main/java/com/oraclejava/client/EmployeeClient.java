package com.oraclejava.client;

import com.oraclejava.model.Employee;
import com.oraclejava.model.Message;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class EmployeeClient {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("Beans.xml");
        BeanFactory beans = new XmlBeanFactory(resource);

        Object obj = beans.getBean("employee");

        if (obj != null) {
            Employee person = (Employee) obj;
            System.out.println(person.getEmployeeId() + "\t" + person.getEmployeeName());
        }
    }
}
