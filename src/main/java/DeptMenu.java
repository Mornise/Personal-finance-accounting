import model.Account;
import model.Dept;
import model.Credit;
import service.AccountService;
import service.CreditService;
import service.DeptService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class DeptMenu {
    static Scanner scanner = new Scanner(System.in);
    static DeptService deptService = new DeptService();
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public   void manageAccount() {
        System.out.println("\n-- Работа с аккаунтами --");
        System.out.println("1. Создать аккаунт");
        System.out.println("2. Найти аккаунт по ID");
        System.out.print("Выберите: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.print("ID аккаунта: ");
            Long account_id = Long.parseLong(scanner.nextLine());
            System.out.print("Описание: ");
            String description = scanner.nextLine();
            System.out.print("Фамилия: ");
            BigDecimal amount = scanner.nextBigDecimal();
            System.out.print("Валюта (BYN, RUB, USD): ");
            String currency = scanner.nextLine();
            System.out.print("Дата возврата: ");
            String date_output = scanner.nextLine();
            System.out.print("Дата взятия: ");
            String date_taking = scanner.nextLine();

            deptService.createDept(account_id, description, amount, currency, date_output, date_taking);
            System.out.println("✅ Долг создан!");
        } else if (choice == 2) {
            System.out.print("Введите ID аккаунта: ");
            long id = Long.parseLong(scanner.nextLine());
            Optional<Dept> dept = deptService.findDept(id);
            dept.ifPresent(value -> this.dept = value);
            System.out.println(dept.isPresent() ? dept : "❌ Аккаунт не найден.");
        } else {
            System.out.println("Некорректный выбор.");
        }
    }
}
