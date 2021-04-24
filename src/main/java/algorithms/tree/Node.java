package algorithms.tree;

public class Node<T> {
  private T item;
  private Node<T> left;
  private Node<T> right;

  public Node(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }

  public Node<T> getLeft() {
    return left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "Node{" +
        "item=" + item +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}
