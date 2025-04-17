package Lab;

import java.util.Scanner;
public class TIJADA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Operation op = new Operation();

        System.out.print("Enter number of bit: ");
        int bit_length = input.nextInt();

        long[] res = op.get_unsigned_val(bit_length);
        System.out.println("unsigned -> lowest: " + res[0] + 
                            "   highest: " + res[1]);

        res = op.get_signed_val(bit_length);
        System.out.println("signed -> lowest: " + res[0] + 
                            "   highest: " + res[1]);
    }
}
