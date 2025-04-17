public class Operation{

    protected long[] get_unsigned_val(int bit_length){
        long highest = 0, lowest = 0;
        for (int i = 0; i < bit_length; i++){
            highest += Math.pow(2, i);//get highest
            lowest = highest;//set
            lowest -= highest;//get lowest
        }
        return new long[]{lowest, highest};
    }

    protected long[] get_signed_val(int bit_length){
        long highest = 0, lowest = 0;

        for (int i = 0; i < bit_length; i++){
            if (i < bit_length - 1){//get highest
            highest += Math.pow(2, i);
            }

            if (i == bit_length - 1){//get lowest
                lowest = - (int) Math.pow(2, i);
            }
        }
        return new long[]{lowest, highest};
    }
}