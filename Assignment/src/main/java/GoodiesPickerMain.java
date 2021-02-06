public class GoodiesPickerMain {
  public static void main(String[] args) {
    System.out.println("Program started");

    String filename = "data/sample_input.txt";
    String[] stringList = ReadFileIntoList.readFileInList(filename);

    //    as per sample_input.txt file
    //    No of employee info at first line
    int noOfEmplyoyees = GoodiesUtils.getNoOfEmployees(stringList[0]);

    //    Goodies and price info starts at 5th line
    Goodie[] goodieList = GoodiesUtils.readGoodies(subList(stringList, 4, stringList.length-1));

    GoodiesPicker goodiesPicker = new GoodiesPicker(goodieList);

    Goodie[] goodiesForEmployees = goodiesPicker.getGoodiesForEmployees(noOfEmplyoyees);

    GoodiesUtils.writeOutputToFile(goodiesForEmployees, goodiesPicker.getMinDifference());

    System.out.println("Program Ended");
  }

  public static String[] subList(String[] arr, int beg, int end) {

    String[] subarray = new String[end - beg + 1];
    for (int i = 0; i < subarray.length; i++) {
      subarray[i] = arr[beg + i];
    }

    return subarray;
  }
}
