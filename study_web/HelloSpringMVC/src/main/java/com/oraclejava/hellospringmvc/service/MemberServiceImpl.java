package com.oraclejava.hellospringmvc.service;

import com.oraclejava.hellospringmvc.dao.MemberDAO;
import com.oraclejava.hellospringmvc.model.Member;

import java.util.List;

public class MemberServiceImpl implements MemberService{

    private MemberDAO memberDAO;

    // 여기에 Setter 주입을 완성하시오...
    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public void addMember(Member member) {
        memberDAO.createMember(member);
    }

    @Override
    public Member fetchMemberById(String id) {
        return memberDAO.getMemberById(id);
    }

    @Override
    public List<Member> getAllMemberInfo() {
        return memberDAO.getAllMemberDetails();
    }

    @Override
    public Member login(String id, String pass) {
        return memberDAO.getMemberByIdAndPassword(id, pass);
    }
}
