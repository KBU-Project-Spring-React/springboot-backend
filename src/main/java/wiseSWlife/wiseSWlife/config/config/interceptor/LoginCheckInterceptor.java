package wiseSWlife.wiseSWlife.config.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import wiseSWlife.wiseSWlife.config.session.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if(session == null || session.getAttribute(SessionConst.LOGIN_SESSION_KEY)==null){
        log.info("미인증 사용자 요청 {}",request);
            response.setStatus(403);
            return false;
        }
        return true;

    }
}