import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public int getPositionInput() {
        int position = 0;
        try {
            position = scanner.nextInt();
        } catch (InputMismatchException exception) {
            PrintHelper.integerOnlyMsg();
            scanner.nextLine();
        }

        return position;
    }

    public int getConnectNInput() {
        int connectN = 0;
        PrintHelper.showConnectNumMsg();
        do {
            try {
                connectN = scanner.nextInt();
                if (connectN <= 2 || connectN >= 7) {
                    PrintHelper.showConnectNErrorMsg();
                }
            } catch (InputMismatchException exception) {
                PrintHelper.showConnectNErrorMsg();
                scanner.nextLine();
            }
        } while (connectN <= 2 || connectN >= 7);

        return connectN;
    }
}