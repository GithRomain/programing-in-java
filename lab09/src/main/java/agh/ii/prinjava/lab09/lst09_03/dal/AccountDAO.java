package agh.ii.prinjava.lab09.lst09_03.dal;

import agh.ii.prinjava.lab09.lst09_03.model.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class AccountDAO {
    private static final String selectByIDSQL = "SELECT * FROM accounts WHERE id = ?";
    private static final String updateSQL = "UPDATE accounts SET balance = ? WHERE id = ?";

    public Optional<Account> findByID(int id) {
        try (var con = DBConnectionManager.instance().autoCommitConnection();
             var stmt = con.prepareStatement(selectByIDSQL)) {
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                var amount = rs.getInt(2);
                var account = new Account(id, amount);
                return Optional.of(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Optional<Account> findByID(Connection con, int id) {
        try (var stmt = con.prepareStatement(selectByIDSQL)) {
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                var amount = rs.getInt(2);
                var account = new Account(id, amount);
                return Optional.of(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void updateAccount(Connection con, Account account) {
        try (var stmt = con.prepareStatement(updateSQL)) {
            stmt.setInt(1, account.balance());
            stmt.setInt(2, account.id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
