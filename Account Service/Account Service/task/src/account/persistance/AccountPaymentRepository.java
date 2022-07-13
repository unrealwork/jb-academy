package account.persistance;

import account.model.persistance.AccountPayment;
import org.springframework.data.repository.CrudRepository;

public interface AccountPaymentRepository extends CrudRepository<AccountPayment, AccountPaymentId> {
}
