package com.t1dmlgus.ordermvp.service.member;

import com.t1dmlgus.ordermvp.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberCommand {

    private String username;
    private String email;
    private String password;

    @Builder
    public MemberCommand(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Member toEntity(){
        return Member.newInstance(username, email, password);
    }


}
