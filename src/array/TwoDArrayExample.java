package array;

import java.util.Scanner;

public class TwoDArrayExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set the row and column numbers
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Create the 2D array
        String[][] array2D = new String[rows][columns];

        // Insert values into each row
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter the values for row " + (i + 1) + ":");
            for (int j = 0; j < columns; j++) {
                array2D[i][j] = scanner.next();
            }
        }

        // Print all values
        System.out.println("The 2D array values are:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println();
        }
    }
}