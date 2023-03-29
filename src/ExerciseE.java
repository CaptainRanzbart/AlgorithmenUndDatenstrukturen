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
          top--;
          return elements[top];
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
}
