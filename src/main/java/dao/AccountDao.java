package dao;

import model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDao {

    // Получить аккаунт по ID
    Optional<Account> getById(long id);

    // Получить аккаунт по Telegram user_id
    Optional<Account> getByUserId(long userId);

    // Получить все аккаунты
    List<Account> getAll();

    // Сохранить новый аккаунт
    void save(Account account);

    // Обновить данные аккаунта
    void update(Account account);

    // Удалить аккаунт
    boolean delete(long id);
}
