package MID_TERMS;
import java.math.BigDecimal;

public class Big_Precisions {
    private static int get_signed_val(int bit_length) {
        int highest = 0;
        for (int i = 0; i < bit_length; i++) {
            if (i < bit_length - 1) { // get highest
                highest += Math.pow(2, i);
            }
        }
        return highest;
    }

    protected void float_to_bin(BigDecimal val, int e_length, int f_length) { // Changed from double to BigDecimal
        int s = 0;
        int e = 0;
        int exp_val = get_signed_val(e_length);
        String f = "";
        String binary = "";
        //String hexa = toHexa(val);

        if (val.compareTo(BigDecimal.ZERO) < 0) { // s
            s = 1;
            val = val.abs(); // Get absolute value
        }

        System.out.println("Solution:");
        System.out.print("= " + "(-1)^" + s + " x");

        long int_val = val.longValue(); // Get whole number part
        String int_val_bin = "";
        int final_position = 0;
        if (int_val == 0) {
            int_val_bin = "0";
        }

        while (int_val > 0) { // Whole number to binary
            int_val_bin = (int_val % 2) + int_val_bin;
            int_val /= 2;
            final_position++;
        }

        System.out.print(" ( ");
        String whole_bit_pos = "";
        for (int i = 0; i < int_val_bin.length(); i++) { // get position of whole number from its bitrep
            int exponent = (int_val_bin.length() - 1) - i;
            if (int_val_bin.charAt(i) == '1') {
                int curr = (int) Math.pow(2, exponent);
                System.out.print(curr + " + ");
                whole_bit_pos += " 2^" + exponent + " + ";
            }
        }

        if (val.compareTo(BigDecimal.ZERO) == 0) { // Exponent value
            e = 0;
        } else {
            e = (final_position - 1) + exp_val;
        }

        String float_val_bin = "";
        BigDecimal float_val = val.subtract(new BigDecimal(int_val)); // gets the fraction part
        BigDecimal f_part = float_val;
        int pos = 0;
        BigDecimal val_f = BigDecimal.ZERO;

        BigDecimal[] diss_float = new BigDecimal[f_length];
        int index = 0;

        if (float_val.compareTo(BigDecimal.ZERO) == 0) { // cater 0
            diss_float[0] = BigDecimal.ZERO;
            System.out.println(diss_float[0] + " )");
        }

        int[] float_bit_pos = new int[f_length];
        while (float_val.compareTo(BigDecimal.ZERO) != 0 && float_val_bin.length() < f_length) { // fraction to binary
            pos--;
            BigDecimal curr = BigDecimal.valueOf(Math.pow(2, pos));
            if (float_val.compareTo(curr) >= 0) {
                if (index < f_length) {
                    diss_float[index] = curr;
                    index++;
                }
                float_val_bin += "1";
                float_val = float_val.subtract(curr);
                float_bit_pos[index] = pos;
            } else {
                float_val_bin += "0";
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.print(diss_float[i]);
            if (i < index - 1) {
                System.out.print(" + ");
            } else {
                System.out.println(" )");
            }
        }

        f = int_val_bin.substring(1) + float_val_bin;

        String temp_f_length = "";
        if (f.length() > f_length) {
            for (int i = 0; i < f_length; i++) {
                temp_f_length += f.charAt(i);
            }
            f = temp_f_length;
        } else {
            while (f.length() < f_length) {
                f += "0";
            }
        }

        // Fraction value f(x)
        int poss = 0;
        for (int i = 0; i < f.length(); i++) {
            poss--;
            if (f.charAt(i) == '1') {
                val_f = val_f.add(BigDecimal.valueOf(Math.pow(2, poss)));
            }
        }

        String e_bin = "";
        int exp = e;
        int bit_count = 0;
        while (bit_count < e_length) { // Exponent to binary
            e_bin = (exp % 2) + e_bin;
            exp /= 2;
            bit_count++;
        }

        binary = s + " " + e_bin + " " + f;

        //solution
        System.out.print("= " + "(-1)^" + s + " x (" + whole_bit_pos);
        boolean first = true; // Track if it's the first number
        if (f_part.compareTo(BigDecimal.ZERO) == 0) {
            System.out.print(0);
        }

        for (int i = 0; i < float_bit_pos.length; i++) { // prints position of fraction from its bitrep
            if (float_bit_pos[i] != 0) {
                if (!first) {
                    System.out.print(" + ");
                }
                System.out.print("2^" + float_bit_pos[i]);
                first = false;
            }
        }
        System.out.println(" )");

        first = true;
        System.out.print("= " + "(-1)^" + s + " x 2^" + (final_position - 1) + " x ( 1 + ");

        if (f_part.compareTo(BigDecimal.ZERO) == 0) {
            System.out.print(0);
        }
        for (int i = 0; i < float_bit_pos.length; i++) { // prints position of fraction from its bitrep
            if (float_bit_pos[i] != 0) {
                if (!first) {
                    System.out.print(" + ");
                }
                System.out.print("2^" + float_bit_pos[i] + "-" + (final_position - 1));
                first = false;
            }
        }
        System.out.println(" )");

        first = true;
        System.out.print("= " + "(-1)^" + s + " x 2^" + (final_position - 1) + " x ( 1 + ");

        if (f_part.compareTo(BigDecimal.ZERO) == 0) {
            System.out.print(0);
        }

        for (int i = 0; i < float_bit_pos.length; i++) { // prints position of fraction from its bitrep
            if (float_bit_pos[i] != 0) {
                if (!first) {
                    System.out.print(" + ");
                }
                System.out.print("2^" + (float_bit_pos[i] - (final_position - 1)));
                first = false;
            }
        }
        System.out.println(" )");

        System.out.println("= " + "(-1)^" + s + " x 2^" + e + "-" + exp_val + " x ( 1." + f + " )");
        System.out.println("= " + s + " ( " + e + " ) " + f);

        // Result
        System.out.println("\nResult:");
        System.out.println("s(x) = " + s + "\ne(x) = " + e + "\nf(x) = " +
                val_f + "\nexponent value = " + (final_position - 1) + "\nbinary value = " + binary
                + "\nhexadecimal value = ");
    }

    public void bin_to_float(String bin, int e_length, int f_length) {
        int s;
        int e = get_signed_val(e_length);
        int exp_val = 0;
        int exp = 0;
        BigDecimal f = BigDecimal.ONE;

        if (bin.charAt(0) == '0') { // s
            s = 0;
        } else {
            s = 1;
        }

        for (int i = 1, poss = e_length - 1; i <= e_length; i++, poss--) { // e
            int cur = Integer.parseInt(String.valueOf(bin.charAt(i)));
            if (cur == 1) {
                exp_val += Math.pow(2, poss);
            }
        }
        exp = exp_val - e;

        String f_part = "";
        int[] pos_of_f = new int[f_length];
        for (int i = e_length + 1, pos = -1; i < e_length + 1 + f_length; i++) {
            f_part += bin.charAt(i);
            int cur = Integer.parseInt(String.valueOf(bin.charAt(i)));
            if (cur == 1) {
                f = f.add(BigDecimal.valueOf(Math.pow(2, pos)));
                pos_of_f[i - (e_length + 1)] = pos;
            }
            pos--;
        }

        BigDecimal float_not_val = BigDecimal.valueOf(Math.pow(-1, s))
                .multiply(BigDecimal.valueOf(Math.pow(2, exp_val - e)));
        BigDecimal float_val = float_not_val.multiply(f);

        // solution
        System.out.println("Solution: ");
        if (f_part.length() < f_length) {
            for (int i = f_part.length(); i < f_length; i++) {
                f_part += "0";
            }
        }

        System.out.println("= (-1)^" + s + " x 2^" + exp_val + "-" + e + " x 1." + f_part);
        System.out.print("= (-1)^" + s + " x 2^" + exp + " x ( 1 ");
        boolean first = true;
        for (int i = 0; i < pos_of_f.length; i++) { // prints position of fraction from its bitrep
            if (pos_of_f[i] != 0) {
                if (!first) {
                    System.out.print(" + ");
                }
                System.out.print("2^" + pos_of_f[i]);
                first = false;
            }
        }
        System.out.println(" )");

        System.out.println("= " + float_not_val + " x " + "( " + f + " )");

        // result
        //String hexa = toHexa(float_val.doubleValue());
        System.out.println("\nResult:");
        System.out.println("s(x) = " + s + "\ne(x) = " + exp + "\nf(x) = " +
                f + "\nexponent value = " + exp_val + "\nfloat value = " + float_val
                + "\nhexadecimal value = ");
    }

    private static String toHexa(Double val) {
        long longBits = Double.doubleToLongBits(val);
        return Long.toHexString(longBits).toUpperCase();
    }
}