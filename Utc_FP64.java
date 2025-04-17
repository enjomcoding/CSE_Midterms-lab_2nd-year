package Lab.MID_TERMS;
import java.time.Instant;
import java.time.LocalDateTime;

public class Utc_FP64 {
    private static void get_UTC(double S){
        String curr_date_time = get_curr_date_time();
        double T0 = 0.0; //January 1, 1970
        double T = T0 + S;
        System.out.println("UTC Time as of [" + curr_date_time + "]: " + T);
        Float_to_binary(T);
    }

    public static void Float_to_binary(double T) {
        long intBits = Double.doubleToLongBits(T);
        String binary = "";

        for (int i = 0; i < 64; i++) {
            binary = (intBits % 2) + binary;
            intBits /= 2;
        }
    
        String s = "";
        for (int i = 0; i < 1; i++) {
            s += binary.charAt(i);
        }
    
        String e = "";
        for (int i = 1; i < 12; i++) {
            e += binary.charAt(i);
        }
    
        String f = "";
        for (int i = 12; i < 64; i++) {
            f += binary.charAt(i);
        }
    
        System.out.println("Stored in memory: " + s + " " + e + " " + f);
    }

    private static String get_curr_date_time() {
        LocalDateTime now = LocalDateTime.now();
        
        // get current year, month, day, hour, minute, and second
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
    
        return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
    }
    
    public static void main(String[] args) {
        double S = Instant.now().getEpochSecond();//current time
        get_UTC(S);
    }
}
