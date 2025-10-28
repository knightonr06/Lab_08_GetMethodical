import java.util.Scanner;

public class Reggie {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String SSN = "";
        String StudentMNumber = "";
        String MenuChoice = "";
        SSN = SafeInput.getRegExString(new java.util.Scanner(System.in), "Enter your SSN (format: XXX-XX-XXXX): ", "\\d{3}-\\d{2}-\\d{4}");
        StudentMNumber = SafeInput.getRegExString(new java.util.Scanner(System.in), "Enter your Student M Number (format: MXXXXXXX): ", "M\\d{7}");
        MenuChoice = SafeInput.getRegExString(new java.util.Scanner(System.in), "Enter your menu choice (Oo, Ss, Vv, Qq): ", "[OoSsVvQq]");

        System.out.println("SSN: " + SSN);
        System.out.println("Student M Number: " + StudentMNumber);
        System.out.println("Menu Choice: " + MenuChoice);
    }
}
