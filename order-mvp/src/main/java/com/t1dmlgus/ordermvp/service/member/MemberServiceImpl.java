package com.t1dmlgus.ordermvp.service.member;

import com.t1dmlgus.ordermvp.common.exception.BusinessException;
import com.t1dmlgus.ordermvp.common.exception.ErrorType;
import com.t1dmlgus.ordermvp.domain.member.Member;
import com.t1dmlgus.ordermvp.domain.member.MemberRepository;
import com.t1dmlgus.ordermvp.persistence.member.MemberDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    @Override
    public void signUp(MemberCommand memberCommand) {
        Member member = memberCommand.toEntity();

        boolean existsByUsername = memberRepository.existsByUsername(member.getUsername());
        if(existsByUsername)
            throw new BusinessException(ErrorType.DUPLICATED_USERNAME);
        memberRepository.save(member);
    }

    @Transactional
    @Override
    public MemberInfo signIn(MemberDto.signin signIn) {


        Member member = memberRepository.findByUsername(signIn.getUsername())
                .filter(m -> m.getPassword().equals(signIn.getPassword()))
                .orElseThrow(()->new BusinessException(ErrorType.BAD_CREDENTIALS));

        return MemberInfo.of(member);
    }

    @Override
    public MemberInfo getMemberInfo(Long memberId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new BusinessException(ErrorType.USER_ENTITY_NOT_FOUND));
        return MemberInfo.of(member);
    }



}
