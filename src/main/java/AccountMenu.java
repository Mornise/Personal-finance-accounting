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

    public void manageAccount() {
        System.out.println("\n-- Работа с аккаунтами --");
        System.out.println("1. Создать аккаунт");
        System.out.println("2. Войти в аккаунт");
        System.out.print("Выберите: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.print("Имя: ");
            String firstName = scanner.nextLine();
            System.out.print("Фамилия: ");
            String lastName = scanner.nextLine();
            System.out.print("Отчество: ");
            String middleName = scanner.nextLine();

            System.out.print("Логин: ");
            String login = scanner.nextLine();

            System.out.print("Пароль: ");
            String password = scanner.nextLine();

            System.out.print("Повторите пароль: ");
            String passwordRepeat = scanner.nextLine();
            ///Проверка на пароли passwordRepeat = password
            accountService.createAccount(firstName, middleName, lastName, login, password);
            System.out.println("✅ Аккаунт создан!");
        } else if (choice == 2) {
            System.out.print("Введите логин: ");
            String login = scanner.nextLine();
            System.out.print("Введите пароль: ");///
            String password = scanner.nextLine();
            Optional<Account> account = accountService.findAccount(login, password);
            account.ifPresent(value -> this.account = value);
            System.out.println(account.isPresent() ? account : "Проверьте логин или пароль");
        } else {
            System.out.println("Некорректный выбор.");
        }
    }
}
