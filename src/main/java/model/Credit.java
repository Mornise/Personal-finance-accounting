package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Credit {
    private Long id;
    private BigDecimal amount;
    private LocalDate date_taken;
    private String currency;
    private BigDecimal monthly_payment;
    private BigDecimal interest_rate;
    private String description;
    private Long account_id;

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate_taken() {
        return date_taken;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getMonthly_payment() {
        return monthly_payment;
    }

    public BigDecimal getInterest_rate() {
        return interest_rate;
    }

    public String getDescription() {
        return description;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate_taken(LocalDate date_taken) {
        this.date_taken = date_taken;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setMonthly_payment(BigDecimal monthly_payment) {
        this.monthly_payment = monthly_payment;
    }

    public void setInterest_rate(BigDecimal interest_rate) {
        this.interest_rate = interest_rate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Credit(Long id, BigDecimal amount, LocalDate date_taken, String currency, BigDecimal monthly_payment, BigDecimal interest_rate, String description, Long account_id) {
        this.id = id;
        this.amount = amount;
        this.date_taken = date_taken;
        this.currency = currency;
        this.monthly_payment = monthly_payment;
        this.interest_rate = interest_rate;
        this.description = description;
        this.account_id = account_id;
    }

    public Credit() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(id, credit.id) && Objects.equals(amount, credit.amount) && Objects.equals(date_taken, credit.date_taken) && Objects.equals(currency, credit.currency) && Objects.equals(monthly_payment, credit.monthly_payment) && Objects.equals(interest_rate, credit.interest_rate) && Objects.equals(description, credit.description) && Objects.equals(account_id, credit.account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date_taken, currency, monthly_payment, interest_rate, description, account_id);
    }

    @Override
    public String toString() {
        return  "" +
                "\n-----------------------------" +
                "\nВаши кредиты: " +
                "\n Сумма = " + amount +
                "\n Дата взятия = " + date_taken +
                "\n Валюта = " + currency + '\'' +
                "\n Ежемесячный платёж = " + monthly_payment +
                "\n Проценты = " + interest_rate +
                "\n Описание = " + description + '\'' +
                "\n-----------------------------" +
                "";
    }
}
