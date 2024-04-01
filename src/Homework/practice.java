package Homework;

import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //int a = input.nextInt();
        System.out.println("===Input your score===");
        System.out.print("Khmer=");
        float kh = input.nextFloat();
        System.out.print("Math=");
        float math = input.nextFloat();
        System.out.print("English=");
        float eng = input.nextFloat();
        System.out.print("Biology=");
        float bio = input.nextFloat();
        float total = kh + math + eng + bio;
        float avg = total/4;

        if(avg>90){
            System.out.println("A");
        } else if (avg>=80 && avg <90) {
            System.out.println("B");
        } else if (avg>=70 && avg <80) {
            System.out.println("C");
        } else if (avg>=60 && avg <70) {
            System.out.println("D");
        } else if (avg>=50 && avg <60) {
            System.out.println("E");
        }else {
            System.out.println("F");
        }
        System.out.println("Average="+avg);
        }

    }

