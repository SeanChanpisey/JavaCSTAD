package CSTAD;

import java.util.Scanner;
public class my_first_java {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ch = 0;
        System.out.println("Choose your:");
        System.out.println("1.Sum number");
        System.out.println("2.Multiple number");
        System.out.println("3.Device number");
        System.out.println("4.Exit");
        System.out.println("Enter your choise:");
        input.nextInt();

        switch (ch=0){
            case 1:
                System.out.println("1.Sum number");
                System.out.print("Input number of a=");
                int a = input.nextInt();
                System.out.print("Input number of b=");
                int b = input.nextInt();
                int c = a+b;
                System.out.print("Result="+c);

            case 2:
                System.out.println("2.Multiple number");
            case 4: break;
        }
    }

}
