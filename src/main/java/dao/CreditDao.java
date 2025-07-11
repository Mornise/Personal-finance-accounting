package dao;

import model.Account;
import model.Credit;

import java.util.List;
import java.util.Optional;

public interface CreditDao {
    // Получить аккаунт по ID
    Optional<Credit> getById(long id);

    // Получить аккаунт по Telegram user_id
    Optional<Credit> getByUserId(long userId);

    // Получить все аккаунты
    List<Credit> getAll();

    // Сохранить новый аккаунт
    void save(Credit credit);

    // Обновить данные аккаунта
    void update(Credit credit);

    // Удалить аккаунт
    boolean delete(long id);

}
