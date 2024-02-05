package mynews;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JsonParser {
  public static void main(String[] args) {
//    Gson gson = new Gson();
//    try {
//      MyNews myNews = gson.fromJson(new java.io.FileReader("src/mynews/news.json"), MyNews.class);
//
//      for (Articles article : myNews.getArticles()) {
//
//        System.out.println("Title : " + article.getTitle());
//        System.out.println(article.getAuthor());
//        System.out.println(article.getDescription());
//        System.out.println(article.getPublishedAt());
//        System.out.println(article.getSource().getName());
//
//        System.out.println(article.getUrl());
//        System.out.println(article.getUrlToImage());
//        System.out.println();
//        System.out.println();
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }

//    Class<String> str = String.class;
//    System.out.println(str.getName());
//    System.out.println(str.getSimpleName());
//    System.out.println(str.toString());
//    System.out.println(str.descriptorString());
//    System.out.println(str.getPackageName());
//    System.out.println(str.getModule().getName());
//    System.out.println(str.getModule().getDescriptor());
//    System.out.println(str.isInterface());
//    System.out.println(str.isPrimitive());
//    System.out.println(str.isArray());
//    System.out.println(str.isRecord());
//    System.out.println(str.getSuperclass().getName());
//    try {
//      System.out.println(str.getConstructor());
//    } catch (NoSuchMethodException e) {
//      throw new RuntimeException(e);
//    }

    String databaseUrL = "jdbc:mysql://localhost:3306/my_board?serverTimezone=Asia/Seoul";
    String user = "root";
    String password = "1234";
    DatabaseConnector connector = DatabaseConnector.getInstance();


    try {
      connector.init(databaseUrL, user, password);

      NewsJsonParser parser = new NewsJsonParser();
//      parser.load("src/mynews/news.json");
      Gson gson = new Gson();
      NewsConfig config = gson.fromJson(new java.io.FileReader("src/mynews/news_config.json"), NewsConfig.class);
      System.out.println(config);

      String uri = String.format("https://newsapi.org/v2/top-headlines?country=%s&category=%s&apiKey=%s", config.country(), config.category(), config.key());
      parser.loadFromUrl(uri);
      // parser.showAllArticles();

      NewsDB newsDB = new NewsDB(connector);
      long countryId = newsDB.queryCountryId(config.country());
      long categoryId = newsDB.queryCategoryId(config.category());

      for(Article article : parser.getMyNews().getArticles()) {
        long sourceId = newsDB.querySource(article.getSource().getName());
        if(sourceId == 0)
          continue;

        System.out.println( article );
        String sql = String.format("insert into my_board.article (author, title, description, url, image_url, published_at, category_id, country_id, source_id) " +
                "values ('%s', '%s', '%s', '%s', '%s', STR_TO_DATE('%s', '%%Y-%%m-%%dT%%H:%%i:%%sZ'), %d, %d, %d);",
            Optional.ofNullable(article.getAuthor()).orElse("").replace("'", "\\'"),
            Optional.ofNullable(article.getTitle()).orElse("").replace("'", "\\'"),
            Optional.ofNullable(article.getDescription()).orElse("").replace("'", "\\'"),
            URLEncoder.encode(article.getUrl(), StandardCharsets.UTF_8),
            URLEncoder.encode(article.getUrlToImage(), StandardCharsets.UTF_8),
            article.getPublishedAt(),
            categoryId,
            countryId,
            sourceId);

        System.out.println( sql );

        if(connector.getStatement().executeUpdate(sql) == 0)
          System.out.println("데이터를 삽입하지 못했습니다.");
      }


//
//      connection = java.sql.DriverManager.getConnection(databaseUrL, user, password);
//      statement = connection.createStatement();
//      String sql = "insert into mynews.news (title, author, description, publishedAt, source, url, urlToImage) values ('"
//          + parser.getMyNews().getArticles().get(0).getTitle()
//          + "', '" + parser.getMyNews().getArticles().get(0).getAuthor()
//          + "', '" + parser.getMyNews().getArticles().get(0).getDescription()
//          + "', '" + parser.getMyNews().getArticles().get(0).getPublishedAt()
//          + "', '" + parser.getMyNews().getArticles().get(0).getSource().getName()
//          + "', '" + parser.getMyNews().getArticles().get(0).getUrl()
//          + "', '" + parser.getMyNews().getArticles().get(0).getUrlToImage() + "');";
//
//
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
      //parser.showAllArticles();

//    // 아래와 같이 Scanner를 사용하여 사용자로부터 어떤 정수를 입력받습니다.
//    Scanner scanner = new Scanner(System.in);
//    int num = scanner.nextInt();
//    scanner.close();

      // 1. 1부터 입력받은 정수까지의 합을 구하는 프로그램을 작성하세요.
      // 2. 1부터 입력받은 정수까지의 홀수의 합을 구하는 프로그램을 작성하세요.
      // 3. 1부터 입력받은 정수까지의 짝수의 합을 구하는 프로그램을 작성하세요.
      // 4. 1부터 입력받은 정수까지의 3의 배수의 합을 구하는 프로그램을 작성하세요.


    } catch (SQLException | FileNotFoundException e) {
      System.out.println( e.getMessage() );
    } finally {
      try {
        connector.close();
      } catch (SQLException e) {
        System.out.println( e.getMessage() );
      }
    }
  }
}