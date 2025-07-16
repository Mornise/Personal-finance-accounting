package service;

import dao.WalletDao;
import dao.WalletDaoImpl;
import model.Wallet;
import java.util.Optional;

public class WalletService {
    private final WalletDao walletDao = new WalletDaoImpl();

    public Optional<Wallet> findWallet(long id) {
        return walletDao.getById(id);
    }
    public void createWallet(Wallet wallet) {
        walletDao.save(wallet);
    }
    public boolean deleteWallet(long id) {
        return walletDao.delete(id);
    }
    public boolean walletExists(long id) {
        return walletDao.getById(id).isPresent();
}}