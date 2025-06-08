import model.Account;
import service.AccountService;

import java.util.Optional;
import java.util.Scanner;

public class MainMenu {
    static AccountService accountService = new AccountService();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Финансовое приложение ====");
            System.out.println("1. Создать/выбрать аккаунт");
            System.out.println("2. Добавить кошелек");
            System.out.println("3. Добавить транзакцию (Приход/Расход)");
            System.out.println("4. Просмотр баланса кошелька");
            System.out.println("5. Просмотр долгов и кредитов");
            System.out.println("6. Отчеты (по категориям, по времени)");
            System.out.println("7. Выход");
            System.out.print("Выберите пункт: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> manageAccount();
                case 2 -> addWallet();
                case 3 -> addTransaction();
                case 4 -> viewWallets();
                case 5 -> viewDebtsAndCredits();
                case 6 -> showReports();
                case 7 -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private static void manageAccount() {
        System.out.println("\n-- Работа с аккаунтами --");
        System.out.println("1. Создать аккаунт");
        System.out.println("2. Найти аккаунт по ID");
        System.out.print("Выберите: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.print("User ID (например, Telegram ID): ");
            Long userId = Long.parseLong(scanner.nextLine());
            System.out.print("Имя: ");
            String firstName = scanner.nextLine();
            System.out.print("Фамилия: ");
            String lastName = scanner.nextLine();
            System.out.print("Отчество: ");
            String middleName = scanner.nextLine();

            accountService.createAccount(userId, firstName, middleName, lastName);
            System.out.println("✅ Аккаунт создан!");
        } else if (choice == 2) {
            System.out.print("Введите ID аккаунта: ");
            long id = Long.parseLong(scanner.nextLine());
            Optional<Account> account = accountService.findAccount(id);
            System.out.println(account.isPresent() ? account : "❌ Аккаунт не найден.");
        } else {
            System.out.println("Некорректный выбор.");
        }
    }


    private static void addWallet() {
        System.out.println("\n-- Добавление кошелька --");
        // Тут должен быть вызов WalletService
        System.out.println("🔧 (заглушка: добавить кошелек)");
    }

    private static void addTransaction() {
        System.out.println("\n-- Добавление транзакции --");
        // Тут должен быть вызов TransactionService
        System.out.println("🔧 (заглушка: добавить транзакцию)");
    }

    private static void viewWallets() {
        System.out.println("\n-- Список кошельков --");
        // Тут должен быть вызов WalletService
        System.out.println("🔧 (заглушка: показать список кошельков)");
    }

    private static void viewDebtsAndCredits() {
        System.out.println("\n-- Кредиты и долги --");
        // Тут должен быть вызов CreditService и DebtService
        System.out.println("🔧 (заглушка: показать долги и кредиты)");
    }

    private static void showReports() {
        System.out.println("\n-- Отчеты --");
        // Тут должен быть вызов ReportService
        System.out.println("🔧 (заглушка: показать отчеты)");
    }
}
