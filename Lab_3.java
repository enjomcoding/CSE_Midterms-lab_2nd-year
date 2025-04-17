package MID_TERMS;
import java.util.Scanner;
public class Lab_3 {

    private static int mode(Scanner input, Precisions p){
        System.out.print("Modes:\n[1]Binary to Float\n[2]Float to Binary\nSelect an option: ");
        int choice = input.nextInt();
        return choice;
    }
     public static void main(String[] args) {
        int half_e = 5, half_f = 10;
        int single_e = 8, single_f = 23;
        int double_e = 11, double_f = 52;
        int quad_e = 15, quad_f = 112;

        Precisions p = new Precisions();
        Scanner input = new Scanner(System.in);
        System.out.print("Precisions:\n[1]Half Precision\n[2]Single Precison\n[3]Double Precision\n[4]Quadruple Precision\nSelect an option: ");
        int choice = input.nextInt();
        

        switch(choice){
            case 1://half
                input.nextLine();
                int m = mode(input, p);
                if(m == 1){
                    input.nextLine();
                    System.out.print("Enter Binary Value: ");
                    String bin = input.nextLine();
                    p.bin_to_float(bin.replace(" ", ""), half_e, half_f);
                }else{
                    System.out.print("Enter Float Value: ");
                    double flot = input.nextDouble();
                    p.float_to_bin(flot, half_e, half_f);
                }
                break;

            case 2://single
                input.nextLine();
                m = mode(input, p);
                if(m == 1){
                    input.nextLine();
                    System.out.print("Enter Binary Value: ");
                    String bin = input.nextLine();
                    p.bin_to_float(bin.replace(" ", ""), single_e, single_f);
                }else{
                    System.out.print("Enter Float Value: ");
                    double flot = input.nextDouble();
                    p.float_to_bin(flot, single_e, single_f);
                }
                break;

            case 3://double
                input.nextLine();
                m = mode(input, p);
                if(m == 1){
                    input.nextLine();
                    System.out.print("Enter Binary Value: ");
                    String bin = input.nextLine();
                    p.bin_to_float(bin.replace(" ", ""), double_e, double_f);
                }else{
                    System.out.print("Enter Float Value: ");
                    double flot = input.nextDouble();
                    p.float_to_bin(flot, double_e, double_f);
                }
                break;

            case 4://quad
                input.nextLine();
                m = mode(input, p);
                if(m == 1){
                    input.nextLine();
                    System.out.print("Enter Binary Value: ");
                    String bin = input.nextLine();
                    p.bin_to_float(bin.replace(" ", ""), quad_e, quad_f);
                }else{
                    System.out.print("Enter Float Value: ");
                    double flot = input.nextDouble();
                    p.float_to_bin(flot, quad_e, quad_f);
                }
                break;
        }
    }
}
