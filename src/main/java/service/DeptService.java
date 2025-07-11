package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.DeptDao;
import dao.DeptDaoImpl;
import model.Account;
import model.Dept;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class DeptService {

    private final DeptDao deptDao = new DeptDaoImpl();

    // Получение аккаунта по ID
    public Optional<Dept> findDept(long id) {
        return deptDao.getById(id);
    }

    // Создание нового аккаунта
    public void createDept(Long account_id, String description, BigDecimal amount, String currency, String date_output, String date_taking) {
        Dept newDept = new Dept(account_id, description, amount, currency, date_output, date_taking);
        deptDao.save(newDept);
    }

    // Удаление аккаунта
    public boolean deleteDept(long id) {
        return deptDao.delete(id);  // предполагается наличие delete()
    }

    // Проверка, существует ли аккаунт
    public boolean deptExists(long id) {
        return deptDao.getById(id).isPresent();
    }
}
