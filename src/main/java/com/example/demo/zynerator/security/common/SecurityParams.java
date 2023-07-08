package com.example.demo.zynerator.security.common;

public interface SecurityParams {
    String JWT_HEADER_NAME = "Authorization";
    String SECRET = "fd21c19b-3d44-4d72-9db7-8f7f3fc34bb1";
    long EXPIRATION = 86400000;
    String HEADER_PREFIX = "Bearer ";
}
