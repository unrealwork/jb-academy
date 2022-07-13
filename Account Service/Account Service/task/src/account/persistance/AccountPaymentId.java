package account.persistance;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountPaymentId implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountPaymentId that = (AccountPaymentId) o;
        return id == that.id && period.equals(that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, period);
    }

    private long id;
    private LocalDate period;

    public AccountPaymentId() {
    }

    public AccountPaymentId(long id, LocalDate period) {
        this.id = id;
        this.period = period;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPeriod() {
        return period;
    }

    public void setPeriod(LocalDate period) {
        this.period = period;
    }
}
