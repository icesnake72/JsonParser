package mynews;


import com.google.gson.Gson;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Getter
public class NewsJsonParser extends BasicJsonParser {

  private MyNews myNews;

  public void loadFromUrl(String url) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();

    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(this::parse)
        .join();

    System.out.println(url + " 의 뉴스를 요청했습니다.");
    System.out.println("=====================================");
  }

  private void parse(String s) {
    Gson gson = new Gson();
    myNews = gson.fromJson(s, MyNews.class);
    System.out.println("뉴스 데이터를 파싱했습니다.");
    System.out.println("=====================================");
  }

  @Override
  public void loadFromFile(String fileName) throws IOException, FileNotFoundException {
    super.loadFromFile(fileName);

    String json = getBuilder().toString();

    Gson gson = new Gson();
    myNews = gson.fromJson(json, MyNews.class);
  }

  public void showAllArticles() {
    for (Article article : myNews.getArticles()) {
      System.out.println("Title : " + article.getTitle());
      System.out.println(article.getAuthor());
      System.out.println(article.getDescription());
      System.out.println(article.getPublishedAt());
      System.out.println(article.getSource().getName());

      System.out.println(article.getUrl());
      System.out.println(article.getUrlToImage());
      System.out.println();
      System.out.println();
    }
  }
}
