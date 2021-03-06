package com.example.constant;

public class SecurityConstant {
    public static final String SIGN_UP_URLS = "/api/auth/**";
    public static final String SECRET = "SecretKeyGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 432_000_000; // 5 days expressed in milliseconds

    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String PROJECT_INSTA_LLC = "Project Insta, LLC";
    public static final String PROJECT_INSTA_ADMINISTRATION = "User Management Insta";
    public static final String AUTHORITIES = "authorities1";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = {"**"};
    public static final String[] PUBLIC_SWAGGER = {"/swagger-resources",
            "/configuration/security",
            "/configuration/ui",
            "/swagger-ui",
            "/v2/api-docs",
            "/v3/api-docs",
            "/webjars",
            "/auth",
            "/reset"};
}
