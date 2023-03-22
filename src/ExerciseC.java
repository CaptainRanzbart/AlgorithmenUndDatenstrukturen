package src;

public class ExerciseC {

}
class SequentialSearch{
  public static int sequentialsearch(int[] arr, int k){
    int i = 0;
    while(i < arr.length){
      if(arr[i] == k ){
        return i;
      }
      i++;
    }
    return -1;
  }

}
class BinarySearch{
  public static int binarysearch(int[] arr, int k){
    int l = 0;
    int u = arr.length -1;

    while (l <= 0) {
      int i = (l + u) / 2;
      if(arr[i] == k){
        return i;
      }else if(k < arr[i]){
        u = i - 1;
      }else {
        l = i + 1;
      }
    }
    return -1;
  }
}
class InsertionSort{
  public static int[] insertionsort(int[] arr){
    int[] f = arr;
    for(int i = 1; i < arr.length; i++){
      int temp = f[i];
      int j = i;
      while(j > 0 && f[j -1] > temp){
        f[j] = f[j - 1];
        j = j - 1;
      }
      f[j] = temp;
    }
    return f;
  }
}
class SelectionSort {
  public static int[] selectionsort(int[] arr) {
    int[] f = arr;
    for (int i = f.length - 1; i >= 0; i--) {
      int maxId = 0;
      int max = 0;
      for (int j = 0; j <= i ; j++) {
        if(f[j] > max){
          maxId = j;
          max = f[j];
        }
      }
      f[maxId] = f[i];
      f[i] = max;
    }
    return f;
  }

  class MergeSort {

  }

  class QuickSort {

  }
}