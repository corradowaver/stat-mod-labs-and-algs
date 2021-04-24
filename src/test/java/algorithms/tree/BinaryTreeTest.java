package algorithms.tree;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.List;

class BinaryTreeTest extends TestCase {

  @Test
  void convertListToBinaryTree() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>();
    var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    Node<Integer> head = binaryTree.convertListToBinaryTree(list);
  }


}
