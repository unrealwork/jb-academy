package account.api;

import account.model.ChangePasswordRequest;
import account.model.ChangePasswordResult;
import account.model.SignUpRequest;
import account.model.SignUpResult;
import account.model.persistance.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthApiController {
    private final UserDetailsManager userDetailsService;

    public AuthApiController(UserDetailsManager userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("signup")
    public SignUpResult signup(@RequestBody @Valid SignUpRequest request) {
        User user = userRequestToDetails(request);
        userDetailsService.createUser(user);
        return SignUpResult.fromUser(user);
    }


    @PostMapping("changepass")
    public ChangePasswordResult changePassword(final @RequestBody @Valid ChangePasswordRequest request, final @AuthenticationPrincipal UserDetails user) {
        userDetailsService.changePassword(user.getPassword(), request.getNewPassword());
        return ChangePasswordResult.success(user.getUsername());
    }

    private User userRequestToDetails(SignUpRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setPassword(request.getPassword());
        user.setUsername(request.getEmail().toLowerCase());
        return user;
    }
}
