import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileIntoList {
  public static String[] readFileInList(String fileName) {

    String[] lines = new String[1];
    try {
      lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8).toArray(new String[0]);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }
}
