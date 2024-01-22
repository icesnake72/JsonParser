package mynews;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class MyNews {
  private String totalResults;

  private Article[] articles;

  private String status;
}
