package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Dept {
    private Long id;
    private Long account_id;
    private String description;
    private BigDecimal amount;
    private String currency;
    private LocalDate date_output;
    private LocalDate date_taking;

    public Long getId() {
        return id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDate getDate_output() {
        return date_output;
    }

    public LocalDate getDate_taking() {
        return date_taking;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDate_output(LocalDate date_output) {
        this.date_output = date_output;
    }

    public void setDate_taking(LocalDate date_taking) {
        this.date_taking = date_taking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(id, dept.id) && Objects.equals(account_id, dept.account_id) && Objects.equals(description, dept.description) && Objects.equals(amount, dept.amount) && Objects.equals(currency, dept.currency) && Objects.equals(date_output, dept.date_output) && Objects.equals(date_taking, dept.date_taking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account_id, description, amount, currency, date_output, date_taking);
    }

    @Override
    public String toString() {
        return  "" +
                "\n-----------------------------" +
                "\nВаши долги: " +
                "\n Описание = " + description + '\'' +
                "\n Сумма = " + amount +
                "\n Валюта = " + currency + '\'' +
                "\n Дата возврата = " + date_output +
                "\n Дата взятия = " + date_taking +
                "\n-----------------------------" +
                "";
    }

    public Dept(Long id, Long account_id, String description, BigDecimal amount, String currency, LocalDate date_output, LocalDate date_taking) {
        this.id = id;
        this.account_id = account_id;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.date_output = date_output;
        this.date_taking = date_taking;
    }
}
