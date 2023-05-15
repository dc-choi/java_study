package hello.helloboot.repository;

import hello.helloboot.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /**
     * 테스트는 순서에 따라 실행되지 않음.
     * 따라서 각 테스트는 독립적으로 동작하도록 작성하는 것이 맞음.
     */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member me = new Member();
        me.setName("core");
        repository.save(me);

        Member you = new Member();
        you.setName("context");
        repository.save(you);

        Member result = repository.findByName("core").get();
        assertThat(result).isEqualTo(me);

        Member result2 = repository.findByName("context").get();
        assertThat(result2).isEqualTo(you);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("core");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("context");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
