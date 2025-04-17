package MID_TERMS;
public class FP_Precisions{
//Todo: 
//half [/]float -> bin [/] bin -> float
//single [/]float -> bin [/] bin -> float
//double []float -> bin [] bin -> float
//quad []float -> bin [] bin -> float



//half
    private static int get_signed_val(int bit_length){
        int highest = 0;
        for (int i = 0; i < bit_length; i++){
            if (i < bit_length - 1){//get highest
            highest += Math.pow(2, i);
            }
        }
        return highest;
    }

    protected void half_float_bin(float val){//16 bits - s = 1, e = 5, f = 10
        int exp_bit_length = 5;
        int s = 0;
        int e = get_signed_val(exp_bit_length);
        //int exp_val;
        String f = "";
        String binary = "";

        System.out.println(e);
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
            e = (final_position - 1) + e;
        }
        //exp_val = e - 127;


        String float_val_bin = "";
        float float_val = val - int_part;//gets the fraction part
        int pos = 0;
        float val_f = 0;

        while(float_val != 0 || float_val_bin.length() < 7){//fraction to binary
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
        System.out.println("s(x) = " + s + "\ne(x) = " + e + "\nf(x) = " + 
                            val_f + "\nexponent value = "  +"\nbinary value = " + binary 
                            );
    }

    public static void half_bin_float(String bin){//half binary to floaaaaaaaaaaaaat
        int exp_bit_length = 5;
        int s;
        int e = get_signed_val(exp_bit_length);
        int exp_val = 0;
        float f = 1.0f;

        if(bin.charAt(0) == '0'){//s
            s = 0;
        }else{
            s = 1;
        }

        for(int i = 1, poss = 4; i <= 5; i++, poss--){//e
            int cur = Integer.parseInt(String.valueOf(bin.charAt(i)));
            if(cur == 1){
                exp_val += Math.pow(2, poss);
            }
        }
   
        //exp_val = e - 127;
        
        for(int i = 6, pos = 0; i <= 15; i++){//f
            int cur = Integer.parseInt(String.valueOf(bin.charAt(i)));
            pos--;
            if(cur == 1){
                f += Math.pow(2, pos);
            }
        }
        float float_val = (float) (Math.pow(-1, s) * Math.pow(2, exp_val - e) * (f));

        //result
        //String hexa = toHexa(float_val);
        System.out.println("s(x) = " + s + "\ne(x) = " + e + "\nf(x) = " + 
                            f + "\nexponent value = "  + exp_val +"\nfloat value = " + float_val
                            + "\nhexadecimal value = ");
    }












//single
    
    public static void single_bin_float(String bin){
        int s;
        int bit_length = 8;
        int e = get_signed_val(bit_length);
        int exp_val = 0;
        float f = 1.0f;
        System.out.println(e);

        if(bin.charAt(0) == '0'){//s
            s = 0;
        }else{
            s = 1;
        }

        for(int i = 1, poss = 7; i <= 8; i++, poss--){//e
            int cur = Integer.parseInt(String.valueOf(bin.charAt(i)));
            if(cur == 1){
                exp_val += Math.pow(2, poss);
            }
        }
   
        //exp_val = e - 127;
        
        for(int i = 9, pos = 0; i <= 31; i++){//f
            int cur = Integer.parseInt(String.valueOf(bin.charAt(i)));
            pos--;
            if(cur == 1){
                f += Math.pow(2, pos);
            }
        }
        System.out.println(exp_val);
        float float_val = (float) (Math.pow(-1, s) * Math.pow(2, exp_val - e) * (f));

        //result
        //String hexa = toHexa(float_val);
        System.out.println("s(x) = " + s + "\ne(x) = " + e + "\nf(x) = " + 
                            f + "\nexponent value = "  + exp_val +"\nfloat value = " + float_val
                            + "\nhexadecimal value = ");
    }

    public static void single_float_bin(float val){
        int bit_length = 8;
        int s;
        int e = get_signed_val(bit_length);
        int exp_val = 0;
        String f = "";
        String binary = "";
        //String hexa = toHexa(val);

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
            exp_val = 0;
        } else {
            exp_val = (final_position - 1) + e;
        }


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
        int exp = exp_val;
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
                            + "\nhexadecimal value = ");

    }

}