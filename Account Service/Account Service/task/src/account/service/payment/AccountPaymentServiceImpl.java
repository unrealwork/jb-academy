package account.service.payment;

import account.model.AccountPaymentDTO;
import account.model.persistance.AccountPayment;
import account.model.persistance.User;
import account.persistance.AccountPaymentRepository;
import account.persistance.UserRepository;
import account.util.ParsingUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class AccountPaymentServiceImpl implements AccountPaymentService {
    private final AccountPaymentRepository accountPaymentRepository;
    private final UserRepository userRepository;

    public AccountPaymentServiceImpl(AccountPaymentRepository accountPaymentRepository, UserRepository userRepository) {
        this.accountPaymentRepository = accountPaymentRepository;
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public void save(List<AccountPaymentDTO> paymentDTOList) {
        for (AccountPaymentDTO accountPaymentDTO : paymentDTOList) {
            AccountPayment accountPayment = accountPaymentEntity(accountPaymentDTO);
            accountPaymentRepository.save(accountPayment);
        }
    }

    @Override
    public void update(AccountPaymentDTO paymentDTO) {
        throw new UnsupportedOperationException();
    }

    private AccountPayment accountPaymentEntity(final @NotNull AccountPaymentDTO accountPaymentDTO) {
        final User user = userRepository.findByUsernameIgnoreCase(accountPaymentDTO.getEmployee());
        final AccountPayment payment = new AccountPayment();
        payment.setPeriod(ParsingUtil.parseDate(accountPaymentDTO.getPeriod()));
        payment.setSalary(accountPaymentDTO.getSalary());
        payment.setUser(user);
        return payment;
    }
}
