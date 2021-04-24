package algorithms.tree;

import java.util.List;

public class BinaryTree<T> {

  public Node<T> convertListToBinaryTree(List<T> sortedList) {
    return bstRecursive(sortedList, 0, sortedList.size() - 1);
  }

  private Node<T> bstRecursive(List<T> sortedList, int start, int end) {
    if (start > end) {
      return null;
    }
    var centralIndex = start + (end - start) / 2;
    var centralValue = sortedList.get(centralIndex);
    Node<T> node = new Node<>(centralValue);
    node.setLeft(bstRecursive(sortedList, start, centralIndex - 1));
    node.setRight(bstRecursive(sortedList, centralIndex + 1, end));
    return node;
  }

}
