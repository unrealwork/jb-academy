package account.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = RepeatedPasswordException.ERR_MSG)
public class RepeatedPasswordException extends RuntimeException {

     static final String ERR_MSG = "The passwords must be different!";

    public RepeatedPasswordException() {
        super(ERR_MSG);
    }
}
