public class PrintHelper {

    public static void showFirstMsg() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 3 players red, yellow and blue");
        System.out.println("Player1 is Red, Computer1 is Yellow, Computer2 is blue");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
    }

    public static void showConnectNumMsg() {
        System.out.println("Please enter the number you want to connect to win. (2 < N < 7)");
    }

    public static void showConnectNErrorMsg() {
        System.out.println("Please enter the number more than 2 and less than 7.");
    }

    public static void showWinMsg(String winnerName) {
        System.out.println(winnerName + " Have Won!!!");
    }

    public static void integerOnlyMsg() {
        System.out.println("Integers only, please.");
    }

    public static void showTurnMsg(String playerName) {
        System.out.println("It's " + playerName + "'s turn.");
    }

    public static void showErrorUnabledPut() {
        System.out.println("This row is full and unabled to put. Please try again.");
    }
}
