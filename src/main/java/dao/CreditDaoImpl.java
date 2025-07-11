package dao;

import model.Account;
import model.Credit;
import util.DbUtil;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CreditDaoImpl implements CreditDao {
    @Override
    public Optional<Credit> getById(long id) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM credit WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Credit credit = mapRowToCredit(rs);
                return Optional.of(credit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Credit> getByUserId(long userId) {
        return Optional.empty();
    }

    @Override
    public List<Credit> getAll() {
        return List.of();
    }

    @Override
    public void save(Credit credit) {

    }

    @Override
    public void update(Credit credit) {

    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    private Credit mapRowToCredit(ResultSet rs) throws SQLException {
        return new Credit(
                rs.getLong("id"),
                rs.getBigDecimal("amount"),
                rs.getDate("date_taken").toLocalDate(),
                rs.getString("currency"),
                rs.getBigDecimal("monthly_payment"),
                rs.getBigDecimal("interest_rate"),
                rs.getString("description"),
                rs.getLong("account_id")
        );
    }
}
