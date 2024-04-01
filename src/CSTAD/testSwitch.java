package CSTAD;

import java.util.Scanner;

public class testSwitch {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("===Please input choice===\n" +
                "1.Calculate Total\n" +
                "2.Calculate Average and Show Results\n" +
                "3.Exit");
        System.out.print("Choose:");
        int ch = input.nextInt();

        //String sh = null;
            //int  sh = input.nextInt();

            switch (ch){
                
                case 1:{
                    System.out.println("===Input your score===");
                    System.out.print("Khmer=");
                    float kh = input.nextFloat();
                    System.out.print("Math=");
                    float math = input.nextFloat();
                    System.out.print("English=");
                    float eng = input.nextFloat();
                    System.out.print("Biology=");
                    float bio = input.nextFloat();
                    System.out.println("===Calculate Total===");
                    float total = kh + math + eng + bio;
                    System.out.print("Total score:"+total);
                    break;
                }
                case 2:{
                    System.out.println("===Input your score===");
                    System.out.print("Khmer=");
                    float kh = input.nextFloat();
                    System.out.print("Math=");
                    float math = input.nextFloat();
                    System.out.print("English=");
                    float eng = input.nextFloat();
                    System.out.print("Biology=");
                    float bio = input.nextFloat();
                    System.out.println("===Calculate Average===");
                    float avg = (math + kh + eng + bio) / 4;
                    System.out.print("Average:"+avg);
                    //result
                    System.out.println("\n===Show result===");
                    if(avg>90){
                        System.out.println("You got: A");
                    } else if (avg>=80 && avg <90) {
                        System.out.println("You got: B");
                    } else if (avg>=70 && avg <80) {
                        System.out.println("You got:C");
                    } else if (avg>=60 && avg <70) {
                        System.out.println("You got:D");
                    } else if (avg>=50 && avg <60) {
                        System.out.println("You got:E");
                    }else {
                        System.out.println("You got:F");
                    }
                    break;
                }
                case 3:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid number please Enter again!");
                }
            }
    }




