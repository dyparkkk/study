package springSecurityDocDemo.example;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityExample {
    public void securityContextHolderExample(){
        // 인증을 하는 가장 간단한 방법 : 시큐리티 컨텍스트 홀더에 authentication을 넣어준다
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        Authentication authentication =
                new TestingAuthenticationToken("username", "password", "ROLE_USER");
        securityContext.setAuthentication(authentication);

        SecurityContextHolder.setContext(securityContext);
    }

    public void accessAuthenticatedUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getPrincipal();
    }


}
