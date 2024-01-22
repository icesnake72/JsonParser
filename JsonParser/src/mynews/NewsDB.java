package mynews;

import java.sql.ResultSet;

public class NewsDB {
  DatabaseConnector dbConnector;
  public NewsDB(DatabaseConnector dbConnector) {
    this.dbConnector = dbConnector;
  }

  public long querySource(String sourceName) {
    String sql = String.format("select * from source where name = '%s';", sourceName);
    try(ResultSet rs = dbConnector.getStatement().executeQuery(sql)) {
      if (rs.next()) {
        return rs.getLong("id");
      }

      sql = String.format("insert into source (name) values ('%s');", sourceName);
      if (dbConnector.getStatement().executeUpdate(sql) == 0)
        return 0;

      sql = String.format("select * from source where name = '%s';", sourceName);
      try(ResultSet rs2 = dbConnector.getStatement().executeQuery(sql)) {
        if (rs2.next()) {
          return rs2.getLong("id");
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }

  public long queryCountryId(String countryCode) {
    String sql = String.format("select * from country where c_code = '%s';", countryCode);
    try(ResultSet rs = dbConnector.getStatement().executeQuery(sql)) {
      if (rs.next()) {
        return rs.getLong("id");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }

  public long queryCategoryId(String category) {
    String sql = String.format("select * from category where name = '%s';", category);
    try(ResultSet rs = dbConnector.getStatement().executeQuery(sql)) {
      if (rs.next()) {
        return rs.getLong("id");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }
}
