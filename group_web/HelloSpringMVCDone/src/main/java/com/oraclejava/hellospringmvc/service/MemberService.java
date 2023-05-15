package com.oraclejava.hellospringmvc.service;

import com.oraclejava.hellospringmvc.model.Member;

import java.util.List;

public interface MemberService {
    public abstract void addMember(Member member);
    public abstract Member fetchMemberById(String id);
    public abstract List<Member> getAllMemberInfo();

    public abstract Member login(String id, String pass);
}
