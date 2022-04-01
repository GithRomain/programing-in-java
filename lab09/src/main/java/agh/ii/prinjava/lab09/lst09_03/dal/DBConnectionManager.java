package agh.ii.prinjava.lab09.lst09_03.dal;

import agh.ii.prinjava.lab09.lst09_03.exceptions.GetConnectionFailure;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private static final String dbURL = "jdbc:sqlite:lab09/datasources/lab09_sqlite.db";

    private DBConnectionManager() {
    }

    public static DBConnectionManager instance() {
        return SingletonHolder.INSTANCE;
    }

    public Connection getConnection1() {
        try {
            return DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            throw new GetConnectionFailure();
        }
    }

    /**
     * When configuring a {@code Connection}, JDBC applications should use the appropriate
     * {@code Connection} method such as {@link Connection#setAutoCommit setAutoCommit} or
     * {@link Connection#setTransactionIsolation setTransactionIsolation}.
     *
     * <p>By default, a {@code Connection} object is in <em>auto-commit mode</em>, which means that it automatically
     * commits changes after executing each statement.
     * <p>If <em>auto-commit mode</em> has been disabled, the method commit must be called explicitly
     * in order to commit changes; otherwise, database changes will not be saved
     */
    public Connection noAutoCommitConnection() {
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl(dbURL);
        try {
            var con = ds.getConnection();
            con.setAutoCommit(false);
            return con;
        } catch (SQLException e) {
            throw new GetConnectionFailure();
        }
    }

    public Connection autoCommitConnection() {
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl(dbURL);
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new GetConnectionFailure();
        }
    }

    private static final class SingletonHolder {
        private static final DBConnectionManager INSTANCE = new DBConnectionManager();
    }
}
