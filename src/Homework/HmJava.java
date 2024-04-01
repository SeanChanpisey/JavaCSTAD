package Homework;

import java.util.Scanner;

public class HmJava {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input Number 1:");
        int n1 = input.nextInt();
        System.out.print("Input Number 2:");
        int n2 = input.nextInt();
        System.out.print("Input Number 3:");
        int n3 = input.nextInt();
        int greatest = n1;
        int lowest = n1;

        // Find the greatest and lowest numbers using if-else statements
        if (n2 > greatest) {
            greatest = n2;
        } else if (n2 < lowest) {
            lowest = n2;
        }
        if (n3 > greatest) {
            greatest = n3;
        } else if (n3 < lowest) {
            lowest = n3;
        }
        // Print the results
        System.out.println("The Greatest: " + greatest);
        System.out.println("The Lowest: " + lowest);
    }
}
