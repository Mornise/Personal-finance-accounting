package service;

import dao.CreditDao;
import dao.CreditDaoImpl;
import model.Credit;

import java.util.Optional;

public class CreditService {

    private final CreditDao creditDao = new CreditDaoImpl();

    // Получение аккаунта по ID
    public Optional<Credit> findCredit(long id) {
        return creditDao.getById(id);
    }
}
