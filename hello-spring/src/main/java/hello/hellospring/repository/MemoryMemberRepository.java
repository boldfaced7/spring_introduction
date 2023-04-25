package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;
}
