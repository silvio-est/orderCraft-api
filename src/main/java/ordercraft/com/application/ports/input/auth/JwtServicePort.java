package ordercraft.com.application.ports.input.auth;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServicePort {
    public String getToken(UserDetails userDetails);
    public Boolean isTokenValid(String token, UserDetails userDetails);
    public String getUsername(String token);
}
