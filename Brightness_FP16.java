package MID_TERMS;
import java.util.Scanner;
public class Brightness_FP16 {
    private static void Float_to_binary(float val){
        int s;
        int e = 0;
        int exp_val;
        String f = "";
        String binary = "";
    
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
            e = (final_position - 1) + 15;
        }
        exp_val = e - 15;
    
        String float_val_bin = "";
        float float_val = val - int_part;//gets the fraction part
        int pos = 0;
        float val_f = 0;
    
        while(float_val != 0 && float_val_bin.length() < 10){//fraction to binary
            pos--;
            float curr = (float) Math.pow(2, pos);
            if(float_val >= curr){
                float_val_bin += "1";
                float_val -= curr;
            }else{
                float_val_bin += "0";
            }
        }
    
        f = int_val_bin.substring(1) + float_val_bin;
    
        if (f.length() > 10) {
            String temp = "";
            for (int i = 0; i < 10; i++) {
                temp += f.charAt(i);
            }
            f = temp;
        } else {
            while (f.length() < 10) {
                f += "0";
            }
        }
    
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
        while (bit_count < 5) {//exponent to binary
            e_bin = (exp % 2) + e_bin;
            exp /= 2;
            bit_count++;
        }
    
        binary = s + " " + e_bin + " " + f;
    
        //result
        System.out.println("Stored in memory: " + binary);
    }
    

    private static float get_luminance(float lux){
        return (float) (lux * 0.47);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the lux value: ");
        float lux = input.nextFloat();
        float luminance = get_luminance(lux);
        System.out.println("Luminance: " + luminance + " cd/m^2");
        Float_to_binary(luminance);
    }
}
