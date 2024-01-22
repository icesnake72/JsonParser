package mynews;

import lombok.Getter;

import java.sql.*;

@Getter
public class DatabaseConnector {
  private String databaseUrL;
  private String user;
  private String password;

  private Connection connection;
  private Statement statement;
  private static DatabaseConnector instance = null;

  protected DatabaseConnector() {
    connection = null;
    statement = null;
  }
  public static DatabaseConnector getInstance() {
    if(instance == null) {
      instance = new DatabaseConnector();
    }
    return instance;
  }

  public void init(String databaseUrL, String user, String password) throws SQLException {
    this.databaseUrL = databaseUrL;
    this.user = user;
    this.password = password;

    connection = DriverManager.getConnection(databaseUrL, user, password);
    statement = connection.createStatement();
  }

  public void close() throws SQLException {
    if(statement != null) {
      statement.close();
      statement = null;
    }

    if(connection != null) {
      connection.close();
      connection = null;
    }
  }
}
