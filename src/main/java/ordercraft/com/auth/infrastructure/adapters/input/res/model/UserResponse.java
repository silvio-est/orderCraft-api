package ordercraft.com.auth.infrastructure.adapters.input.res.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ordercraft.com.auth.domain.model.Role;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private Integer idUser;
    private String username;
    private Role role;

}


