package agh.ii.prinjava.lab09.lst09_01;

import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * The Java Database Connectivity (JDBC) API is the industry standard for database-independent connectivity between
 * the Java programming language and a wide range of databases - SQL databases and other tabular data sources,
 * such as spreadsheets or flat files. The JDBC API provides a call-level API for SQL-based database access.
 *
 * <p>JDBC API is defined in {@code java.sql} and {@code javax.sql}
 *
 * <p>The key JDBC classes/interfaces:
 * <ul>
 *     <li>{@link DriverManager}</li>
 *     <li>{@link Connection}</li>
 *     <li>{@link Statement}</li>
 *     <li>{@link ResultSet}</li>
 *     <li>{@link DataSource} (for connection polling)</li>
 * </ul>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html">JDBC Basics</a>
 * @see <a href="https://www.oracle.com/pl/database/technologies/faq-jdbc.html">Frequently Asked Questions</a>
 * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/Connection.html">Connection</a>
 */
public class Main {
    private static final String dbURL = "jdbc:sqlite:lab09/datasources/lab09_sqlite.db";

    /**
     * Class {@link DriverManager} - the basic service for managing a set of JDBC drivers.
     *
     * <i>Note</i>: {@code DriverManager} initialization is done lazily and looks up service providers
     * using the thread context class loader.
     * <p>When the method {@link DriverManager#getConnection(String) getConnection} is called, the {@code DriverManager}
     * will attempt to locate a suitable driver from amongst those loaded at initialization and those loaded explicitly
     * using the same class loader as the current application.
     *
     * <p>{@link Connection} - a connection (session) with a specific database. SQL statements are executed and results
     * are returned within the context of a connection.
     *
     * <p><i>Note:</i> In previous versions of JDBC, to obtain a connection, you first had to initialize
     * the JDBC driver by calling the method {@link Class#forName}
     * Any JDBC 4.0 drivers that are found in your class path are automatically loaded.
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/java/sql/DriverManager.html">DriverManager</a>
     */
    private static void demo1() {
        System.out.println("demo1...");
        // try-with-resources: the connection (con) will be automatically close when the try block terminates
        try (Connection con = DriverManager.getConnection(dbURL)) {
            if (!con.isClosed()) {
                System.out.println("DB connection is now open");
            }
            //...
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Interface {@link DataSource} (implemented by a driver vendor) - a factory for connections to the physical
     * data source that this {@code DataSource} object represents. An alternative to the {@link DriverManager} facility,
     * a {@code DataSource} object is the preferred means of getting a connection
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.sql/javax/sql/DataSource.html">DataSource</a>
     */
    private static void demo2() {
        System.out.println("\ndemo2...");
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl(dbURL);
        try (Connection con = ds.getConnection()) {
            if (!con.isClosed()) {
                System.out.println("DB connection is now open");
            }
            //...
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }
}
