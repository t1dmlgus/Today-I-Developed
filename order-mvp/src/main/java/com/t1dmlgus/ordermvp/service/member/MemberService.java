package com.t1dmlgus.ordermvp.service.member;

import com.t1dmlgus.ordermvp.persistence.member.MemberDto;

public interface MemberService {

    // 회원가입
    void signUp(MemberCommand memberCommand);
    // 회원조회
    MemberInfo getMemberInfo(Long memberId);

    // 로그인
    MemberInfo signIn(MemberDto.signin signIn);
    // 회웢수정

    // 회원삭제
}
