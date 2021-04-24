package algorithms.tree;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest extends TestCase {

  @Test
  void search() {
    var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>();
    System.out.println(bfs.search(list, 7));
  }
}
