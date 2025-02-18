package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("testabc");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("testabc");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("testzxc");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("testabc").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("testabc");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("testzxc");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
