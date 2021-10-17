public class PrintHelper {

    public static void displayFirstMsg() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
    }

    public static void displayWinMsg(String winnerName) {
        System.out.println(winnerName + " Have Won!!!");
    }

    public static void integerOnlyMsg() {
        System.out.println("Integers only, please.");
    }

    public static void displayTurnMsg(String playerName) {
        System.out.println("It's " + playerName + "'s turn.");
    }

    public static void displayErrorUnabledPut() {
        System.out.println("This row is full and unabled to put. Please try again.");
    }
}
