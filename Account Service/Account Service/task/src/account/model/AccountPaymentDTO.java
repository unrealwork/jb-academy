package account.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class AccountPaymentDTO {
    @NotBlank
    private String employee;
    @NotBlank
    private String period;
    private @Min(0) Long salary;

    @Override
    public String toString() {
        return "AccountPaymentDTO{" +
                "employee='" + employee + '\'' +
                ", period='" + period + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountPaymentDTO that = (AccountPaymentDTO) o;
        return salary.equals(that.salary) && employee.equals(that.employee) && period.equals(that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, period, salary);
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
