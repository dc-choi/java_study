package com.oraclejava.client;

import com.oraclejava.dao.MemberDAO;
import com.oraclejava.dao.MemberDAOImpl;
import com.oraclejava.model.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

public class ClientTest2 {
    public static void main(String[] args) {
        ApplicationContext context = null;

        try {
            context = new ClassPathXmlApplicationContext(
                    "applicationContext.xml");
            MemberDAO memberDAO = context.getBean("memberDAO", MemberDAOImpl.class);
            String id = "sylee";
            Member member = memberDAO.getMemberById(id);
            System.out.println("id:" + member.getId());
            System.out.println("이름:" + member.getName());
            System.out.println("비번:" + member.getPassword());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            System.out.println("생년월일:" + sdf.format(member.getBirth()));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (context != null)
                ((AbstractApplicationContext)context).close();
        }
    }
}
