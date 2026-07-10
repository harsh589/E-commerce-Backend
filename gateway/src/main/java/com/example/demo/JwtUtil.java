package com.example.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {
//this is used to verify the jwt token of all the services
    private static final String SECRET = "mysecretkeymysecretkeymysecretkey"; // same as user-service

    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
