package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.WalletDao;
import dao.WalletDaoImpl;
import model.Account;
import model.Wallet;

import java.math.BigDecimal;
import java.util.Optional;

public class WalletService {
    private final WalletDao walletDao = new WalletDaoImpl();

    public Optional<Wallet> findWallet(long id) {
        return walletDao.getById(id);
    }
    public void createWallet(Long id, String name, BigDecimal balance, String currency, Long account_id, String type) {
        Wallet newWallet = new Wallet(id, name, balance, currency, account_id,type);
        walletDao.save(newWallet);
    }
    public boolean deleteWallet(long id) {
        return walletDao.delete(id);
    }
    public boolean walletExists(long id) {
        return walletDao.getById(id).isPresent();
}}