




package agroindia.agro.service;

import agroindia.agro.model.User;
import agroindia.agro.model.User.Role;  // Update this import to use Role from User class
import agroindia.agro.repository.UserRepository;
import agroindia.agro.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public List<User> getAllFarmers() {
        return userRepository.findByRole(User.Role.FARMER);  // Update to User.Role
    }

    public List<User> getAllBuyers() {
        return userRepository.findByRole(User.Role.BUYER);   // Update to User.Role
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}