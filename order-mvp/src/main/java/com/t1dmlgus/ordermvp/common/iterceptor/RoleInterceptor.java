package com.t1dmlgus.ordermvp.common.iterceptor;

import com.t1dmlgus.ordermvp.common.SessionConst;
import com.t1dmlgus.ordermvp.common.exception.BusinessException;
import com.t1dmlgus.ordermvp.common.exception.ErrorType;
import com.t1dmlgus.ordermvp.service.member.MemberInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
public class RoleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        log.info("권한 체크 인테셉터 실행 {}", requestURI);

        HttpSession session = request.getSession();
        MemberInfo memberInfo = (MemberInfo) session.getAttribute(SessionConst.LOGIN_MEMBER);
        String role = memberInfo.getRole();
        if(!role.equals("ADMIN"))
            throw new BusinessException(ErrorType.UNAUTHORIZED);

        return true;
    }


}
