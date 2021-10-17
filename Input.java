import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public int getUserInput() {
        int toReturn = 0;
        try {
            toReturn = scanner.nextInt();
        } catch (InputMismatchException exception) {
            PrintHelper.integerOnlyMsg();
            scanner.nextLine();
        }

        return toReturn;
    }
}