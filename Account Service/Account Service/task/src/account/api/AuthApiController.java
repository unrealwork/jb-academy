package account.api;

import account.model.SignUpResult;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthApiController {
    private JdbcUserDetailsManager userDetailsService;

    @PostMapping("signup")
    @ResponseBody
    public UserDetails signup(@RequestBody @Valid SignUpRequest request) {
        userDetailsService.createUser(userRequestToDetails(request));
        return userDetailsService.loadUserByUsername(request.getEmail());
    }

    private User userRequestToDetails(SignUpRequest request) {
        return new User(request.getEmail(), request.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER")));
    }
}
