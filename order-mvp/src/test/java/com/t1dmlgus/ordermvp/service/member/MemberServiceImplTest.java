package com.t1dmlgus.ordermvp.service.member;

import com.t1dmlgus.ordermvp.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MemberServiceImplTest {

//    @InjectMocks
//    private MemberServiceImpl memberService;
//
//    @Mock
//    private MemberRepository memberRepository;


    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입 테스트")
    public void memberRegister(){

        //given
        var memberCommand = MemberCommand.builder().username("의현").email("dmlgusgngl@gmail.com").password("1234").build();

        //when
        memberService.signUp(memberCommand);

        //then
        Assertions.assertThat(memberRepository.findById (1L).get().getUsername()).isEqualTo("의현");
    }

    @Test
    @DisplayName("회원가입 실패 테스트")
    public void memberRegisterFail(){

        //given
        var memberCommand = MemberCommand.builder().username("의현").email("dmlgusgngl@gmail.com").password("1234").build();

        //when
        memberService.signUp(memberCommand);

        //then
        Assertions.assertThat(memberRepository.findById (1L).get().getUsername()).isEqualTo("의현");
    }

}