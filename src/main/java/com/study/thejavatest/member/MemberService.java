package com.study.thejavatest.member;

import com.study.thejavatest.domain.Member;
import com.study.thejavatest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newStudy);

    void notify(Member member);
}
