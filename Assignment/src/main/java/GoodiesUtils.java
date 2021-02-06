import java.io.FileWriter;
import java.io.PrintWriter;

public class GoodiesUtils {
  public static Goodie[] readGoodies(String[] strings) {
    int n = strings.length;
    Goodie[] goodieList = new Goodie[n];
    
    for (int i = 0; i < n; i++) {
      String s = strings[i];
      try {
        String[] split = s.split(":");

        String name = split[0];
        String priceString = split[1];
        int price = Integer.valueOf(priceString.trim());

        Goodie g = new Goodie(name, price);

        goodieList[i] = g;
      } catch (Exception e) {
        //        do nothing
      }
    }

    return goodieList;
  }

  public static int getNoOfEmployees(String sampleInput) {
    int noOfEmployees = 0;

    try {
      String[] split = sampleInput.split(":");
      String fieldString = split[1];
      noOfEmployees = Integer.valueOf(fieldString.trim());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return noOfEmployees;
  }

  public static void writeOutputToFile(Goodie[] goodiesForEmployees, int minDiff) {
    String outputFile = "data/my_output.txt";

    try {
      FileWriter fw = new FileWriter(outputFile);

      PrintWriter printWriter = new PrintWriter(fw);

      printWriter.println("The goodies selected for distribution are:");
      printWriter.println("");

      for (Goodie g : goodiesForEmployees) {
        printWriter.println(g.getName() + ": " + g.getPrice());
      }

      printWriter.println("");

      printWriter.println(
          "And the difference between the chosen goodie with highest price and the lowest price is "
              + minDiff);
      printWriter.close();
      fw.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static Goodie[] subList(Goodie[] arr, int beg, int end) {

    Goodie[] subarray = new Goodie[end - beg + 1];
    for (int i = 0; i < subarray.length; i++) {
      subarray[i] = arr[beg + i];
    }

    return subarray;
  }
}
