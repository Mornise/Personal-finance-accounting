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
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Пожалуйста, введите число 1 или 2.");
            return;
        }
        if (choice == 1) {
            System.out.print("Имя: ");
            String firstName = scanner.nextLine().trim();
            if (firstName.isEmpty()){
                System.out.println("Имя не может быть пустым. Попробуйте снова.");
            }
            System.out.print("Фамилия: ");
            String lastName = scanner.nextLine().trim();
            if (lastName.isEmpty()){
                System.out.println("Фамилия не может быть пустым. Попробуйте снова.");
            }
            System.out.print("Отчество: ");
            String middleName = scanner.nextLine().trim();
            if (middleName.isEmpty()){
                System.out.println("Отчество не может быть пустым. Попробуйте снова.");
            }
            System.out.print("Логин: ");
            String login = scanner.nextLine();
            if (login.isEmpty()){
                System.out.println("Логин не может быть пустым. Попробуйте снова.");
            }
            System.out.print("Пароль: ");
            String password = scanner.nextLine();
            if (password.isEmpty()){
                System.out.println("Пароль не может быть пустым. Попробуйте снова.");
            }
            System.out.print("Повторите пароль: ");
            String passwordRepeat = scanner.nextLine();

            if (!password.equals(passwordRepeat)) {
                System.out.println("Пароли не совпадают. Попробуйте снова.");
            } else {
                accountService.createAccount(firstName, middleName, lastName, login, password);
                System.out.println("✅ Аккаунт создан!");
            }
        } else if (choice == 2) {
            System.out.print("Введите логин: ");
            String login = scanner.nextLine();
            if (login.isEmpty()){
                System.out.println("Логин не может быть пустым. Попробуйте снова.");
            }
            System.out.print("Введите пароль: ");///
            String password = scanner.nextLine();
            if (password.isEmpty()){
                System.out.println("Пароль не может быть пустым. Попробуйте снова.");
            }
            Optional<Account> account = accountService.findAccount(login, password);
            account.ifPresent(value -> this.account = value);
            System.out.println(account.isPresent() ? account : "Проверьте логин или пароль");
        } else {
            System.out.println("Некорректный выбор.");
        }
    }
}
