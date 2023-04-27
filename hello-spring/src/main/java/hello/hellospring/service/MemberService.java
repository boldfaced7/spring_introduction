package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService {
    private final MemberRepositroy memberRepositroy;
    @Autowired
    public MemberService(MemberRepositroy memberRepositroy) {
        this.memberRepositroy = memberRepositroy;
    }
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
    public List<Member> findMembers() {
        return memberRepositroy.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepositroy.findById(memberId);
    }
}
