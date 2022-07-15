package com.t1dmlgus.ordermvp.service.member;

import com.t1dmlgus.ordermvp.common.exception.BadCredentialException;
import com.t1dmlgus.ordermvp.common.exception.DuplicateUsernameException;
import com.t1dmlgus.ordermvp.common.exception.UserNotFoundException;
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
            throw new DuplicateUsernameException();
        memberRepository.save(member);
    }

    @Transactional
    @Override
    public MemberInfo signIn(MemberDto.signin signIn) {

        Member member = memberRepository.findByUsername(signIn.getUsername())
                .filter(m -> m.getPassword().equals(signIn.getPassword()))
                .orElseThrow(BadCredentialException::new);

        return MemberInfo.of(member);
    }

    @Override
    public MemberInfo getMemberInfo(Long memberId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(UserNotFoundException::new);
        return MemberInfo.of(member);
    }



}
