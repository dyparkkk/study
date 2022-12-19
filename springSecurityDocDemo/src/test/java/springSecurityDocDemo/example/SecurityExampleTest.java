package springSecurityDocDemo.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.ProviderManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecurityExampleTest {

    @Test
    void authentication_GetTest() {
        SecurityExample securityExample = new SecurityExample();
        securityExample.securityContextHolderExample();
        securityExample.accessAuthenticatedUser();
    }

}