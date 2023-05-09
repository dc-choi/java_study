package com.oraclejava.client;

import com.oraclejava.dao.MemberDAO;
import com.oraclejava.dao.MemberDAOImpl;
import com.oraclejava.model.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.List;

public class ClientTest3 {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");
        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAOImpl.class);

        //회원 목록 출력
        List<Member> memberList = memberDAO.getAllMemberDetails();
        System.out.println("아이디    이름     생년월일    비번");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        for (Member member : memberList) {
            System.out.println(member.getId() + "  " + member.getName()
                + sdf.format(member.getBirth()) + "  " + member.getPassword());
        }


        ((AbstractApplicationContext)context).close();
    }
}
