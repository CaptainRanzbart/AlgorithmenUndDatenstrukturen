package src;

import java.util.Objects;

public class ExerciseD {
  public class Node<E>{
    private E value;
    private Node<E> next;

    public Node(E value){
      setValue(value);
    }
    public E getValue(){
      return value;
    }
    public void setValue(E value){
      this.value = value;
    }
    public Node<E> getNext(){
      return next;
    }
    public void setNext(Node<E> next){
      this.next = next;
    }
    @Override
    public boolean equals(Object o){
      if(this == o)return true;
      if(!(o instanceof Node))return false;
      Node<?> node = (Node<?>) o;
      return Objects.equals(getValue(), node.getValue()) && (getNext() == node.getNext());
    }
    @Override
    public int hashCode(){
      return Objects.hash(getValue(), getNext());
    }
  }
  public class List<E>{
    private Node<E> head;
    private Node<E> last;

    public void add(E element){
      Node add = new Node<E>(element);
      if(head == null){
        head = add;
      }else{
        last = head;
        while(last.next != null){
          last = last.next;
        }
        last.next = add;
      }
    }

    public int size(){
      Node<E> current = head;
      int count = 0;
      while(current.next != null){
        count++;
        current = current.next;
      }
      return count;
    }

    public boolean isEmpty(){
      return head == null;
    }

    public Node<E> internalGet(int position){
      Node<E> current = head;
      for(int i = 0; i < position; i++){
        current = current.next;
      }
      return current;
    }

    public void clear(){
      head = null;
      last = null;
    }

    public E get(int position){
      return internalGet(position).getValue();
    }

    public E remove(int position){
      Node<E> current = head;
      Node<E> before = head.next;
      Node<E> tmp = null;
      if(position == 0){
        tmp = head;
        head = head.next;
      }
        for(int i = 0; i<position; i++){
          before = current;
          current = current.next;
        }
      tmp = current;
        if(position != size() - 1){
          current = current.next;
          before.next = current;
        }else{
          before.next = null;
          last = before;
        }
      return tmp.getValue();
    }

  }
}
