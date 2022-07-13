package com.t1dmlgus.ordermvp.service.member;

import com.t1dmlgus.ordermvp.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCommand {

    private final String username;
    private final String email;
    private final String password;

    @Builder
    private MemberCommand(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static MemberCommand of(String username, String email, String password){
        return MemberCommand.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();
    }


    public Member toEntity(){
        return Member.newInstance(username, email, password);
    }


}
