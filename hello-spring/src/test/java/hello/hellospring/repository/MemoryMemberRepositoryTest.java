package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @Test
    public void save() {
        // Given
        Member member = new Member();
        member.setName("spring");

        // When
        repository.save(member);

        // Then
        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = " + (result == member));
        // Assertions.assertEquals(member, result);
        Assertions.assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName() {
        // Given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // When
        Member result = repository.findByName("spring1").get();

        // Then
        Assertions.assertThat(member1).isEqualTo(result);
    }
    @Test
    public void findAll() {
        // Given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // When
        List<Member> result = repository.findAll();

        // Then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
