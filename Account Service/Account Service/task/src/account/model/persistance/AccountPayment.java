package account.model.persistance;

import account.persistance.AccountPaymentId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@IdClass(AccountPaymentId.class)
public class AccountPayment {
    @Id
    @ManyToOne
    @JoinColumn(name = "USERNAME")
    @Column(columnDefinition = "DATE")
    private User user;
    @Id
    private LocalDate period;
    private Long salary;


    public LocalDate getPeriod() {
        return period;
    }

    public void setPeriod(LocalDate period) {
        this.period = period;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
