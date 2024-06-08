package ordercraft.com.application.service.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import ordercraft.com.application.ports.input.auth.JwtServicePort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class JwtService implements JwtServicePort {

    private static final String SECRET_KEY = "9h4K2PqK2l7R3sE8W1gT5bR7nC8fU1wD0aS6jA3vG5mZ4cH9xY2nM8vE4rT5yB";

    @Override
    public String getToken(UserDetails userDetails) {
        return searchToken(new HashMap<>(), userDetails);
    }

    private String searchToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte [] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsername(String token) {
        return getClaims(token, Claims::getSubject);
    }

    public Boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = getUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpiration(token));

    }

    private Claims getAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey()).build()
                .parseClaimsJws(token)
                .getBody();

    }

    public <T> T getClaims(String token, Function<Claims, T> claimsTFunction){
        final Claims claims = getAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    private Date getExpiration(String token){
        return getClaims(token, Claims::getExpiration);
    }

    private boolean isTokenExpiration(String token){
        return getExpiration(token).before(new Date());
    }
}
