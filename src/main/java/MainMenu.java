import model.Account;

import java.util.Scanner;

public class MainMenu {

    static Scanner scanner = new Scanner(System.in);
    static AccountMenu accountMenu = new AccountMenu();

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
                case 1 -> accountMenu.manageAccount();
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


    private static void addWallet() {
        System.out.println("\n-- Добавление кошелька --");
        Account account = accountMenu.getAccount();
        System.out.println("Вы в аккаунте" + account);
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
