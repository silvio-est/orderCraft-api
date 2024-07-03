package ordercraft.com.auth.infrastructure.adapters.input.res.model;

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
