package account.validation;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SecurePasswordValidator {
    private static Set<String> BREACHED_PASSWORDS = Set.of("PasswordForJanuary", "PasswordForFebruary", "PasswordForMarch", "PasswordForApril",
            "PasswordForMay", "PasswordForJune", "PasswordForJuly", "PasswordForAugust",
            "PasswordForSeptember", "PasswordForOctober", "PasswordForNovember", "PasswordForDecember");

    public boolean isValid(String value) {
        return !BREACHED_PASSWORDS.contains(value);
    }

}
