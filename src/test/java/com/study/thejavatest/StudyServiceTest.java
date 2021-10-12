package com.study.thejavatest;

import com.study.thejavatest.domain.Member;
import com.study.thejavatest.domain.Study;
import com.study.thejavatest.domain.StudyStatus;
import com.study.thejavatest.member.MemberService;
import com.study.thejavatest.study.StudyRepository;
import com.study.thejavatest.study.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

//    @Mock
//    MemberService memberService;
//
//    @Mock
//    StudyRepository studyRepository;

    @Test
    void createNewStudy(@Mock MemberService memberService,
                        @Mock StudyRepository studyRepository) {
//        MemberService memberService = new MemberService() {
//            @Override
//            public Optional<Member> findById(Long memberId) {
//                return Optional.empty();
//            }
//
//            @Override
//            public void validate(Long memberId) {
//
//            }
//
//            @Override
//            public void notify(Study newStudy) {
//
//            }
//
//            @Override
//            public void notify(Member member) {
//
//            }
//        };
//
//        StudyRepository studyRepository = new StudyRepository() {
//            @Override
//            public List<Study> findAll() {
//                return null;
//            }
//
//            @Override
//            public List<Study> findAll(Sort sort) {
//                return null;
//            }
//
//            @Override
//            public List<Study> findAllById(Iterable<Long> longs) {
//                return null;
//            }
//
//            @Override
//            public <S extends Study> List<S> saveAll(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public void flush() {
//
//            }
//
//            @Override
//            public <S extends Study> S saveAndFlush(S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends Study> List<S> saveAllAndFlush(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public void deleteAllInBatch(Iterable<Study> entities) {
//
//            }
//
//            @Override
//            public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAllInBatch() {
//
//            }
//
//            @Override
//            public Study getOne(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public Study getById(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public <S extends Study> List<S> findAll(Example<S> example) {
//                return null;
//            }
//
//            @Override
//            public <S extends Study> List<S> findAll(Example<S> example, Sort sort) {
//                return null;
//            }
//
//            @Override
//            public Page<Study> findAll(Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends Study> S save(S entity) {
//                return null;
//            }
//
//            @Override
//            public Optional<Study> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(Study entity) {
//
//            }
//
//            @Override
//            public void deleteAllById(Iterable<? extends Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends Study> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//
//            @Override
//            public <S extends Study> Optional<S> findOne(Example<S> example) {
//                return Optional.empty();
//            }
//
//            @Override
//            public <S extends Study> Page<S> findAll(Example<S> example, Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends Study> long count(Example<S> example) {
//                return 0;
//            }
//
//            @Override
//            public <S extends Study> boolean exists(Example<S> example) {
//                return false;
//            }
//        };

//        MemberService memberService = mock(MemberService.class);
//        StudyRepository studyRepository = mock(StudyRepository.class);

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    void createMockStudy(@Mock MemberService memberService,
                         @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);

//        Optional<Member> optional = memberService.findById(1L);
//        memberService.validate(2L);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("myid@email.com");

//        when(memberService.findById(1L)).thenReturn(Optional.of(member));
//        when(memberService.findById(2L)).thenReturn(Optional.of(member));
        when(memberService.findById(any())).thenReturn(Optional.of(member));

        Study study = new Study(10, "java");
//        studyService.createNewStudy(1L, study);

//        Optional<Member> findById = memberService.findById(1L);
//        assertEquals("myid@email.com", findById.get().getEmail());

        assertEquals("myid@email.com", memberService.findById(1L).get().getEmail());
        assertEquals("myid@email.com", memberService.findById(2L).get().getEmail());

        when(memberService.findById(1L)).thenThrow(new RuntimeException());
//        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);
//        assertThrows(IllegalArgumentException.class, () -> {
//           memberService.validate(1L);
//        });
//
//        memberService.validate(1L);

        when(memberService.findById(any()))
                .thenReturn(Optional.of(member))
                .thenThrow(new RuntimeException())
                .thenReturn(Optional.empty());

        Optional<Member> findById = memberService.findById(1L);
        assertEquals("myid@email.com", findById.get().getEmail());
        assertThrows(RuntimeException.class, () -> {
            memberService.findById(2L);
        });
        assertEquals(Optional.empty(), memberService.findById(3L));

    }

    @Test
    void createStudyExample(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("myid@email.com");

        Study study = new Study(10, "테스트");

        // memberService 객체에 findById 메소드를 1L 값으로 호출하면
        // Optional.of(member) 객체를 리턴하도록 Stubbing
        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        // studyRepository 객체에 save 메소드를 study 객체로 호출하면
        // study 객체 그대로 리턴하도록 Stubbing
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);
//        assertNotNull(study.getOwner());
//        assertEquals(member, study.getOwner());
    }

    @Test
    void mockCheck(@Mock MemberService memberService,
                   @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("myid@email.com");

        Study study = new Study(10, "테스트");

        verify(memberService, times(1)).notify(study);
        verifyNoMoreInteractions(memberService);

//        verify(memberService, times(1)).notify(member);
//        verify(memberService, never()).validate(any());
//
//        InOrder inOrder = inOrder(memberService);
//        inOrder.verify(memberService).notify(study);
//        inOrder.verify(memberService).notify(member);
    }

    @Test
    void givenWhenThen(@Mock MemberService memberService,
                       @Mock StudyRepository studyRepository) {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("myid@email.com");

        Study study = new Study(10, "테스트");
        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        // When
        studyService.createNewStudy(1L, study);

        // Then
//        assertEquals(member, study.getOwner());
        verify(memberService, times(1)).notify(study);
        then(memberService).should(times(1)).notify(study);

        verifyNoMoreInteractions(memberService);
        then(memberService).shouldHaveNoMoreInteractions();
    }

    @DisplayName("다른 사용자가 볼 수 있도록 스터디를 공개한다.")
    @Test
    void mockitoExample(@Mock MemberService memberService,
                        @Mock StudyRepository studyRepository) {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "더 자바, 테스트");
        assertNull(study.getOpenedDateTime());

        // studyRepository Mock 객체의 save 메소드를호출 시 study를 리턴하도록 만들기
        given(studyRepository.save(study)).willReturn(study);

        // When
        studyService.openStudy(study);

        // Then
        // study의 status가 OPENED로 변경됐는지 확인
        assertEquals(StudyStatus.OPENED, study.getStudyStatus());
        // study의 openedDataTime이 null이 아닌지 확인
        assertNotNull(study.getOpenedDateTime());
        // memberService의 notify(study)가 호출 됐는지 확인
        then(memberService).should().notify(study);
    }

    @Test
    void openStudy() {
    }

    @Test
    void hi() {
    }
}