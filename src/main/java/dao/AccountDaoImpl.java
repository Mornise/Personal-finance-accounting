package dao;

import model.Account;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Optional<Account> getById(long id) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account account = mapRowToAccount(rs);
                return Optional.of(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Account> getByUserId(long userId) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account WHERE user_id = ?");
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account account = mapRowToAccount(rs);
                return Optional.of(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account");
            while (rs.next()) {
                accounts.add(mapRowToAccount(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public void save(Account account) {
        String sql = "INSERT INTO account (user_id, first_name, middle_name, last_name) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, account.getUserId());
            stmt.setString(2, account.getFirstName());
            stmt.setString(3, account.getMiddleName());
            stmt.setString(4, account.getLastName());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating account failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    account.setId(generatedKeys.getLong(1)); // установим id в объект
                } else {
                    throw new SQLException("Creating account failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Account account) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE account SET first_name = ?, middle_name = ?, last_name = ? WHERE id = ?");
            stmt.setString(1, account.getFirstName());
            stmt.setString(2, account.getMiddleName());
            stmt.setString(3, account.getLastName());
            stmt.setLong(4, account.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(long id) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM account WHERE id = ?");
            stmt.setLong(1, id);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;  // если удалена хотя бы 1 строка — успех
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // при ошибке возвращаем false
        }
    }


    private Account mapRowToAccount(ResultSet rs) throws SQLException {
        return new Account(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("first_name"),
                rs.getString("middle_name"),
                rs.getString("last_name"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
