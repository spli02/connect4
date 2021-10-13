public class User extends Player {
    public User(Board board, char mySymbol, boolean isPlayer1) {
        super(board, mySymbol, isPlayer1);
    }

    // @Override
    public int getInputNum() {
        Input input = new Input();
        return input.getUserInput();
    }
}
