import java.util.Random;

public class Computer extends Player {
    public Computer(Board board, char mySymbol, boolean isPlayer1) {
        super(board, mySymbol, isPlayer1);
    }

    // @Override
    public int getInputNum() {
        Random rand = new Random();
        return rand.nextInt(7) + 1;
    }
}
