package com.depromeet.crackerbook.util;

import com.depromeet.crackerbook.config.auth.TokenType;
import com.depromeet.crackerbook.domain.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@UtilityClass
public class JwtUtil {

    private static final String SECRET_KEY = "1q2w3e4r!!";

    public static String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static Long extractUserId(String token) {
        return token != null ? extractClaim(token, claims -> claims.get("userId", Long.class)) : null;
    }

    public static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private static boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public static String generateToken(User user, TokenType tokenType) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());

        return createToken(claims, user.getEmail(), tokenType.getExpiration());
    }

    private static String createToken(Map<String, Object> claims, String subject, long expiration) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + expiration))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public static boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
