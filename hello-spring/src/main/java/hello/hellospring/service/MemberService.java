package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepositroy;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {
    private final MemberRepositroy memberRepositroy = new MemoryMemberRepository();

    public Long join(Member member) {
        validateDuplicatedMember(member);
        memberRepositroy.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepositroy.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
