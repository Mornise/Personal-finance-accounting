package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import model.Account;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

public class AccountService {

    AccountDao accountDao = new AccountDaoImpl();
    public Account findAccount(long id){
        Account account = accountDao.getById(id);
        return account;
    }
}
