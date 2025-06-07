import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://aws-0-eu-west-3.pooler.supabase.com:5432/postgres?sslmode=require";
        String user = "postgres.lkjziuhvskioazqrxmah";
        String password = "finanse_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Подключение установлено через Session Pooler!");
            } else {
                System.out.println("Не удалось подключиться.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении: " + e.getMessage());
        }
    }
}
