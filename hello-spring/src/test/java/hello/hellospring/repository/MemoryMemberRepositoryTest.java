package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

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
        System.out.println("result = " + (result == member));
    }
}
