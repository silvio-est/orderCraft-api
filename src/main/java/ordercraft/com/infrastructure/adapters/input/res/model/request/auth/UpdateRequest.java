package ordercraft.com.infrastructure.adapters.input.res.model.request.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    private Integer idUser;
    private String username;
    private String password;
    private String role;
}
