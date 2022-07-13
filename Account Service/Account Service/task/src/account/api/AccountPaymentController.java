package account.api;


import account.model.UploadResult;
import account.model.AccountPaymentDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/acct/payments")
public class AccountPaymentController {

    @PostMapping
    public UploadResult upload(@RequestBody List<AccountPaymentDTO> paymentList) {
        throw new UnsupportedOperationException();
    }

    @PutMapping
    public AccountPaymentDTO changeSalary(@RequestBody @Valid AccountPaymentDTO accountPayment) {
        throw new UnsupportedOperationException(); 
    }
}
