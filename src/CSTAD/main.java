package CSTAD;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Scanner;
public class main {
    /**
     * Author:Pisey
     * Since:2003
     * made in Cambodia
     */
    public static void get() {
        Integer age = 18;
        String name = "Pisey";
        System.out.println("Age="+age);
        System.out.println("Name="+name);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Input phone number =");
        int a = input.nextInt();
        System.out.println("Input your name:");
        String name = input.next();
        System.out.println("Input Gender:");
        Character gen = input.next().charAt(0);
        System.out.println("Input salary:");
        float salary = input.nextFloat();

        System.out.println("=======================\n");
        System.out.println("Phone number:"+a);
        System.out.println("Name:"+name);
        System.out.println("Gender:"+gen);
        System.out.println("Salary:"+salary);


     //get();
    }
}
