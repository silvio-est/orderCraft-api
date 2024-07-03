package ordercraft.com.auth.infrastructure.adapters.input.res.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthResponse {
    private String token;
    private String role;
    private String username;
}
