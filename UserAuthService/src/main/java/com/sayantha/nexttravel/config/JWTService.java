package com.sayantha.nexttravel.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {
    private static final String SECRET_KEY = "C8A47F2B98E071F55A9676E16994C042D2A4D68EACDBBB72D866F8A75F91E406";

    public String extractUsername(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    private Claims extractAllClaims(String jwtToken) {
        return Jwts.
                parserBuilder().
                setSigningKey(getSecretKey()) //Verifies the signature.
                .build().
                parseClaimsJws(jwtToken).
                getBody();
    }

    private Key getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }
    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }
    public String generateToken(Map<String,Object> claims, UserDetails userDetails) {
        return Jwts.builder().
                setClaims(claims).
                setSubject(userDetails.getUsername()).
                signWith(getSecretKey(), SignatureAlgorithm.HS256).
                setIssuedAt(new Date(System.currentTimeMillis())). //Setting the time of issue of the token.
                setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)). //Setting the expiration time of the token.
                compact();


    }
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }
    public boolean validateToken(String jwtToken, UserDetails userDetails) {
        final String username = extractUsername(jwtToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
    }

    private boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration);
    }


}
