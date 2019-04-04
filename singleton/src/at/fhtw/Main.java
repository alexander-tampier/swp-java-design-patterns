package at.fhtw;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    try {
      Connection con = DBConnector.getInstance()
          .getConnection();

      ArrayList<String> listofTable = new ArrayList<String>();

      DatabaseMetaData md = con.getMetaData();

      ResultSet rs = md.getTables(null, null, "%", null);

      while (rs.next()) {
        if (rs.getString(4).equalsIgnoreCase("TABLE")) {
          listofTable.add(rs.getString(3));
        }
      }

      listofTable.forEach(System.out::println);

      con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
