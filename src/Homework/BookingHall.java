package Homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//import static Homework.hall_project.*;

public class BookingHall {
    static Scanner scanner = new Scanner(System.in);
    static int[][] seat;
    static String[][] book1;
    static String[][] book2;
    static String[][] book3;
    static String[][] studentIDs1;
    static String[][] studentIDs2;
    static String[][] studentIDs3;
    static String[][] stuId;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a=0;
        //int[][] seat = new int[0][0];
        System.out.println("========Hall booking system========");
        //System.out.println("#. Enter total rows in hall: ");
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter total seat per hall: ");
        int columns = input.nextInt();

        seat = new int[rows][columns];
        book1 = new String[rows][columns];
        book2 = new String[rows][columns];
        book3 = new String[rows][columns];
        studentIDs1 = new String[rows][columns];
        studentIDs2 = new String[rows][columns];
        studentIDs3 = new String[rows][columns];


        do {

            System.out.println("++++++++Show menu++++++++");
            System.out.println("=========================");
            System.out.println("1.||   Booking         ||");
            System.out.println("2.||   Hall            ||");
            System.out.println("3.||   Show time       ||");
            System.out.println("4.||   Reboot Hall     ||");
            System.out.println("5.||   History         ||");
            System.out.println("6.||   Exit            ||");
            System.out.println("========================");
            //break;
            System.out.print("Enter your choice:");
            int b = new Scanner(System.in).nextInt();
            switch (b) {
                case 1: {
                    bookHall();
                    break;
                }
                case 2: {
                        showHall("====Morning Hall====",book1);
                        showHall("====Afternoon Hall====",book2);
                        showHall("====Evening Hall====",book3);
                        break;
                }
                case 3: {
                    showTime();
                    break;
                }
                case 4: {
                    reboot();
                    break;
                }
                case 5: {
                    showHistory("Morning Hall",book1,studentIDs1);
                    System.out.println("------------------------------");
                    showHistory("Afternoon Hall",book2,studentIDs2);
                    System.out.println("------------------------------");
                    showHistory("Night Hall",book3,studentIDs3);
                    break;
                }
                case 6: {
                    System.out.println("Good bye..!");
                    System.exit(0);


                }
                default:{
                    System.out.println("Invalid choice... type again!");
                    break;
                }

            }
            //input.close();
        }while (true);


    }


    //====Case 1
    static void bookHall() {
        System.out.println("---> (1. Morning Hall) <---");
        System.out.println("---> (2. Afternoon Hall) <---");
        System.out.println("---> (3. Night Hall) <---");
        System.out.print("Select Hall (1-3):");
        int hallselect = scanner.nextInt();
        switch (hallselect) {
            case 1:
                bookTimeHall("Morning Hall",book1,studentIDs1);
                break;
            case 2:
                bookTimeHall("Afternoon Hall",book2,studentIDs2);
                break;
            case 3:
                bookTimeHall("Night Hall",book3,studentIDs3);
                break;
            default:
                System.out.println("Invalid choice. Please enter again.");
        }
    }



    static void bookTimeHall(String name, String[][] hallName, String[][] stuId) {
        char ch = 'A';
        System.out.println("--> " + name + " <--");
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                System.out.print("|" + ch + "-" + (j + 1) + "::" + (hallName[i][j] != null ? "BO" : "AV") + "| \t\t");
            }
            ch++;
            System.out.println();
        }
        System.out.println("Instruction: Enter single seat as A-1");
        System.out.println("Multiple seats should be entered as A-1,A-2");
        System.out.print("Enter your seat using (A-1,A-2): ");
        String input = scanner.next();
        System.out.print("Enter your student ID: ");
        String stuid = scanner.next();
        System.out.print("Are you sure to book (y/n): ");
        char yn = scanner.next().charAt(0);
        if (yn == 'y' || yn == 'Y') {
            if (input.contains(",")) {
                String[] seats = input.split(",");
                for (String seatString : seats) {
                    String[] parts = seatString.split("-");
                    int row = parts[0].charAt(0) - 'A';
                    int col = Integer.parseInt(parts[1]) - 1;
                    if (hallName[row][col] != null && hallName[row][col].equals("BO")) {
                        System.out.println("Seat " + seatString + " is already booked.!Please select another seat.");
                    } else {
                        hallName[row][col] = "BO";
                        stuId[row][col] = stuid;
                    }
                }
            } else {
                String[] parts = input.split("-");
                int row = parts[0].charAt(0) - 'A';
                int col = Integer.parseInt(parts[1]) - 1;
                if (hallName[row][col] != null && hallName[row][col].equals("BO")) {
                    System.out.println("Seat " + input + " is already booked.!Please select another seat.");
                } else {
                    hallName[row][col] = "BO";
                    stuId[row][col] = stuid;
                    System.out.println("Booking successfully..!");
                }
            }
        } else if (yn == 'n' || yn == 'N') {
            System.out.println("Booking canceled.");
        } else {
            System.out.println("Invalid input...! Please enter 'y' or 'n'.");
        }
    }
    //case 2
    static void showHall(String namehall, String[][] hallstore) {
        char ch1 = 'A';
        System.out.println("--> "+namehall+" <--");
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                System.out.print("|" + ch1 + "-" + (j + 1) + "::" + (hallstore[i][j] != null ? "BO" : "AV") + "| \t\t");
            }
            ch1++;
            System.out.println();
        }
    }
    //====Case 3
    public static void showTime(){
        System.out.println("+++++++Show times information++++++++++");
        System.out.println("#1.Morning   (10AM - 12:30PM)");
        System.out.println("#2.Afternoon (3PM  - 5:30PM)");
        System.out.println("#3.Evening   (7:00PM - 9:30PM)");
    }
    //case 4
    static void reboot() {
        seat = new int[0][0];
        book1 = new String[0][0];
        book2 = new String[0][0];
        book3 = new String[0][0];
        studentIDs1 = new String[0][0];
        studentIDs2 = new String[0][0];
        studentIDs3 = new String[0][0];
        System.out.print("Input new row seat: ");
        int r = scanner.nextInt();
        System.out.print("Input new total of seats: ");
        int c = scanner.nextInt();
        seat = new int[r][c];
        seat = new int[r][c];
        book1 = new String[r][c];
        book2 = new String[r][c];
        book3 = new String[r][c];
        studentIDs1 = new String[r][c];
        studentIDs2 = new String[r][c];
        studentIDs3 = new String[r][c];


    }
    //case 5
    static void showHistory(String name,String [][] hallName,String[][] stuid) {
        System.out.println("--> "+name);
        System.out.println("#Seat\t\t#Student ID:\t\t#Booking Time: ");
        for (int i = 0; i < book1.length; i++) {
            for (int j = 0; j < hallName[i].length; j++) {
                if (hallName[i][j] != null) {
                    System.out.println((char) ('A' + i) + "-" + (j + 1) +"\t\t\t"+ stuid[i][j] +"\t\t\t"+
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM-dd-yyyy HH:mm:ss")));
                }
            }
        }
    }

}
