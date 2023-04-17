package src;

import java.util.concurrent.ArrayBlockingQueue;

public class ExerciseF4 {
  public abstract class AbstractBinaryTree<K extends Comparable<K>, V> {

    private Pair<K, V> value;
    private AbstractBinaryTree<K, V> left;
    private AbstractBinaryTree<K, V> right;

    public AbstractBinaryTree() {

    }

    public AbstractBinaryTree(K key, V value) {
      this(new Pair<>(key, value));
    }

    public AbstractBinaryTree(Pair<K, V> value) {
      setValue(value);
    }

    public abstract AbstractBinaryTree<K, V> insert(K key, V value) throws Exception;

    public abstract AbstractBinaryTree<K, V> remove(K key);

    public boolean isEmpty() {
      return null == getLeft() &&
          null == getRight() &&
          null == getValue();
    }

    public boolean isLeaf() {
      return null == getLeft() &&
          null == getRight() &&
          null != getValue();
    }

    public Pair<K, V> getValue() {
      return value;
    }

    AbstractBinaryTree<K, V> setValue(Pair<K, V> value) {
      this.value = value;
      return this;
    }

    AbstractBinaryTree<K, V> setValue(K key, V value) {
      return setValue(new Pair<>(key, value));
    }

    public AbstractBinaryTree<K, V> getLeft() {
      return left;
    }

    AbstractBinaryTree<K, V> setLeft(AbstractBinaryTree<K, V> left) {
      this.left = left;
      return this;
    }

    public AbstractBinaryTree<K, V> getRight() {
      return right;
    }

    AbstractBinaryTree<K, V> setRight(AbstractBinaryTree<K, V> right) {
      this.right = right;
      return this;
    }

    public int size() {
      if (isEmpty()) {
        return 0;
      }

      int left = null == getLeft() ? 0 : getLeft().size();
      int right = null == getRight() ? 0 : getRight().size();

      return left + 1 + right;
    }

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("AbstractBinaryTree {size = ")
          .append(size())
          .append("}: ");
      boolean first = true;

      ArrayBlockingQueue<AbstractBinaryTree<K, V>> queue = new ArrayBlockingQueue<>(
          size()
      );

      if (!isEmpty()) {
        queue.add(this);

        while (!queue.isEmpty()) {
          AbstractBinaryTree<K, V> current = queue.remove();

          stringBuilder.append(
              first ? current.getValue().getKey().toString() : " -> " + current.getValue
                  ().getKey().toString()
          );
          first = false;

          if (null != current.getLeft()) {
            queue.add(current.getLeft());
          }
          if (null != current.getRight()) {
            queue.add(current.getRight());
          }
        }
      }

      return stringBuilder.toString();
    }

    protected AbstractBinaryTree<K, V> findNode(K key) {
      if (null == key || isEmpty()) {
        return null;
      }

      if (0 == key.compareTo(getValue().getKey())) {
        return this;
      } else if (0 > key.compareTo(getValue().getKey())) {
        return getLeft().findNode(key);
      } else if (0 < key.compareTo(getValue().getKey())) {
        return getRight().findNode(key);
      }

      return null;
    }

    protected AbstractBinaryTree<K, V> findParent(K key) {
      if (null == key) {
        throw new IllegalArgumentException();
      }

      if (0 == key.compareTo(getValue().getKey())) {
        // no parent, its the root of the (entire / sub-) tree
        return null;
      } else if (0 > key.compareTo(getValue().getKey())) {
        if (0 == key.compareTo(getLeft().getValue().getKey())) {
          return this;
        } else {
          return getLeft().findParent(key);
        }
      } else if (0 < key.compareTo(getValue().getKey())) {
        if (0 == key.compareTo(getRight().getValue().getKey())) {
          return this;
        } else {
          return getRight().findParent(key);
        }
      }

      return null;
    }

    protected AbstractBinaryTree<K, V> getMinKey() {
      AbstractBinaryTree<K, V> current = this;

      while (current != null && current.getLeft() != null) {
        current = current.getLeft();
      }

      return current;
    }

    protected boolean isLeft(K key) {
      return null != getLeft() &&
          0 == key.compareTo(getLeft().getValue().getKey());
    }

    protected boolean isRight(K key) {
      return null != getRight() &&
          0 == key.compareTo(getRight().getValue().getKey());
    }

    public static class Pair<K extends Comparable<K>, V> {
      private K key;
      private V value;

      public Pair(K key, V value) {
        this.key = key;
        this.value = value;
      }

      public K getKey() {
        return key;
      }

      public Pair<K, V> setKey(K key) {
        this.key = key;
        return this;
      }

      public V getValue() {
        return this.value;
      }

      public Pair<K, V> setValue(V value) {
        this.value = value;
        return this;
      }
    }
  }

  public class BinaryTree extends ExerciseF4.AbstractBinaryTree {

    public BinaryTree(Comparable key, Object value) {
      super(key, value);
    }

    @Override
    public ExerciseF4.AbstractBinaryTree insert(Comparable key, Object value) throws Exception {
      if (isEmpty()) {
        this.setValue(key, value);
      } else {
        BinaryTree parent = null;
        BinaryTree current = this;
        while (current != null) {
          parent = current;
          if (key.compareTo(current.getValue().getKey()) == 0) {
            throw new Exception("Exception thrown!");
          } else if (key.compareTo(current.getValue().getKey()) == -1) {
            current = (BinaryTree) current.getLeft();
          } else if (key.compareTo(current.getValue().getKey()) == 1) {
            current = (BinaryTree) current.getRight();
          }
        }
        BinaryTree newNode = new BinaryTree(key, value);
        if (key.compareTo(parent.getValue().getKey()) == -1) {
          parent.setLeft(newNode);
        } else {
          parent.setRight(newNode);
        }
      }
      return this;
    }

    @Override
    public ExerciseF4.AbstractBinaryTree remove(Comparable key) {
      return null;
    }
  }
}


