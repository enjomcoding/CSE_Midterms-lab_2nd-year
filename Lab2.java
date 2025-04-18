import java.util.Scanner;
public class Lab2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input Number of Matrices (min 2): ");
        int num = input.nextInt();

        if (num < 2) {
            System.out.println("At least 2 matrices required.");
            return;
        }

        char name = 'A';
        int[] dim = new int[num + 1];         // dim length = num + 1
        int[][] cols_rows = new int[num][2];  // Store dimensions for each matrix

        // Input first matrix
        System.out.println("Matrix " + name + ":");
        System.out.print("Input Column: ");
        int col = input.nextInt();
        System.out.print("Input Row: ");
        int row = input.nextInt();

        dim[0] = col;
        dim[1] = row;
        cols_rows[0][0] = col;
        cols_rows[0][1] = row;

        // Loop for remaining matrices
        for (int i = 1; i < num; i++) {
            name++;
            System.out.println("Matrix " + name + ":");
            System.out.print("Input Column: ");
            col = input.nextInt();
            System.out.print("Input Row: ");
            row = input.nextInt();

            dim[i + 1] = row;
            cols_rows[i][0] = col;
            cols_rows[i][1] = row;
        }

        // Display matrix sizes
        System.out.println("\nMatrix dimensions:");
        for (int i = 0; i < num; i++) {
            System.out.printf("Matrix %c: %d x %d\n", (char) ('A' + i), cols_rows[i][0], cols_rows[i][1]);
        }

        // Show the dim[] used for DP
        System.out.print("\ndim[] for DP: ");
        for (int d : dim) System.out.print(d + " ");
        System.out.println();
    }
}
