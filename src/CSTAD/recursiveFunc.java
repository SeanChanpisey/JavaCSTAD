package CSTAD;

public class recursiveFunc {
   private static int recursiceFunction(int num) {
       if (num < 1) {
           return 1;//base case
       } else {
        return num*recursiceFunction(num-1);//recursive
       }
   }

    public static void main(String[] args) {
        System.out.println("Factorial of number:"+recursiceFunction(3));
    }
}
