package com.study.thejavatest.member;

import com.study.thejavatest.domain.Member;
import com.study.thejavatest.domain.Study;
import com.study.thejavatest.study.StudyService;

import java.util.Optional;

public class DefaultMemberService implements MemberService {

    StudyService studyService;

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.empty();
    }

    @Override
    public void validate(Long memberId) {
        studyService.hi();
    }

    @Override
    public void notify(Study newStudy) {
        studyService.hi();
    }

    @Override
    public void notify(Member member) {
        studyService.hi();
    }
}
