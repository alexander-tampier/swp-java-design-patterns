package at.fhtw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * SingletonPattern
 *
 * lazy instantiation
 *
 * declare your singleton class final, which makes that intention explicit and allows the compiler
 * to apply performance optimizations
 */
public final class DBConnector {

  private Connection connection;

  private static DBConnector instance = null;

  private Configuration configuration = null;

  protected DBConnector() throws SQLException {
    try {
      // static singleton pattern
      this.configuration = Configuration.INSTANCE;

      final String db = configuration.getProperty("database");
      final String username = configuration.getProperty("dbuser");
      final String password = configuration.getProperty("dbpassword");

      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      this.connection = DriverManager.getConnection(db, username, password);
    } catch (ClassNotFoundException e) {
      System.out.println("Database Connection Creation Failed : " + e.getMessage());
    }
  }

  public static DBConnector getInstance() throws SQLException {
    if (instance == null) {
      instance = new DBConnector();
    } else if (instance.getConnection().isClosed()) {
      instance = new DBConnector();
    }

    return instance;
  }

  public Connection getConnection() {
    return connection;
  }

  public void endConnection() throws SQLException {
    if (connection.isClosed()) {
      connection.close();
    }
  }
}
