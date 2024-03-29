package com.oraclejava.dao;

import com.oraclejava.model.Member;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    //Setter
   public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createMember(Member member) {
        String sql = "insert into tbl_member(id, name, birth, password) " +
                "values (?,?,?,?)";
        int result = jdbcTemplate.update(sql, member.getId(), member.getName(),
                member.getBirth(), member.getPassword());
        if (result > 0) {
            System.out.println("회원이 생성되었습니다...");
        }
    }

    @Override
    public Member getMemberById(String id) {
       String sql = "select * from tbl_member where id = ?";
       Member member = jdbcTemplate.queryForObject(sql, new MemberRowMapper(), id);
       return member;
    }

    @Override
    public List<Member> getAllMemberDetails() {
        String sql = "select * from tbl_member order by id";
        List<Member> memList = jdbcTemplate.query(sql, new MemberRowMapper());
        return memList;
    }
}
