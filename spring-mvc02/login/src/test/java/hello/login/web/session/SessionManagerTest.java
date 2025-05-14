package hello.login.web.session;

import hello.login.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.*;

class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {

        MockHttpServletResponse response = new MockHttpServletResponse();
        final Member member = new Member();
        sessionManager.createSession(member, response);

        final MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        final Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);

        sessionManager.expire(request);
        final Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();
    }
}
