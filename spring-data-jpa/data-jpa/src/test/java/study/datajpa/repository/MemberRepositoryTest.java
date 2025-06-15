package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.entity.Team;

import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Test
    public void basicCRUD() {
        final Member member1 = new Member("member1");
        final Member member2 = new Member("member2");
        memberRepository.save(member1);
        memberRepository.save(member2);

        final Member findMember1 = memberRepository.findById(member1.getId()).get();
        final Member findMember2 = memberRepository.findById(member2.getId()).get();
        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        final List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        final Long count = memberRepository.count();
        assertThat(count).isEqualTo(2);

        memberRepository.delete(member1);
        memberRepository.delete(member2);

        final Long deletedCount = memberRepository.count();
        assertThat(deletedCount).isEqualTo(0);
    }

    @Test
    public void findByUsernameAndAgeGreaterThen() {
        final Member member1 = new Member("AAA", 10);
        final Member member2 = new Member("AAA", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        final List<Member> result = memberRepository.findByUsernameAndAgeGreaterThan("AAA", 15);

        assertThat(result.getFirst().getUsername()).isEqualTo("AAA");
        assertThat(result.getFirst().getAge()).isEqualTo(20);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void testNamedQuery() {
        final Member member1 = new Member("AAA", 10);
        final Member member2 = new Member("BBB", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        final List<Member> result = memberRepository.findByUsername("AAA");
        final Member findMember = result.getFirst();
        assertThat(findMember).isEqualTo(member1);
    }

    @Test
    public void testQuery() {
        final Member member1 = new Member("AAA", 10);
        final Member member2 = new Member("BBB", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        final List<Member> result = memberRepository.findMember("AAA", 10);
        assertThat(result.getFirst()).isEqualTo(member1);
    }

    @Test
    public void findUsernameList() {
        final Member member1 = new Member("AAA", 10);
        final Member member2 = new Member("BBB", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        final List<String> usernameList = memberRepository.findUsernameList();
        usernameList.forEach(System.out::println);
    }

    @Test
    void findMemberDto() {
        final Team teamA = new Team("teamA");
        teamRepository.save(teamA);

        final Member member1 = new Member("AAA", 10);
        member1.changeTeam(teamA);
        memberRepository.save(member1);

        final List<MemberDto> memberDto = memberRepository.findMemberDto();
        memberDto.forEach(System.out::println);
    }

    @Test
    public void findByNames() {
        final Member member1 = new Member("AAA", 10);
        final Member member2 = new Member("BBB", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        final List<Member> result = memberRepository.findByNames(List.of("AAA", "BBB"));
        result.forEach(System.out::println);
    }

    @Test
    void returnType() {
        final Member member1 = new Member("AAA", 10);
        final Member member2 = new Member("AAA", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        final Optional<Member> findMember = memberRepository.findOptionalByUsername("AAA");
        System.out.println("findMember = " + findMember);
    }

    @Test
    void paging() {
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 10));
        memberRepository.save(new Member("member3", 10));
        memberRepository.save(new Member("member4", 10));
        memberRepository.save(new Member("member5", 10));

        int age = 10;
        final PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));

        final Page<Member> page = memberRepository.findByAge(age, pageRequest);
        final Page<MemberDto> toMap = page.map(member -> new MemberDto(member.getId(), member.getUsername(), null));


        //then
        final List<Member> content = page.getContent();
        final long totalCount = page.getTotalElements();

        assertThat(content.size()).isEqualTo(3);
        assertThat(page.getTotalElements()).isEqualTo(5);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.isFirst()).isTrue();
        assertThat(page.hasNext()).isTrue();
    }

//    @Test
//    void slicing() {
//        memberRepository.save(new Member("member1", 10));
//        memberRepository.save(new Member("member2", 10));
//        memberRepository.save(new Member("member3", 10));
//        memberRepository.save(new Member("member4", 10));
//        memberRepository.save(new Member("member5", 10));
//
//        int age = 10;
//        final PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));
//
//        final Slice<Member> page = memberRepository.findByAge(age, pageRequest);
//
//
//        //then
//        final List<Member> content = page.getContent();
//
//        assertThat(content.size()).isEqualTo(3);
//        assertThat(page.getNumber()).isEqualTo(0);
//        assertThat(page.isFirst()).isTrue();
//        assertThat(page.hasNext()).isTrue();
//    }
}