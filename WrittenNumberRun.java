import java.util.Scanner;

// Main class to run the WrittenNumber Converter
public class WrittenNumberRun {

    public static void main(String[] args) {
        WrittenNumber wn = new WrittenNumber();
        int num = 0;
        boolean loop = true;
        Scanner keyboard = new Scanner(System.in);

        // Print the initial greeting message
        System.out.println("##############################");
        System.out.println("#  WRITTEN NUMBER CONVERTER  #");
        System.out.println("##############################");

        // Loop until the user decides to quit
        while (loop) {
            System.out.print("\nEnter a number Between 0 and 999,999 (0 to quit): ");
            num = keyboard.nextInt();

            // Validate the input range
            if (num < 0 || num > 999999) {
                System.out.println("Error: invalid number\nTRY AGAIN!!");
            } else {
                wn.setNumber(num);
                System.out.println("Your number is: " + wn.convertToString());
            }

            // Exit condition
            if (num == 0) {
                loop = false;
                System.out.println("\nGoodbye!");
            }
        }
        keyboard.close();
    }
}
