package Homework;//import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class hall_project {
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
        int r = 0;
        int c = 0;
        System.out.print("Input row seat: ");
        r = scanner.nextInt();
        System.out.print("Input column seat: ");
        c = scanner.nextInt();
        seat = new int[r][c];
        book1 = new String[r][c];
        book2 = new String[r][c];
        book3 = new String[r][c];
        studentIDs1 = new String[r][c];
        studentIDs2 = new String[r][c];
        studentIDs3 = new String[r][c];
        while (true) {
            printMenu();
            char choice = scanner.next().charAt(0);
            switch (Character.toUpperCase(choice)) {
                case 'A':
                    showHall("Morning Hall",book1);
                    showHall("Afternoon Hall",book2);
                    showHall("Night Hall",book3);
                    break;
                case 'B':
                    bookHall();
                    break;
                case 'C':
                    showTimings();
                    break;
                case 'D':
                    showHistory("Morning Hall",book1,studentIDs1);
                    System.out.println("------------------------------");
                    showHistory("Afternoon Hall",book2,studentIDs2);
                    System.out.println("------------------------------");
                    showHistory("Night Hall",book3,studentIDs3);
                    break;
                case 'E':
                    reboot();
                    break;
                case 'F':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    static void printMenu() {
        System.out.println("||=================================||");
        System.out.println("||           -->Hall<--            ||");
        System.out.println("|| A.Hall                          ||");
        System.out.println("|| B.Booking                       ||");
        System.out.println("|| C.Showtime                      ||");
        System.out.println("|| D.History                       ||");
        System.out.println("|| E.Reboot                        ||");
        System.out.println("|| F.Exit                          ||");
        System.out.println("||=================================||");
        System.out.println();
        System.out.print("Choose A -> F: ");
    }

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
                        System.out.println("Seat " + seatString + " is already booked.");
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
                    System.out.println("Seat " + input + " is already booked.");
                } else {
                    hallName[row][col] = "BO";
                    stuId[row][col] = stuid;
                    System.out.println("Thank you......!");
                }
            }
        } else if (yn == 'n' || yn == 'N') {
            System.out.println("Booking canceled.");
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
    }

    static void showTimings() {
        System.out.println("---> Showtime of CSTAD Movies <---");
        System.out.println("--> Morning(10:00 am - 12:00 am)");
        System.out.println("--> Afternoon(3:00 pm - 5:30 pm)");
        System.out.println("--> Night(7:00 pm - 9:30 pm)");
    }

    static void showHistory(String name,String [][] hallName,String[][] stuid) {
        System.out.println("--> "+name);
        System.out.println("#Seat\t\t#Student ID:\t\t#Booking Time: ");
        for (int i = 0; i < book1.length; i++) {
            for (int j = 0; j < hallName[i].length; j++) {
                if (hallName[i][j] != null) {
                    System.out.println((char) ('A' + i) + "-" + (j + 1) +"\t\t\t"+ stuid[i][j] +"\t\t\t"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM-dd-yyyy HH:mm:ss")));
                }
            }
        }
    }

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
        System.out.print("Input new column seat: ");
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
}
