
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {
    // private BufferedReader input;
    private Scanner scanner;

    public Input() {
        // input = new BufferedReader(new InputStreamReader(System.in));
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