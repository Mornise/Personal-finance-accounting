package util;

import java.util.Scanner;

public class ValidatorUtil {

    static Scanner scanner = new Scanner(System.in);

    public static int enterChoice(int choice) {
        String string = scanner.nextLine();
        Integer inte = 0;
        do {
            try {
                inte = Integer.parseInt(string);

            } catch (NumberFormatException ex){
                System.out.println("Вы ввели неправильно!");
            }

        } while (inte >= choice && inte < 0);
        return inte;
    }
}
