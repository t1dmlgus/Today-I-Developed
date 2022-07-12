package com.t1dmlgus.ordermvp.persistence.member;


import com.t1dmlgus.ordermvp.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public ResponseEntity<Object> signUp(@RequestBody @Valid MemberDto memberDto) {


        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
}
