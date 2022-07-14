package com.t1dmlgus.ordermvp.persistence.member;


import com.t1dmlgus.ordermvp.common.SessionConst;
import com.t1dmlgus.ordermvp.common.response.CommonResponse;
import com.t1dmlgus.ordermvp.service.member.MemberInfo;
import com.t1dmlgus.ordermvp.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/v1/signup")
    public ResponseEntity<CommonResponse<String>> signUp(@RequestBody @Valid MemberDto.signUp signUp) {

        memberService.signUp(signUp.toCommand());
        CommonResponse<String> response = CommonResponse.of("회원가입이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/v1/members/{memberId}")
    public ResponseEntity<CommonResponse<MemberInfo>> getUserInfo(@PathVariable Long memberId){

        MemberInfo memberInfo = memberService.getMemberInfo(memberId);
        CommonResponse<MemberInfo> response = CommonResponse.of(memberInfo, "조회한 회원정보입니다.");

        return ResponseEntity.status(response.getStatusCode()).body(response);
    }


    @PostMapping("/api/v1/signin")
    public ResponseEntity<CommonResponse<MemberInfo>> signIn(@RequestBody @Valid MemberDto.signin signIn, HttpServletRequest httpServletRequest) {

        MemberInfo memberInfo = memberService.signIn(signIn);

        // 세션이 있으면 세션반환, 없으면 신규 세션 생성
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, memberInfo);

        CommonResponse<MemberInfo> response = CommonResponse.of(memberInfo, "로그인 되었습니다.");
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PostMapping("/api/v1/logout")
    public ResponseEntity<?> logout(HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        CommonResponse<MemberInfo> response = CommonResponse.of("로그아웃 되었습니다.");
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }


}
