package dao;

import model.Account;

import java.sql.*;

import static util.DbUtil.*;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account getById(long id) {

        Account account = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getInt("id"),
                        rs.getString("first_name")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
