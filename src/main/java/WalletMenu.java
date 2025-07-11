import dao.WalletDao;
import dao.WalletDaoImpl;
import model.Account;
import model.Wallet;
import service.AccountService;
import service.WalletService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class WalletMenu {
    static Scanner scanner = new Scanner(System.in);
    static WalletService walletService = new WalletService();
    static WalletDao walletDao = new WalletDaoImpl();

    static void addWallet() {
        System.out.println("\n-- Добавление кошелька --");
        Account account = MainMenu.accountMenu.getAccount();
        System.out.println("Введите имя кошелька: ");
        String name = scanner.next();
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустым. Попробуйте снова.");
        }
        System.out.println("Выберите валюту: ");
        System.out.println("1. BYN");
        System.out.println("2. RUB");
        System.out.println("3. USD");
        int choice = scanner.nextInt();
        StringBuilder currency = new StringBuilder();
        switch (choice) {
            case 1:
                System.out.println("BYN");
                currency.append("BYN");
                break;
            case 2:
                System.out.println("RUB");
                currency.append("RUB");
                break;
            case 3:
                System.out.println("USD");
                currency.append("USD");
                break;
            default:
                System.out.println("Некорректный выбор валюты. Операция отменена.");
                return;
        }
        String type = "";
        System.out.println("Выберите тип кошелька: ");
        System.out.println("1. Карта");
        System.out.println("2. Крипта");
        System.out.println("3. Наличные");
        int choice1 = scanner.nextInt();
        switch (choice1) {
            case 1:
                System.out.println("Карта");
                type = "Карта";
                break;
            case 2:
                System.out.println("Крипта");
                type = "Крипта";
                break;
            case 3:
                System.out.println("Наличные");
                type = "Наличные";
                break;
            default:
                System.out.println("Некорректный выбор типа кошелька. Операция отменена.");
                return;
        }
        try {
            Long account_id = account.getId();
            walletService.createWallet(1L, name, new BigDecimal(0.0), currency.toString(), account_id, type);
            System.out.println("Кошелек создан");
            viewWallets();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при создании кошелька: " + e.getMessage());
        }
    }
    static void viewWallets() {
        System.out.println("\n-- Список кошельков --");
        try {
            Account account = MainMenu.accountMenu.getAccount();
            Long accountId = account.getId();
            List<Wallet> wallets = walletDao.getByAcountId(accountId);
            if (wallets.isEmpty()) {
                System.out.println("У вас нет кошельков.");
            } else {
                for (Wallet wallet : wallets) {
                    System.out.println(wallet);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при получении списка кошельков: " + e.getMessage());
        }
    }
    static void deleteWallet() {
        try {
            System.out.println("Введите ID кошелька для удаления:");
            long walletId = scanner.nextLong();
            Account account = MainMenu.accountMenu.getAccount();
            Long accountId = account.getId();
            List<Wallet> wallets = walletDao.getByAcountId(accountId);
            boolean found = false;
            for (Wallet wallet : wallets) {
                if (wallet.getId() == walletId) {
                    found = true;
                    break;
                }
            }
            if (found) {
                walletService.deleteWallet(walletId);
                System.out.println("Кошелек успешно удален.");
            } else {
                System.out.println("Кошелек с таким ID не найден у вашего аккаунта.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при удалении кошелька: " + e.getMessage());
        }
    }
}


