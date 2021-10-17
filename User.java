public class User extends Player {
    public User(Board board, String[] playerNames, int playerIndex) {
        super(board, playerNames, playerIndex);
    }

    // @Override
    public int getPositionNum() {
        Input input = new Input();
        return input.getUserInput();
    }
}