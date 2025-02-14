package com.network.com.services.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@RequiredArgsConstructor
@Component
public class JwtUtil {
    public static final String SECRET = "413F4428472B4B6250655368566D5970337336763979244226452948404D6351";
    public String generateToken(String userName)
    {
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+10000 *60 *30))
                .signWith(getSignkey(), SignatureAlgorithm.HS256).compact();
    }
@PostConstruct
    private Key getSignkey() {
        byte[] keybytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keybytes);
    }
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private <T>T extractClaim(String token, Function<Claims,T>claimsResolver) {
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignkey()).build().parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());

    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
