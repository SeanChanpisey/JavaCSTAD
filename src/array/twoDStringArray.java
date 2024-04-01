package array;

import java.util.Scanner;
public class twoDStringArray {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            //  set row and column number
            System.out.print("Enter the number of rows: ");
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            int columns = scanner.nextInt();
            // Creating the 2D array
            String[][] array2D = new String[rows][columns];

            for (int i = 0; i < rows; i++) {
                System.out.println("Enter values for row " + (i + 1) + ":");
                for (int j = 0; j < columns; j++) {
                    System.out.print("Enter value for column " + (j + 1) + ": ");
                    array2D[i][j] = scanner.next();
                }
            }

            // Printing all values
            System.out.println("Values in the 2D array:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(array2D[i][j] + " ");
                }
                System.out.println();
            }
        }
    }


