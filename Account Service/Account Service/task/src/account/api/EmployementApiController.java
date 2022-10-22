package account.api;

import account.model.SignUpResult;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empl/")
public class EmployementApiController {
    @GetMapping("payment")
    @ResponseBody
    public SignUpResult payment(Authentication authentication) {
        throw new UnsupportedOperationException();
    }
}
