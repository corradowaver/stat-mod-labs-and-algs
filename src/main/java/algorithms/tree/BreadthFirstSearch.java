package algorithms.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch<T> {

  public T search(List<T> sortedList, T value) {
    BinaryTree<T> tree = new BinaryTree<>();
    Node<T> head = tree.convertListToBinaryTree(sortedList);

    Queue<Node<T>> queue = new LinkedList<>();
    queue.add(head);
    var current = queue.poll();

    while (current != null) {
      if (current.getItem().equals(value)) {
        return current.getItem();
      }
      System.out.println(current.getItem().toString());
      var left = current.getLeft();
      var right = current.getRight();
      if (left != null) queue.add(left);
      if (right != null) queue.add(right);
      current = queue.poll();
    }

    return null;
  }

}
