package com.t1dmlgus.ordermvp.service.member;

import com.t1dmlgus.ordermvp.domain.member.Member;
import com.t1dmlgus.ordermvp.domain.member.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void signUp(MemberCommand memberCommand) {
        Member member = memberCommand.toEntity();
        Member save = memberRepository.save(member);

    }

    @Override
    public void getMemberInfo(Long memberId) {

    }
}
