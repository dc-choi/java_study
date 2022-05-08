package com.oraclejava.hellospringmvc.dao;

import com.oraclejava.hellospringmvc.model.Member;
import com.oraclejava.hellospringmvc.model.Member;

import java.util.List;

public interface MemberDAO {
    //회원추가(가입)
    public abstract void createMember(Member member);
    //아이디로 회원 1명 조회
    public abstract Member getMemberById(String id);
    public abstract List<Member> getAllMemberDetails();
    public Member getMemberByIdAndPassword(String id, String password);
}
