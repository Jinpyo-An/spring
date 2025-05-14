package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        //given
        final Member member1 = new Member();
        member1.setName("spring1");

        //when
        repository.save(member1);

        //then
        final Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //given
        final Member member1 = new Member();
        member1.setName("spring1");
        final Member member2 = new Member();
        member2.setName("spring2");

        //when
        repository.save(member1);
        repository.save(member2);

        //then
        final List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
