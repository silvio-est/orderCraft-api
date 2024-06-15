package ordercraft.com.infrastructure.adapters.input.res.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ordercraft.com.domain.model.Role;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private Integer idUser;
    private String username;
    private Role role;

}


