package algorithms.array;

import java.util.List;

public class BinarySearch {

  public static int search(List<Integer> numbers, int value) {
    var start = 0;
    var end = numbers.size() - 1;

    while (start < end) {
      int centralIndex = start + (end / 2);
      var centralValue = numbers.get(centralIndex);

      if (value < centralValue) {
        end = centralIndex;
      } else if (value > centralValue) {
        start = centralIndex;
      } else {
        return centralIndex;
      }
    }
    return -1;
  }

}
