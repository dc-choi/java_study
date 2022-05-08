package com.oraclejava.hellospringmvc.service;

import com.oraclejava.hellospringmvc.dao.MemberDAO;
import com.oraclejava.hellospringmvc.model.Member;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private MemberDAO memberDAO;

    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public void addMember(Member member) {
        memberDAO.createMember(member);
    }

    @Override
    public Member getMemberById(String id) {
        return memberDAO.getMemberById(id);
    }

    @Override
    public List<Member> listMember() {
        return memberDAO.getAllMemberDetails();
    }

    @Override
    public Member login(String id, String password) {
        Member member = null;

        try {
            member = memberDAO.getMemberByIdAndPassword(id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return member;
    }
}
