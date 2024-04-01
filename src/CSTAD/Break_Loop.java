package CSTAD;

import java.util.Scanner;

public class Break_Loop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       /* System.out.print("Input names:");
        String name = input.nextLine();
        String[] names = name.split(",");
        for(String n:names){
            System.out.print("List of names:");
            System.out.println(n.trim());
        }*/

        /*System.out.print("Input Age:");
        String age = input.nextLine();
        Integer age1 = Integer.parseInt(age);
        if(age1>0 && age1<10){
            System.out.print("Correct");
        } else if (age1>18 && age1<20) {
            System.out.print("You are an aldult");
        }else
        {
            System.out.print("Wrong");
        }*/

        /*
        System.out.print("Input Your age:");
        int age = input.nextInt();
        switch (age){
            case 10->{
                System.out.println("You are 10");

            }
            case 19 -> {System.out.println("you are 19 or 21");

            }
            default->
                System.out.println("Wrong age");
        }*/
        /*
        System.out.print("Input your age:");
        int age = input.nextInt();
        int a = switch (age) {
            case 1 -> age;
            case 18, 21 -> age;
            default -> throw new IllegalStateException("Unexpected value: " + age);
        };*/
        label1:
        for (int i = 0; i < 5; i++) {
            label2:
            for(int j = 0; j<i; j++){
                if(j==2){
                    continue label2;
                }
                System.out.println(j);
            }

        }

        }
    }

