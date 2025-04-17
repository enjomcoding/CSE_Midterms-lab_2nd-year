package MID_TERMS;
import java.util.Scanner;
public class Gravity_FP32 {
    public static void Float_to_binary(float force) {
        int intBits = Float.floatToIntBits(force);
        String binary = "";

        for (int i = 0; i < 32; i++) {
            binary = (intBits % 2) + binary;
            intBits /= 2;
        }
    
        String s = "";
        for (int i = 0; i < 1; i++) {
            s += binary.charAt(i);
        }
    
        String e = "";
        for (int i = 1; i < 9; i++) {
            e += binary.charAt(i);
        }
    
        String f = "";
        for (int i = 9; i < 32; i++) {
            f += binary.charAt(i);
        }
    
        System.out.println("Stored in memory: " + s + " " + e + " " + f);
    }
    
    
    
    private static float get_grav_force(float mass1, float mass2, float radius){
        float grav_cons = 6.674e-11f;
        return grav_cons * ((mass1 * mass2) / (radius * radius));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter mass 1 (kg): ");
        float mass1 = scanner.nextFloat();

        System.out.print("Enter mass 2 (kg): ");
        float mass2 = scanner.nextFloat();

        System.out.print("Enter radius (m): ");
        float radius = scanner.nextFloat();

        float force = get_grav_force(mass1, mass2, radius);
        System.out.println("Gravitational Force: " + force + " N");
        Float_to_binary(force);

    }
}
