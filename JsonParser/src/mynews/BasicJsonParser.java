package mynews;

import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BasicJsonParser {

  @Getter
  private final StringBuilder builder = new StringBuilder();

  public void load(String fileName) throws FileNotFoundException {
    try (FileReader reader = new FileReader(fileName)) {
      char [] buffer = new char[1024];
      int readCount = 0;
      while((readCount = reader.read(buffer)) != -1) {
        builder.append(buffer, 0, readCount);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

//    System.out.println(builder.toString());
  }
}
