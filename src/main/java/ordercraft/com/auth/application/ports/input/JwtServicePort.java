package ordercraft.com.auth.application.ports.input;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServicePort {
    public String getToken(UserDetails userDetails);
    public Boolean isTokenValid(String token, UserDetails userDetails);
    public String getUsername(String token);
}
