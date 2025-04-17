package MID_TERMS;
import java.util.Scanner;
public class ieee_754 { 

    public static void Binary_to_float(String bin){
        int s;
        int e = 0;
        int exp_val;
        float f = 1.0f;

        if(bin.charAt(0) == '0'){//s
            s = 0;
        }else{
            s = 1;
        }

        for(int i = 1, poss = 7; i <= 8; i++, poss--){//e
            int cur = Integer.parseInt(String.valueOf(bin.charAt(i)));
            if(cur == 1){
                e += Math.pow(2, poss);
            }
        }
   
        exp_val = e - 127;
        
        for(int i = 9, pos = 0; i <= 31; i++){//f
            int cur = Integer.parseInt(String.valueOf(bin.charAt(i)));
            pos--;
            if(cur == 1){
                f += Math.pow(2, pos);
            }
        }

        float float_val = (float) (Math.pow(-1, s) * Math.pow(2, exp_val) * (f));

        //result
        String hexa = toHexa(float_val);
        System.out.println("s(x) = " + s + "\ne(x) = " + e + "\nf(x) = " + 
                            f + "\nexponent value = "  + exp_val +"\nfloat value = " + float_val
                            + "\nhexadecimal value = " + hexa);
    }

    public static void Float_to_binary(float val){
        int s;
        int e = 0;
        int exp_val;
        String f = "";
        String binary = "";
        String hexa = toHexa(val);

        if(val < 0){//s
            s = 1;
        }else{
            s = 0;
        }

        val *= (float) Math.pow(-1, s);//gets the absolute value
        long int_val = (long) val;//gets the whole number part
        long int_part = int_val;

        String int_val_bin = "";
        int final_position = 0;
        if (int_part == 0) {
            int_val_bin = "0";
        }
        while (int_val > 0) {//whole number to binary
            int_val_bin = (int_val % 2) + int_val_bin;
            int_val /= 2;
            final_position++;
        }

        if (val == 0) {//exponent value
            e = 0;
        } else {
            e = (final_position - 1) + 127;
        }
        exp_val = e - 127;


        String float_val_bin = "";
        float float_val = val - int_part;//gets the fraction part
        int pos = 0;
        float val_f = 0;

        while(float_val != 0 || float_val_bin.length() < 23){//fraction to binary
            pos--;
            float curr = (float) Math.pow(2, pos);
            if(float_val >= curr){
                float_val_bin += "1";
                float_val -= curr;
            }else{
                float_val_bin += "0";
            }
        }
        System.out.println("ssss" + float_val_bin);

        f = int_val_bin.substring(1) + float_val_bin;

        //fraction value f(x)
        int poss = 0;
        for(int i = 0; i < f.length(); i++){
            poss--;
            if(f.charAt(i) == '1'){
                val_f += Math.pow(2, poss);
            }
        }

        String e_bin = "";
        int exp = e;
        int bit_count = 0;
        while (bit_count < 8) {//exponent to binary
            e_bin = (exp % 2) + e_bin;
            exp /= 2;
            bit_count++;
        }
        
        binary = s + " " + e_bin + " " + f;

        //result
        System.out.println("s(x) = " + s + "\ne(x) = " + e + "\nf(x) = " + 
                            val_f + "\nexponent value = "  + exp_val +"\nbinary value = " + binary 
                            + "\nhexadecimal value = " + hexa);

    }

    private static String toHexa(float val) {
        int intBits = Float.floatToIntBits(val);
        return Integer.toHexString(intBits).toUpperCase();
    }
    


    public static void main(String[] args){
        System.out.print("Choose the conversion type:\n[1] Binary to Float\n[2] Float to Binary\nSelect an option: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();

        if(choice == 1){
            System.out.print("Enter the binary number: ");
            String bin = input.nextLine().replace(" ", "");
            Binary_to_float(bin);
        }else{
            System.out.print("Enter the float value: ");
            float val = input.nextFloat();
            Float_to_binary(val);
        }
    }
}
