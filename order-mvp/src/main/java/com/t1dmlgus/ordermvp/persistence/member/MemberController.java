package com.t1dmlgus.ordermvp.persistence.member;


import com.t1dmlgus.ordermvp.common.response.CommonResponse;
import com.t1dmlgus.ordermvp.service.member.MemberInfo;
import com.t1dmlgus.ordermvp.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public ResponseEntity<CommonResponse<String>> signUp(@RequestBody @Valid MemberDto memberDto) {

        memberService.signUp(memberDto.toCommand());
        CommonResponse<String> response = CommonResponse.of("회원가입이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/v1/members/{memberId}")
    public ResponseEntity<CommonResponse<MemberInfo>> getUserInfo(@PathVariable Long memberId){

        MemberInfo memberInfo = memberService.getMemberInfo(memberId);
        CommonResponse<MemberInfo> response = CommonResponse.of(memberInfo, "조회한 회원정보입니다.");
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }



}
