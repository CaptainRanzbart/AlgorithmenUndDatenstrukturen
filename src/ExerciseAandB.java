package src;

public class ExerciseAandB {
  public static void main(String[] args){
//    System.out.println("Biggest Number is " + findbiggestnumber(4, 6, 9));
//    System.out.println("Is 73 a prime Number: " + sieveoferasthostenes(73));
//    System.out.println("Factorial of 10: " + factorial(10));
//    System.out.println("Squareroot of 123: " + sqrt(123, 8));
    towersofhanoi(6, 1, 2, 3);
  }
  //Größte Nummer aus 3 finden------------------------------------------------------
  public static int findbiggestnumber(int a, int b, int c){
    var biggest = 0;
    if(a > b){
      if(a > c){
        biggest = a;
      }else{
        biggest = c;
      }
    }else{
      if(b > c){
        biggest = b;
      }else{
        biggest = c;
      }
    }
    return biggest;
  };
  //Bestimmen ob Primzahl oder nicht----------------------------------------------------
  public static boolean sieveoferasthostenes(int l) {
    boolean result = false;
    if (l <= 3) {
      return l > 1;
    }
    if (l % 2 == 0 || l % 3 == 0) {
      return false;
    }
    int i = 5;
    result = true;
    while (i * i <= l && result) {
      if(l % i == 0 || l%(i+2) == 0 ){
        result = false;
      }
      i = i + 6;
    }
    return result;
  };
  //Fakultät berechnen-----------------------------------------------------------------
  public static long factorial(long x){
    if(x < 0){
      return -1;
    }
    if(x == 0){
      return 1;
    }
    return x * factorial(x - 1);
  };
  //Wurzel ziehen---------------------------------------------------------------------
  public static double sqrt(double in, int precision){
    double out = 0;
    double temp1 = in / 2;
    double temp2 = 0;
    while(roundtoxdigits(temp1, precision) != roundtoxdigits(temp2, precision)){
      temp2 = in / temp1;
      temp1 = (temp1 + temp2)/2;
    }
    return roundtoxdigits(temp1, precision);
  }
  //Runden auf x Nachkommastellen (hilfsfunktion)---------------------------------------
  public static double roundtoxdigits(double in, int x){
    double out = in * Math.pow(10, x);
    out = Math.round(out);
    out = out / Math.pow(10, x);
    return out;
  };
  //Towers of Hanoi---------------------------------------------------------------------
  public static void towersofhanoi(int disks, int from, int to, int aux){
    if(disks == 1){
      System.out.println("Move disk from tower " + from + " to " + to);
    }else{
      towersofhanoi(disks - 1, from, aux, to);
      System.out.println("Move disk from tower " + from + " to " + to);
      towersofhanoi(disks - 1, aux, to, from);
    }
  };

}
