package mynews;


import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class NewsJsonParser extends BasicJsonParser {

  private Optional<MyNews> byMyNews = Optional.empty();

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
    byMyNews = Optional.empty();

    Gson gson = new Gson();
    MyNews myNews = gson.fromJson(s, MyNews.class);
    byMyNews = Optional.of(myNews);

    System.out.println("뉴스 데이터를 파싱했습니다.");
    System.out.println("=====================================");
  }

  @Override
  public void load(String fileName) throws FileNotFoundException {
    super.load(fileName);

    String json = getBuilder().toString();

    Gson gson = new Gson();
    MyNews myNews = gson.fromJson(json, MyNews.class);
    byMyNews = Optional.of(myNews);
  }

  public void showAllArticles() {
    byMyNews.ifPresentOrElse(
        myNews -> {
          for (Articles article : myNews.getArticles()) {

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
        },
        () -> System.out.println("뉴스 데이터가 없습니다.")
    );
  }
}
