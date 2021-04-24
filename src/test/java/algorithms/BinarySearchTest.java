package algorithms;

import algorithms.array.BinarySearch;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinarySearchTest extends TestCase {
  public BinarySearchTest() {
  }

  @Test
  void searchTest() {
    var numbers = List.of(1, 2, 3, 4, 5);
    var result = BinarySearch.search(numbers, 3);
    assertEquals(2, result);
  }
}
