package com.oraclejava.client;

import com.oraclejava.dao.MemberDAO;
import com.oraclejava.dao.MemberDAOImpl;
import com.oraclejava.model.Member;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientTest {
    public static void main(String[] args) throws ParseException {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAOImpl.class);
        Member member = new Member();
        //조용필
        member.setId("sylee");
        member.setName("이승엽");
        member.setPassword("12345");
        //생일 1950-12-01
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date birth = sdf.parse("1976/12/31");
        member.setBirth(birth);

        memberDAO.createMember(member);


        context.close();

    }
}
