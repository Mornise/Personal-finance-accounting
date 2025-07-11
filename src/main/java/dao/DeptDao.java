package dao;

import model.Account;
import model.Dept;

import java.util.List;
import java.util.Optional;

public interface DeptDao {
    // Получить аккаунт по ID
    Optional<Dept> getById(long id);

    // Получить аккаунт по Telegram user_id
    Optional<Dept> getByUserId(long userId);

    // Получить все аккаунты
    List<Dept> getAll();

    // Сохранить новый аккаунт
    void save(Dept dept);

    // Обновить данные аккаунта
    void update(Dept dept);

    // Удалить аккаунт
    boolean delete(long id);

}