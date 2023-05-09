package com.oraclejava.hellospringmvc.dao;

import com.oraclejava.hellospringmvc.model.Member;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class MemberDAOImpl_HB implements MemberDAO{

    private SessionFactory sessionFactory;

    // Setter 주입을 완성!
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createMember(Member member) {
        try(Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(member);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Member getMemberById(String id) {
        Member member = null;
        try(Session session = getSessionFactory().openSession()) {
            member = session.get(Member.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public List<Member> getAllMemberDetails() {
        List<Member> members = null;
        try(Session session = getSessionFactory().openSession()) {
            Query<Member> query = session.createQuery("from Member");
            members = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public Member getMemberByIdAndPassword(String id, String pass) {
        Member member = null;
        try(Session session = getSessionFactory().openSession()) {
            Query<Member> query =
                    session.createQuery("from Member as m " +
                            "where m.id = :id and m.password = :pass");
            query.setParameter("id", id);
            query.setParameter("pass", pass);
            member = query.getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return member;
    }
}
