package mynews;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class MyNews {
  private String totalResults;

  private Articles[] articles;

  private String status;
//
//  public String getTotalResults ()
//  {
//    return totalResults;
//  }
//
//  public void setTotalResults (String totalResults)
//  {
//    this.totalResults = totalResults;
//  }
//
//  public Articles[] getArticles ()
//  {
//    return articles;
//  }
//
//  public void setArticles (Articles[] articles)
//  {
//    this.articles = articles;
//  }
//
//  public String getStatus ()
//  {
//    return status;
//  }
//
//  public void setStatus (String status)
//  {
//    this.status = status;
//  }
//
//  @Override
//  public String toString()
//  {
//    return "ClassPojo [totalResults = "+totalResults+", articles = "+articles+", status = "+status+"]";
//  }
}
