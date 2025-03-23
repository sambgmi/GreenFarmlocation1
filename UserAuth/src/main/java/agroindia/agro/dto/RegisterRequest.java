package agroindia.agro.dto;

import agroindia.agro.model.User.Role;
import agroindia.agro.model.User;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
    // Add location field
    private String location;
}