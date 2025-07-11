import model.Account;
import model.Credit;
import service.AccountService;
import service.CreditService;

import java.util.Optional;
import java.util.Scanner;

public class CreditMenu {
    static CreditService creditService = new CreditService();
    public void InfoCredit(Account account){
        long id = account.getId();
        Optional<Credit> credit = creditService.findCredit(id);
        System.out.println(credit.isPresent() ? credit.get() : "❌ Кредит не найден.");
    }
}
