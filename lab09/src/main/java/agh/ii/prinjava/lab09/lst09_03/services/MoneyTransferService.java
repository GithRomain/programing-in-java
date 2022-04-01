package agh.ii.prinjava.lab09.lst09_03.services;

import agh.ii.prinjava.lab09.lst09_03.dal.AccountDAO;
import agh.ii.prinjava.lab09.lst09_03.dal.DBConnectionManager;
import agh.ii.prinjava.lab09.lst09_03.exceptions.NoSuchAccountException;
import agh.ii.prinjava.lab09.lst09_03.model.Account;

import java.sql.Connection;

/**
 * DB transactions demo
 *
 * @see <a href="https://www.geeksforgeeks.org/acid-properties-in-dbms/">ACID Properties in DBMS</a>
 */
public class MoneyTransferService {
    private final AccountDAO accountDAO = new AccountDAO();

    /**
     * Non-transactional two-step operation
     * <p>The JDBC driver creates one transaction per each operation which here leads to DB inconsistency
     */
    public void brokenMoneyTransfer(int fromAccId, int toAccId, int amount) {
        System.out.println("brokenMoneyTransfer, before the transfer of " + amount);
        printBalancesOf(fromAccId, toAccId);

        try (var con = DBConnectionManager.instance().autoCommitConnection()) {
            transferMoneyHelper(fromAccId, toAccId, amount, con, true);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("brokenMoneyTransfer, after the transfer of " + amount);
        printBalancesOf(fromAccId, toAccId);
    }

    /**
     * Transactional two-step operation (rolled back)
     *
     * @see <a href="https://www.geeksforgeeks.org/acid-properties-in-dbms/">ACID Properties in DBMS</a>
     */
    public void unsuccessfulMoneyTransfer(int fromAccId, int toAccId, int amount) {
        System.out.println("unsuccessfulMoneyTransfer, before the transfer of " + amount);
        printBalancesOf(fromAccId, toAccId);

        try (var con = DBConnectionManager.instance().noAutoCommitConnection()) {
            // start transaction
            transferMoneyHelper(fromAccId, toAccId, amount, con, true);
            con.commit(); // commit transaction (as "con" is Autocloseable it will roll back the transaction)
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("unsuccessfulMoneyTransfer, after the transfer of " + amount);
        printBalancesOf(fromAccId, toAccId);
    }

    /**
     * Transactional two-step operation (committed)
     *
     * @see <a href="https://www.geeksforgeeks.org/acid-properties-in-dbms/">ACID Properties in DBMS</a>
     */
    public void successfulMoneyTransfer(int fromAccId, int toAccId, int amount) {
        System.out.println("successfulMoneyTransfer, before the transfer of " + amount);
        printBalancesOf(fromAccId, toAccId);

        try (var con = DBConnectionManager.instance().noAutoCommitConnection()) {
            // start transaction
            transferMoneyHelper(fromAccId, toAccId, amount, con, false);
            con.commit(); // commit transaction
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // as "con" is Autocloseable it will roll back the transaction

        System.out.println("successfulMoneyTransfer, after the transfer of " + amount);
        printBalancesOf(fromAccId, toAccId);
    }

    /**
     * Auxiliary (helper) method 1
     */
    private void transferMoneyHelper(int fromAccId, int toAccId, int amount, Connection con, boolean shouldBrake) {
        Account fromAccount = accountDAO.findByID(con, fromAccId).orElseThrow(NoSuchAccountException::new);
        Account toAccount = accountDAO.findByID(con, toAccId).orElseThrow(NoSuchAccountException::new);

        // The following operations forms a transaction (they should be atomic)
        fromAccount.setBalance(fromAccount.balance() - amount);
        toAccount.setBalance(toAccount.balance() + amount);

        // Two-step (atomic) operation:
        // 1) Updating fromAccount balance
        accountDAO.updateAccount(con, fromAccount);

        // Here we simulate a system failure by throwing RuntimeException
        if (shouldBrake) throw new RuntimeException("Money transfer failure!");

        // 2) Updating toAccount balance
        accountDAO.updateAccount(con, toAccount);
    }

    /**
     * Auxiliary (helper) method 2
     */
    private void printBalancesOf(int acc1Id, int acc2Id) {
        accountDAO.findByID(acc1Id).ifPresent(a -> System.out.println("account " + a.id() + ": " + a.balance()));
        accountDAO.findByID(acc2Id).ifPresent(a -> System.out.println("account " + a.id() + ": " + a.balance()));
    }
}

