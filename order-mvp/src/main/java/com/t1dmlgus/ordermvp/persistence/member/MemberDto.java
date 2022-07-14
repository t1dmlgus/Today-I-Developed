package com.t1dmlgus.ordermvp.persistence.member;

import com.t1dmlgus.ordermvp.service.member.MemberCommand;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class MemberDto {

    @Getter
    public static class signUp {

        @NotBlank(message = "username 은 필수값입니다.")
        private String username;

        @Email(message = "email 형식으로 작성해주세요.")
        @NotBlank(message = "email 은 필수값입니다.")
        private String email;

        @NotBlank(message = "password 는 필수값입니다.")
        private String password;

        public MemberCommand toCommand(){
            return MemberCommand.of(username, email, password);
        }
    }


    @Getter
    public static class signin{

        @NotBlank(message = "username 은 필수값입니다.")
        private String username;

        @NotBlank(message = "password 은 필수값입니다.")
        private String password;

    }

}
