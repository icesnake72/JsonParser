package mynews;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Setter
@Getter
@Data
public class Article
{
  private String publishedAt;

  private String author;

  private String urlToImage;

  private String description;

  private Source source;

  private String title;

  private String url;

  private String content;

  public String toString() {
    return String.format("Source : %s\n" +
        "Author : %s\n" +
        "Title : %s\n" +
        "Desc. : %s\n" +
        "url : %s\n" +
        "url to image : %s\n" +
        "Published At : %s", source.getName(), author, title, description, urlEncode(url), urlEncode(urlToImage), publishedAt);
  }

  public String urlEncode(String url) {
    return URLEncoder.encode(url, StandardCharsets.UTF_8);
  }
}
	