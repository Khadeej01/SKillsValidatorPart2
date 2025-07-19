package com.Skills_Validator.Apprenant_Service.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtUtil {
    private static final String SECRET = "secret_key_skills_validator";

    public static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    public static String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public static String extractRole(String token) {
        return (String) extractAllClaims(token).get("role");
    }
} 