import java.util.Scanner;

public class DevTest {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);
/*
        //test getNonZeroLenString
        String name = SafeInput.getNonZeroLenString(in, "Enter your name");
        System.out.println("Hello, " + name + "!");

        //2nd test for library
        name = SafeInput.getNonZeroLenString(in, "Enter your name");
        System.out.println("Hello, " + name + "!");

        //test getInt
        int age = SafeInput.getInt(in, "Enter your age");
        System.out.println("You are " + age + " years old.");

        //test getDouble
        double salary = SafeInput.getDouble(in, "Enter your salary");
        System.out.println("Your salary is " + salary);

        //test getRangedInt
        int grade = SafeInput.getRangedInt(in, "Enter your grade", 0, 100);
        System.out.println("Your grade is " + grade);

        //test getRangedDouble
        double price = SafeInput.getRangedDouble(in, "Enter the price of the item", 0.50, 10.00);
        System.out.println("The price of the item is " + price);

        //test getYNConfirm
        boolean cont = SafeInput.getYNConfirm(in, "Do you want to continue?");
        System.out.println("You chose to " + (cont ? "continue" : "not continue") + ".");
*/
        //test getRegExString
        String email = getRegExString(in, "Enter your email", "^\\w+@\\w+\\.\\w+$");
        System.out.println("Your email is " + email);
/*
        //test getPrettyHeader
        String header = getPrettyHeader("Welcome to the Program");
        System.out.println(header);
*/
    }

    /**
     * getNonZeroLenString - keeps prompting the user until they enter a non-zero length string
     *
     * @param pipe   Scanner to use for input
     * @param prompt String to use as prompt
     * @return String that is guaranteed to be non-zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print(prompt);
            retString = pipe.nextLine();
            if (retString.isEmpty()) {
                return retString;
            }
            System.out.println("You must enter at least one character. Please try again.");
        } while (retString.isEmpty());

        return retString;
    }

    /**
     * getInt - keeps prompting the user until they enter a valid integer
     *
     * @param pipe   Scanner to use for input
     * @param prompt String to use as prompt
     * @return int that is guaranteed to be a valid integer
     */

    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.println(prompt);
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer. You entered: " + trash);
            }
        } while (!done);
        return retInt;
    }

    /**
     * getInt - keeps prompting the user until they enter a valid integer
     *
     * @param pipe   Scanner to use for input
     * @param prompt String to use as prompt
     * @return int that is guaranteed to be a valid integer
     */

    public static Double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.println(prompt);
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear the buffer
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer. You entered: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * getRangedInt - keeps prompting the user until they enter a valid integer within a specified range
     *
     * @param pipe   Scanner to use for input
     * @param prompt String to use as prompt
     * @param low    int that is the lowest acceptable value
     * @param high   int that is the highest acceptable value
     * @return int that is guaranteed to be a valid integer within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.println(prompt + " [" + low + " - " + high + "]");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                if (retInt < low && retInt > high) {
                    System.out.println("You must enter an integer in the range [" + low + " - " + high + "]. You entered: " + retInt);
                } else {
                    done = true;
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer. You entered: " + trash);
            }
        }
        while (!done);
        return retInt;
    }

    /**
     * getRangedDouble - keeps prompting the user until they enter a valid double within a specified range
     *
     * @param pipe   Scanner to use for input
     * @param prompt String to use as prompt
     * @param low    double that is the lowest acceptable value
     * @param high   double that is the highest acceptable value
     * @return double that is guaranteed to be a valid double within the specified range
     */

    public static int getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.println(prompt + " [" + low + " - " + high + "]");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear the buffer
                if (retVal < low && retVal > high) {
                    System.out.println("You must enter a double in the range [" + low + " - " + high + "]. You entered: " + retVal);
                } else {
                    done = true;
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double. You entered: " + trash);
            }
        }
        while (!done);
        return (int) retVal;
    }

    /**
     * getYNConfirm - keeps prompting the user until they enter Y or N
     *
     * @param pipe   Scanner to use for input
     * @param prompt String to use as prompt
     * @return boolean that is true for Y and false for N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean retVal = false;
        boolean done = false;
        do {
            System.out.println(prompt + " [Y/N]");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (response.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("You must enter Y or N. You entered: " + response);
            }
        } while (!done);
        return retVal;
    }

    /**
     * getRegExString - keeps prompting the user until they enter a string that matches the specified regular expression
     *
     * @param pipe   Scanner to use for input
     * @param prompt String to use as prompt
     * @param regEx  String that is the regular expression to match
     * @return String that is guaranteed to match the specified regular expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retString = "";
        boolean done = false;
        do {
            System.out.println(prompt + " (must match regex: " + regEx + ")");
            retString = pipe.nextLine();
            if (retString.matches(regEx)) {
                done = true;
            } else {
                System.out.println("You must enter a string that matches the regular expression: " + regEx + ". You entered: " + retString);
            }
        } while (!done);

        return retString;
    }

    public static String getPrettyHeader(String msg) {
        final int WIDTH = 60;
        final int SIDE_STARS = 3;
        final int INNER_WIDTH = WIDTH - (SIDE_STARS * 2); // 54

        if (msg == null) msg = "";
        if (msg.length() > INNER_WIDTH) {
            msg = msg.substring(0, INNER_WIDTH);
        }

        // top line of stars
        for (int i = 0; i < WIDTH; i++) {
            System.out.print('*');
        }
        System.out.println();

        // middle line: 3 stars, left padding, message, right padding, 3 stars
        for (int i = 0; i < SIDE_STARS; i++) System.out.print('*');

        int leftPadding = (INNER_WIDTH - msg.length()) / 2;
        int rightPadding = INNER_WIDTH - msg.length() - leftPadding;

        for (int i = 0; i < leftPadding; i++) System.out.print(' ');
        System.out.print(msg);
        for (int i = 0; i < rightPadding; i++) System.out.print(' ');

        for (int i = 0; i < SIDE_STARS; i++) System.out.print('*');
        System.out.println();

        // bottom line of stars
        for (int i = 0; i < WIDTH; i++) {
            System.out.print('*');
        }
        System.out.println();
        return "";
    }
}
