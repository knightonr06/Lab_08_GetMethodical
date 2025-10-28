import java.util.Scanner;

public class BirthDateTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int birthYear = 0;
        int birthMonth = 0;
        int birthDay = 0;
        int birthHour = 0;
        int birthMinute = 0;

        birthYear = SafeInput.getInt(in, "Enter your birth year (e.g., 1990): ");
        birthMonth = SafeInput.getRangedInt(in, "Enter your birth month (1-12): ", 1, 12);
        birthDay = SafeInput.getRangedInt(in, "Enter your birth day (1-31): ", 1, 31);
        birthHour = SafeInput.getRangedInt(in, "Enter your birth hour (0-23): ", 0, 23);
        birthMinute = SafeInput.getRangedInt(in, "Enter your birth minute (0-59): ", 0, 59);

        System.out.println("You were born on " + birthYear + "-" + String.format("%02d", birthMonth) + "-" +
                String.format("%02d", birthDay) + " at " + String.format("%02d", birthHour) + ":" +
                String.format("%02d", birthMinute) + ".");
    }
}

