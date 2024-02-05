package mynews;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UrlUpdate {
  public static void main(String[] args) {
    String databaseUrL = "jdbc:mysql://localhost:3306/my_board?serverTimezone=Asia/Seoul";
    String user = "root";
    String password = "1234";

    DatabaseConnector connector = DatabaseConnector.getInstance();

    try {
      connector.init(databaseUrL, user, password);
      String selectSql = "select id, url, image_url from article";
      String updateSql = "update article set url = ?, image_url = ? where id = ?";

      try( PreparedStatement selectStatement = connector.getConnection().prepareStatement(selectSql);
           PreparedStatement updateStatement = connector.getConnection().prepareStatement(updateSql))
      {
        ResultSet rs = selectStatement.executeQuery();
        while (rs.next()) {
          String url = rs.getString("url");
          String urlToImage = rs.getString("image_url");
          long id = rs.getLong("id");
          if ( url != null ) {
            url = URLEncoder.encode(url, StandardCharsets.UTF_8);
          }
          if (urlToImage != null ) {
            urlToImage = URLEncoder.encode(urlToImage, StandardCharsets.UTF_8);
          }
          updateStatement.setString(1, url);
          updateStatement.setString(2, urlToImage);
          updateStatement.setLong(3, id);
          updateStatement.executeUpdate();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
