package MID_TERMS;
import java.util.Scanner;
public class Joystick_Signed {
    private static int[] get_signed_val(int bit_length){
        int highest = 0, lowest = 0;

        for (int i = 0; i < bit_length; i++){
            if (i < bit_length - 1){//get highest
            highest += Math.pow(2, i);
            }

            if (i == bit_length - 1){//get lowest
                lowest = - (int) Math.pow(2, i);
            }
        }
        return new int[]{lowest, highest};
    }

    private static void to_bin(int coordinate, int min) {
        int s;
        int b;
        String binary = "";
    
        if (coordinate < 0) { //negativ
            s = 1;
            int x = Math.abs(coordinate);
            b = Math.abs(min + x); //complement
        } else { //positive
            s = 0;
            b = coordinate;
        }
 
        while (b > 0) {//to binary
            binary = (b % 2) + binary;
            b /= 2;
        }
    
        while (binary.length() < 3) {
            binary = "0" + binary;
        }
        System.out.println("Stored in memory:" + s + binary);
    }
    
    

    private static int get_coordinate_of_x(int x_initial, int x_input_pos){
        return x_initial + x_input_pos;
    }

    private static int get_coordinate_of_y(int y_initial, int y_input_pos){
        return y_initial + y_input_pos;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] axes = get_signed_val(4);

        System.out.println("X axis\nMinimum position: " + axes[0] + "\nMaximum position: " + axes[1]);
        System.out.print("Y axis\nMinimum position: " + axes[0] + "\nMaximum position: " + axes[1]);
        System.out.println();
        //x
        System.out.print("\nEnter the initial position of the joystick (x-axis): ");
        int x_initial = input.nextInt();
        System.out.print("Enter the movement position of the joystick (x-axis): ");
        int x_input_pos = input.nextInt();
        //y
        System.out.println();
        System.out.print("Enter the initial position of the joystick (y-axis): ");
        int y_initial = input.nextInt();
        System.out.print("Enter the movement position of the joystick (y-axis): ");
        int y_input_pos = input.nextInt();
        System.out.println();
        //x axis
        int curx = get_coordinate_of_x(x_initial, x_input_pos);
        if (curx > axes[1] || curx < axes[0]) {
            System.out.println("Invalid input: X-axis out of bounds.");
            return;
        }
        System.out.println("Current position of the joystick (x-axis): " + curx);
        to_bin(curx, axes[0]);

        //y axis
        int cury = get_coordinate_of_y(y_initial, y_input_pos);
        if (cury > axes[1] || cury < axes[0]) {
            System.out.println("Invalid input: Y-axis out of bounds.");
            return;
        }
        System.out.println("Current position of the joystick (y-axis): " + cury);
        to_bin(cury, axes[0]); 
    }
}