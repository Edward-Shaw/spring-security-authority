# spring-security-authority
User login and access authority system based on spring security.

## reference
[Thymeleaf模板Spring Security标签支持](https://github.com/thymeleaf/thymeleaf-extras-springsecurity)
[UsernamePasswordAuthenticationToken](http://docs.spring.io/spring-security/site/docs/3.2.x/apidocs/org/springframework/security/authentication/UsernamePasswordAuthenticationToken.html)
[Authentication](http://docs.spring.io/spring-security/site/docs/3.2.x/apidocs/org/springframework/security/core/Authentication.html)
[GrantedAuthority](http://docs.spring.io/spring-security/site/docs/3.2.x/apidocs/org/springframework/security/core/GrantedAuthority.html)
** [Principal](http://docs.oracle.com/javase/6/docs/api/java/security/Principal.html?is-external=true) **
[thymeleaf](http://www.thymeleaf.org/doc/articles/springsecurity.html)
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
<span sec:authentication="principal.authorities">
    If authenticated user has role ROLE_ADMIN, output is '[ROLE_ADMIN]'.
</span>
```

## Expression-Based Access Control
Spring Security uses Spring EL for expression support. 
Expressions are evaluated with a "root object" as part of the evaluation context. Spring Security uses specific classes for web and method security as the root object, 
in order to provide built-in expressions and access to values such as the current principal.
The base class for expression root objects is `SecurityExpressionRoot`. This provides some common expressions which are available in both web and method security.

### Common Built-in Expresssions
| Expression        | Description           | 
| ------------- |:-------------:| 
| hasRole([role]) | Returns true if the current principal has the specified role. ** By default if the supplied role does not start with 'ROLE_' it will be added.** This can be customized by modifying the defaultRolePrefix on DefaultWebSecurityExpressionHandler.| 
| hasAnyRole([role1,role2])       | Returns true if the current principal has any of the supplied roles (given as a commaseparated list of strings). By default if the supplied role does not start with 'ROLE_' it will be added. This can be customized by modifying the defaultRolePrefix on DefaultWebSecurityExpressionHandler.      |   
| hasAuthority([authority])  | Returns true if the current principal has the specified authority.      |    
| hasAnyAuthority([authority1,authority2]) | Returns true if the current principal has any of the supplied roles (given as a comma-separated list of strings) |
| principal | Allows direct access to the principal object representing the current user |
| authentication | Allows direct access to the current Authentication object obtained from the SecurityContext |
| permitAll | Always evaluates to true |
| denyAll | Always evaluates to false |
| isAnonymous() | Returns true if the current principal is an anonymous user |
| isRememberMe() | Returns true if the current principal is a remember-me user |
| isAuthenticated() |  Returns true if the user is not anonymous |
| isFullyAuthenticated()  | Returns true if the user is not an anonymous or a remember-me user |
| hasPermission(Object target, Objectpermission) | Returns true if the user has access to the provided target for the given permission. For example, hasPermission(domainObject,'read') | 
| hasPermission(Object targetId,String targetType, Objectpermission) | Returns true if the user has access to the provided target for the given permission. For example, hasPermission(1,'com.example.domain.Message','read') |



