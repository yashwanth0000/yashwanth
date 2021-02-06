public class GoodiesPicker {
  private Goodie[] sortedGoodieList;

  private int minDifference;

  public GoodiesPicker(Goodie[] goodieList) {
    if (goodieList != null) {
      QuickSort quickSort = new QuickSort();
      quickSort.sort(goodieList, 0, goodieList.length-1);
      this.sortedGoodieList = goodieList;
    }
  }

  public Goodie[] getGoodiesForEmployees(int noOfEmployees) {
    Goodie[] goodieList = sortedGoodieList;
    minDifference = Integer.MAX_VALUE;

    int startIndex = 0;
    int endIndex = 0;
    int size = sortedGoodieList.length;
    // Find minimum value among
    // all K size subarray.
    for (int i = 0; i <= size - noOfEmployees; i++) {
      int diff = sortedGoodieList[i + noOfEmployees - 1].getPrice() - sortedGoodieList[i].getPrice();
      if (diff < minDifference) {
        minDifference = diff;
        endIndex = i + noOfEmployees - 1;
        startIndex = i;

      }
    }

    return GoodiesUtils.subList(sortedGoodieList,startIndex,endIndex);
  }

  public int getMinDifference() {
    return minDifference;
  }
}
