package account.service.payment;

import account.model.AccountPaymentDTO;

import java.util.List;

public interface AccountPaymentService {
    void save(List<AccountPaymentDTO> paymentDTOList);
    void update(AccountPaymentDTO paymentDTO);
}
