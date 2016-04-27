# spring-security-authority
User login and access authority system based on spring security.

## reference
[Thymeleaf模板Spring Security标签支持](https://github.com/thymeleaf/thymeleaf-extras-springsecurity)
[UsernamePasswordAuthenticationToken](http://docs.spring.io/spring-security/site/docs/3.2.x/apidocs/org/springframework/security/authentication/UsernamePasswordAuthenticationToken.html)
[Authentication](http://docs.spring.io/spring-security/site/docs/3.2.x/apidocs/org/springframework/security/core/Authentication.html)
[GrantedAuthority](http://docs.spring.io/spring-security/site/docs/3.2.x/apidocs/org/springframework/security/core/GrantedAuthority.html)
** [Principal](http://docs.oracle.com/javase/6/docs/api/java/security/Principal.html?is-external=true) **

## Authentication内容
``` java
org.springframework.security.authentication.UsernamePasswordAuthenticationToken@d673ff10: Principal: org.springframework.security.core.userdetails.User@d647d96f: 
Username: yxiao@aliyun.com; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; 
Granted Authorities: user; Credentials: [PROTECTED]; Authenticated: true; Details: org.springframework.security.web.authentication.WebAuthenticationDetails@fffd3270: 
RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: 0CFD10DC51A2F6A614ECE58633DA1087; Granted Authorities: user
```

## Using the expression utility objects
The `authentication` and `authorization` object can be easily used, like this:
``` xml
<div sec:authorize="${hasRole('ROLE_ADMIN')}">
    This will only be displayed if authenticated user has role ROLE_ADMIN.
</div>
<div th:text="${#authorization.expression('hasRole(''ROLE_ADMIN'')')}">
    If authenticated user has role ROLE_ADMIN, output is 'true'. Otherwise, output is 'false'.
</div>
<div th:text="${#authentication.getAuthorities()[0].getAuthority()}">
    If authenticated user has role ROLE_ADMIN, output is 'ROLE_ADMIN'.
</div>
<div th:text="${#authentication.getAuthorities()}">
    If authenticated user has role ROLE_ADMIN, output is '[ROLE_ADMIN]'.
</div>
<span sec:authentication="principal.authorities">If authenticated user has role ROLE_ADMIN, output is '[ROLE_ADMIN]'.</span>
```

## 


