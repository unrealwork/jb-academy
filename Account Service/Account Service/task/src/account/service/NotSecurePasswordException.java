package account.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotSecurePasswordException extends RuntimeException {
    public NotSecurePasswordException(String message) {
        super(message);
    }
}
