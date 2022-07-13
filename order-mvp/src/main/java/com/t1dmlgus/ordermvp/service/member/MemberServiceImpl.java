package com.t1dmlgus.ordermvp.service.member;

import com.t1dmlgus.ordermvp.common.exception.UserNotFoundException;
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
        memberRepository.save(member);
    }

    @Override
    public MemberInfo getMemberInfo(Long memberId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(UserNotFoundException::new);
        return MemberInfo.of(member);
    }
}
