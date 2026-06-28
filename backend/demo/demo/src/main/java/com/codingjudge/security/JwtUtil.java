package com.codingjudge.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtUtil {

    private static final String SECRET =
            "codingjudgecodingjudgecodingjudgecodingjudge123456";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 86400000)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String extractRole(String token) {

    Claims claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();

        return claims.get("role", String.class);
    }

    public boolean validateToken(String token) {

    try {
        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        return true;
    } catch (Exception e) {
        return false;
    }
    }
}