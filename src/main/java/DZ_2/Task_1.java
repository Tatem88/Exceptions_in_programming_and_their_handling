package DZ_2;

import java.util.Scanner;
public class Task_1 {
    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                System.out.println("Type digit in float format: ");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                double d = Double.parseDouble(s);
                System.out.println("It ok: " + d);
                break;
            }catch (NumberFormatException e) {
                System.out.println("Exception: " + e + " try again");
            }
        }
    }

}
