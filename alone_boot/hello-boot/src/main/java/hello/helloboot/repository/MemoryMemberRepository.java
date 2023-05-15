package hello.helloboot.repository;

import hello.helloboot.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    // 밑의 두개의 프로퍼티의 경우 동시성 문제가 생길 수 있다고 함. 추후에 더 알아보기.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
