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

    public Optional<Account> findAccount(String login, String password) {
        return accountDao.getByLoginAndPassword(login, password);
    }

    // Создание нового аккаунта
    public void createAccount(String firstName, String middleName, String lastName, String login, String password) {
        Account newAccount = new Account(firstName, middleName, lastName,login, password);
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
