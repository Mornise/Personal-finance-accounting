import model.Account;
import service.AccountService;

import java.util.Optional;
import java.util.Scanner;

public class AccountMenu {
    static Scanner scanner = new Scanner(System.in);
    static AccountService accountService = new AccountService();
    private Account account;

    public Account getAccount() {
        return account;
    }

    public   void manageAccount() {
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
            account.ifPresent(value -> this.account = value);
            System.out.println(account.isPresent() ? account : "❌ Аккаунт не найден.");
        } else {
            System.out.println("Некорректный выбор.");
        }
    }
}
