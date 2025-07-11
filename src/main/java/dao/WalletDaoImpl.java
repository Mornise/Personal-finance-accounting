package dao;
import model.Wallet;
import util.DbUtil;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class WalletDaoImpl implements WalletDao {
    @Override
    public Optional<Wallet> getById(long id) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM wallet WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Wallet wallet = mapRowToWallet(rs);
                return Optional.of(wallet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    @Override
    public List<Wallet> getByAcountId(long account_id) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM wallet WHERE account_id = ?");
            stmt.setLong(1, account_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Wallet wallet = mapRowToWallet(rs);
                return List.of(wallet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }
    @Override
    public void save(Wallet wallet) {
        String sql = "INSERT INTO wallet (name,balance,currency,account_id,type) VALUES (?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, wallet.getName());
            stmt.setBigDecimal(2, wallet.getBalance());
            stmt.setString(3, wallet.getCurrency());
            stmt.setLong(4, wallet.getAccount_id());
            stmt.setString(5, wallet.getType());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating account failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    wallet.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating account failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Wallet wallet) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE wallet SET name = ?, balance = ?,currency = ?, account_id = ? WHERE id = ?");
            stmt.setString(1, wallet.getName());
            stmt.setBigDecimal(2, wallet.getBalance());
            stmt.setString(3, wallet.getCurrency());
            stmt.setLong(4,wallet.getAccount_id());
            stmt.setLong(5, wallet.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(long id) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM wallet WHERE id = ?");
            stmt.setLong(1, id);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Wallet mapRowToWallet(ResultSet rs) throws SQLException {
        return new Wallet(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getBigDecimal("balance"),
                rs.getString("currency"),
                rs.getLong("account_id"),
                rs.getString("type")

        );
    }}

