package account.persistance;

import account.model.persistance.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsernameIgnoreCase(String username);

    void deleteByUsername(String username);

    boolean existsByUsernameIgnoreCase(String username);
}
