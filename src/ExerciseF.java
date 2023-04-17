package src;

import java.util.Objects;

public class ExerciseF {
  public class T implements Comparable<T> {
    int value;
    @Override
    public int compareTo(T t) {
      if(this.value > t.value){
        return 1;
      }else if(this.value < t.value){
        return -1;
      }
      return 0;
    }
  }
  public static void main(String[] args){
    Tree<String> tree = Tree.getSampleTree();
    traverseLevelorder(tree);
  }
  public void traverseInorder(Tree tree){
    if(tree != null) {
      traverseInorder(tree.left);
      System.out.print(" --> " + tree.value);
      traverseInorder(tree.right);
    }
  }
  public void traversePreorder(Tree tree){
    if(tree != null) {
      System.out.print(" --> " + tree.value);
      traversePreorder(tree.left);
      traversePreorder(tree.right);
    }
  }
  public void traversePostorder(Tree tree){
    if(tree != null){
      traversePostorder(tree.left);
      traversePostorder(tree.right);
      System.out.print(" --> " + tree.value);
    }
  }
  //Traverse Levelorder -----------------------------------------------------------------------
  public static void traverseLevelorder(Tree tree){
    int h = height(tree);
    for(int i = 1; i <= h; i++){
      printCurrentLevel(tree, i);
    }
  }
  public static int height(Tree<T> tree){
    if(tree == null){
      return 0;
    }else{
      int lheight = height(tree.left);
      int rheight = height(tree.right);

      return lheight > rheight ? lheight + 1 : rheight + 1;
    }
  }
  public static void printCurrentLevel(Tree<T> tree, int level){
    if(tree == null){
      return;
    }
    if(level == 1){
      System.out.print(" --> " + tree.value);
    } else if (level > 1) {
      printCurrentLevel(tree.left, level - 1);
      printCurrentLevel(tree.right, level - 1);
    }
  }
  //-------------------------------------------------------------------------------------------
  public static T findBiggest(Tree<T> tree){
    if(tree.getValue().compareTo(findBiggest(tree.left)) == 1 &&
        tree.getValue().compareTo(findBiggest(tree.right)) == 1){
      return tree.value;
    }else if(findBiggest(tree.left).compareTo(findBiggest(tree.right)) == 1){
      return findBiggest(tree.left);
    }else{
      return findBiggest(tree.right);
    }
  }
  public static T findSmallest(Tree<T> tree){
    if(tree.getValue().compareTo(findBiggest(tree.left)) == -1 &&
        tree.getValue().compareTo(findBiggest(tree.right)) == -1){
      return tree.value;
    }else if(findBiggest(tree.left).compareTo(findBiggest(tree.right)) == -1){
      return findBiggest(tree.left);
    }else{
      return findBiggest(tree.right);
    }
  }
  public static class Tree<T>{
    public static Tree<String> getSampleTree(){
      Tree<String> main = new Tree<String>();
      main.setValue("A");

      Tree<String> left = new Tree<String>();
      left.setValue("B");
      Tree<String> ll = new Tree<String>();
      ll.setValue("D");
      Tree<String>lr = new Tree<String>();
      lr.setValue("E");
      left.setleft(ll);
      left.setRight(lr);
      main.setleft(left);

      Tree<String> right = new Tree<String>();
      right.setValue("C");
      Tree<String> rl = new Tree<String>();
      rl.setValue("F");
      Tree<String>rr = new Tree<String>();
      rr.setValue("G");
      right.setleft(rl);
      right.setRight(rr);
      main.setRight(right);

      return main;
    }

    public T value;

    public T getValue(){
      return value;
    }
    public Tree<T> setValue(T value){
      this.value = value;
      return this;
    }
    public Tree<T> left;
    public Tree<T> right;

    public boolean isLeaf(){
      return left == null && right == null;
    }

    public boolean isEmpty(){
      return value == null;
    }

    public Tree<T> getLeft(){
      return left;
    }

    public Tree<T> getRight(){
      return right;
    }

    public Tree<T> setleft(Tree<T> left){
      this.left = left;
      return this;
    }

    public Tree<T> setRight(Tree<T> right){
      this.right = right;
      return this;
    }

    public int size(){
      int size = 1;
      if(left != null) size += left.size();
      if(right != null) size += right.size();
      return size;
    }

  }
}
