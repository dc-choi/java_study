package com.oraclejava.hellospringmvc.service;

import com.oraclejava.hellospringmvc.model.Member;

import java.util.List;

public interface MemberService {
    public void addMember(Member member);
    public Member getMemberById(String id);
    public List<Member> listMember();
    public Member login(String id, String password);
}
