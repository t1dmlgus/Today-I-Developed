package com.t1dmlgus.ordermvp.persistence.member;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class MemberDto {

    @NotBlank(message = "username 은 필수값입니다.")
    private String username;

    @Email(message = "email 형식으로 작성해주세요.")
    @NotBlank(message = "email 은 필수값입니다.")
    private String email;

    @NotBlank(message = "password 는 필수값입니다.")
    private String password;



}
