import model.Account;

import java.util.Scanner;

public class MainMenu {

    static Scanner scanner = new Scanner(System.in);
    static AccountMenu accountMenu = new AccountMenu();

    public static void main(String[] args) {
        if(accountMenu.getAccount() == null){
                accountMenu.manageAccount();
        } else {
            while (true) {
                System.out.println("\n==== Финансовое приложение ====");
                System.out.println("1. Добавить кошелек");
                System.out.println("2. Добавить транзакцию (Приход/Расход)");
                System.out.println("3. Просмотр баланса кошелька");
                System.out.println("4. Просмотр долгов и кредитов");
                System.out.println("5. Отчеты (по категориям, по времени)");
                System.out.println("6. Выход");
                System.out.print("Выберите пункт: ");
                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 6.");
                    continue;
                }
                switch (choice) {
                    case 1 -> WalletMenu.addWallet();
                    case 2 -> addTransaction();
                    case 3 -> WalletMenu.viewWallets();
                    case 4 -> viewDebtsAndCredits();
                    case 5 -> showReports();
                    case 6 -> {
                        System.out.println("Выход из программы...");
                        return;
                    }
                    default -> System.out.println("Некорректный выбор. Попробуйте снова.");
                }
            }
        }
    }
    static void addTransaction() {
        System.out.println("\n-- Добавление транзакции --");
        // Тут должен быть вызов TransactionService
        System.out.println("🔧 (заглушка: добавить транзакцию)");
            }
    static void viewDebtsAndCredits() {
        System.out.println("\n-- Кредиты и долги --");
        // Тут должен быть вызов CreditService и DebtService
        System.out.println("🔧 (заглушка: показать долги и кредиты)");
    }

    static void showReports() {
        System.out.println("\n-- Отчеты --");
        // Тут должен быть вызов ReportService
        System.out.println("🔧 (заглушка: показать отчеты)");
    }
}








