package springSecurityDocDemo.example;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class SecurityExample {
    public void securityContextHolderExample(){
        // 인증을 하는 가장 간단한 방법 : 시큐리티 컨텍스트 홀더에 authentication을 넣어준다
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        Authentication authentication =
                new TestingAuthenticationToken("username", "password", "ROLE_USER");
        securityContext.setAuthentication(authentication);

        SecurityContextHolder.setContext(securityContext);

        // 정보 꺼내기
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication getAuthentication = context.getAuthentication();
        String username = authentication.getName();
        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    }

    public void accessAuthenticatedUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        System.out.println(authentication.isAuthenticated());
    }
}
