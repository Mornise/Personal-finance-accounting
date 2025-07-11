package model;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet{
    private Long id;
    private String name;
    private BigDecimal balance;
    private String currency;
    private Long account_id;
    private String type;

    public Wallet(Long id, String name, BigDecimal balance, String currency, Long account_id, String type) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.currency = currency;
        this.account_id = account_id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getAccount_id() {
        return account_id;
    }
    public String getType() {
        return type;
        }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(name, wallet.name) && Objects.equals(balance, wallet.balance) && Objects.equals(currency, wallet.currency) && Objects.equals(account_id, wallet.account_id) && Objects.equals(type, wallet.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance, currency, account_id, type);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", account_id=" + account_id +
                ", type='" + type + '\'' +
                '}';
    }
}
