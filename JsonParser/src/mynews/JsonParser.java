package mynews;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

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

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    NewsJsonParser parser = new NewsJsonParser();
    try {
//      parser.load("src/mynews/news.json");
      Gson gson = new Gson();
      MyKey newsKey = gson.fromJson(new java.io.FileReader("src/mynews/keys.json"), MyKey.class);
      System.out.println(newsKey);

//      String uri = "https://newsapi.org/v2/top-headlines?country=kr&apiKey=" + newsKey.News();
//      parser.loadFromUrl(uri);
//
//      parser.showAllArticles();
//
//      String databaseUrL = "jdbc:mysql://localhost:3306/mynews?serverTimezone=UTC";
//      String user = "root";
//      String password = "1234";
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


    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}