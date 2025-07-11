package dao;

import model.Dept;
import util.DbUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class DeptDaoImpl implements DeptDao {
    @Override
    public Optional<Dept> getById(long id) {
        try (Connection conn = DriverManager.getConnection(DbUtil.URL, DbUtil.USER, DbUtil.PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM debt WHERE account_id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Dept dept = mapRowToDept(rs);
                return Optional.of(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Dept> getByUserId(long userId) {
        return Optional.empty();
    }

    @Override
    public List<Dept> getAll() {
        return List.of();
    }

    @Override
    public void save(Dept dept) {

    }

    @Override
    public void update(Dept dept) {

    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    private Dept mapRowToDept(ResultSet rs) throws SQLException {
        return new Dept(
                rs.getLong("id"),
                rs.getLong("account_id"),
                rs.getString("description"),
                rs.getBigDecimal("amount"),
                rs.getString("currency"),
                rs.getDate("date_output").toLocalDate(),
                rs.getDate("date_taking").toLocalDate()
        );
    }
}