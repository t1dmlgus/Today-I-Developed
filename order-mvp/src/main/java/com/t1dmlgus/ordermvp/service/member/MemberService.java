package com.t1dmlgus.ordermvp.service.member;

public interface MemberService {

    // 회원가입
    void signUp(MemberCommand memberCommand);
    // 회원조회
    void getMemberInfo(Long memberId);
    // 회웢수정

    // 회원삭제
}
