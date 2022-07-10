package account.service;

import account.model.persistance.User;
import account.persistance.UserRepository;
import account.validation.SecurePasswordValidator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsManager {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final SecurePasswordValidator securePasswordValidator;

    public UserDetailServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, SecurePasswordValidator securePasswordValidator) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.securePasswordValidator = securePasswordValidator;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameIgnoreCase(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username " + username + " is not found.");
        }
        return user;
    }

    @Override
    public void createUser(UserDetails user) {
        if (userRepository.existsByUsernameIgnoreCase(user.getUsername())) {
            throw new UserExistException();
        }
        validatePassword(user.getPassword());
        User u = (User) user;
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userRepository.save(u);
    }

    @Override
    public void updateUser(UserDetails user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUser(String username) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        validatePassword(newPassword);
        if (passwordEncoder.matches(newPassword, oldPassword)) {
            throw new RepeatedPasswordException();
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    private void validatePassword(String newPassword) {
        if (newPassword.length() < 12) {
            throw new NotSecurePasswordException("Password length must be 12 chars minimum!");
        }
        if (!securePasswordValidator.isValid(newPassword)) {
            throw new NotSecurePasswordException("The password is in the hacker's database!");
        }
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsByUsernameIgnoreCase(username);
    }
}
