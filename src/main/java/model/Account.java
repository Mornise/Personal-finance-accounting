package model;

import java.util.Objects;

public class Account {
    private Integer id;
    private String first_name;

    public Account(Integer id, String first_name) {
        this.id = id;
        this.first_name = first_name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(first_name, account.first_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
