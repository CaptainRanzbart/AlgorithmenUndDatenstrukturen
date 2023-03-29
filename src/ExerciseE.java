package src;

public class ExerciseE {
   public class Stack {
     private int[] elements;
     private int top = 0;

     public Stack(int capacity) {
         elements = new int[capacity];
     }

     public int push(int data) {
       if(top == elements.length){
         throw new StackException();
       }
         elements[top] = data;
         top++;
         return data;
       }

     public int pop() {
       if(top != 0) {
         top--;
         return elements[top];
       }
       throw new StackException();
     }

     public int peek() {
         return elements[top - 1];
     }

     public boolean isEmpty() {
         return top == 0;
     }

     public int count() {
       return top;
     }

     public int getCapacity() {
         return elements.length;
       }
 }
 public class StackException extends RuntimeException{
     public StackException(){
       System.out.println("There has been an Error with the Stack!");
     }
     public StackException(String message){
       System.out.println("Stack Error: " + message);
     }
     public StackException(String message, Throwable cause) throws Throwable {
       System.out.println("Stack Error:  " + message);
       throw cause;
     }
 }
  public class Queue {
    private int[] elements;
    private int first = 1;
    private int count = 0;

    public Queue(int capacity) {
      elements = new int[capacity];
    }

    public int add(int data) {
      if(count != getCapacity()) {
        elements[(count + first) % elements.length] = data;
        count++;
        return data;
      }
      throw new QueueException();
    }

    public int remove() {
      if(isEmpty()) {
        count--;
        first++;
        return elements[(first - 1) % elements.length];
      }
      throw new QueueException();
    }

    public int element() {
      return elements[(first)%elements.length];
    }

    public int getCapacity() {
      return elements.length;
    }

    public int size() {
      return count;
    }

    public boolean isEmpty() {
      return first == count;
    }
  }
  public class QueueException extends RuntimeException{
     public QueueException(){
       System.out.println("Queue Error!");
     }
     public QueueException(String message){
       System.out.println("Queue Error: " + message);
     }
     public QueueException(String message, Throwable cause) throws Throwable {
       System.out.println("Queue Error: " + message);
       throw cause;
     }
  }
}
