package MID_TERMS;
public class Screen_Unsigned {
    private static int get_unsigned_val(int bit_length){
        int max = 0;
        for (int i = 0; i < bit_length; i++){
            max += Math.pow(2, i);//get highest
        }
        return max;
    }

    private static void to_bin(int max, int total_px) {
        int s;
        int b;
        String binary = "";
        s = 0;
        b = total_px;
 
        while (b > 0) {//to binary
            binary = (b % 2) + binary;
            b /= 2;
        }
    
        while (binary.length() < 7) {
            binary = "0" + binary;
        }
        System.out.println("Stored in memory:" + s + binary);
    }
    public static void main(String[] args) {
        int bits = 8;

        int[][] screen = {
            {0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 0},
            {1, 1, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 0, 0}
        };
        int tot_px_count = 0;
        for(int i = 0; i < screen.length; i++){
            int row_px_count = 0;
            for(int j = 0; j < screen[i].length; j++){
                if(screen[i][j] == 1){
                    tot_px_count++;
                    row_px_count++;
                } 
            }
            System.out.println("Activated Pixels in Row " + (i + 1) + ": " + row_px_count);
            to_bin(get_unsigned_val(bits), row_px_count);
        }
        System.out.println();
        System.out.println("Total Activated Pixels: " + tot_px_count);
        to_bin(get_unsigned_val(bits), tot_px_count);
    }
}
