import service.AccountService;

public class MainMenu {
    static AccountService accountService = new AccountService();
    public static void main(String[] args) {
        System.out.println("Меню");
        System.out.println("Найти аккаунт");
        System.out.println(accountService.findAccount(1));
    }
}
