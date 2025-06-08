package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import model.Account;

import java.util.Optional;

public class AccountService {

    private final AccountDao accountDao = new AccountDaoImpl();

    // Получение аккаунта по ID
    public Optional<Account> findAccount(long id) {
        return accountDao.getById(id);
    }

    // Создание нового аккаунта
    public void createAccount(Long userId, String firstName, String middleName, String lastName) {
        Account newAccount = new Account(userId, firstName, middleName, lastName);
        accountDao.save(newAccount);
    }

    // Удаление аккаунта
    public boolean deleteAccount(long id) {
        return accountDao.delete(id);  // предполагается наличие delete()
    }

    // Проверка, существует ли аккаунт
    public boolean accountExists(long id) {
        return accountDao.getById(id).isPresent();
    }

    // TODO: добавить updateAccount(), если нужно редактирование
}
