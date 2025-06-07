package dao;

import model.Account;

public interface AccountDao {
    Account getById(final long id);
}
