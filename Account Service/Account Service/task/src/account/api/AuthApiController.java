package account.api;

import account.model.SignUpResult;
import account.model.persistance.User;
import org.springframework.http.MediaType;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthApiController {
    private final UserDetailsManager userDetailsService;

    public AuthApiController(UserDetailsManager userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SignUpResult signup(@RequestBody @Valid SignUpRequest request) {
        User user = userRequestToDetails(request);
        userDetailsService.createUser(user);
        return SignUpResult.fromUser(user);
    }

    private User userRequestToDetails(SignUpRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setPassword(request.getPassword());
        user.setUsername(request.getEmail());
        return user;
    }
}
