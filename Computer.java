import java.util.Random;

public class Computer extends Player {
    public Computer(Board board, String[] playerNames, int playerIndex) {
        super(board, playerNames, playerIndex);
    }

    // @Override
    public int getPositionNum() {
        Random rand = new Random();
        return rand.nextInt(7) + 1;
    }
}
