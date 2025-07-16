package dao;

import model.Wallet;

import java.util.List;
import java.util.Optional;

public interface WalletDao {
    Optional<Wallet> getById(long id);

    List<Wallet> getWalletByAcountId(long account_id);

    void save(Wallet wallet);

    void update(Wallet wallet);

    boolean delete(long id);
}
