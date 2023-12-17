package com.codingrecipe.member.session;


import com.codingrecipe.member.dto.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.*;

class SessionManagerTest {
    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest(){

        // 세션 생성
        MockHttpServletResponse response = new MockHttpServletResponse(); //가짜로 테스트 할 수 있도록 HttpServletResponse는 인터페이스
        MemberDTO member = new MemberDTO();
        sessionManager.createSession(member, response);

        // 요청에 응답 쿠키 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies()); // mySessionId = 123410-12412-asefawe

        // 세션 조회
        Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);

        // 세션 만료
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();  // null 이어야됨

    }
}
