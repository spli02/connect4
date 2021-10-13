abstract class Player {
    private Board board;
    private char mySymbol;
    private boolean isPlayer1;

    public Player(Board board, char mySymbol, boolean isPlayer1) {
        this.board = board;
        this.mySymbol = mySymbol;
        this.isPlayer1 = isPlayer1;
    }

    public abstract int getInputNum();

    public boolean isOutOfBoard(int position) {
        boolean isFullPosition = board.isFullColumn(position);
        if (isFullPosition && isPlayer1) {
            PrintHelper.displayErrorUnabledPut();
        }

        return isFullPosition;
    }

    public boolean getWon(Player player) {
        PrintHelper.showTurnMsg(isPlayer1 ? "Player1" : "Computer");

        boolean isNotFullColumn = true;
        int position = 9999;

        while (isNotFullColumn) {
            position = player.getInputNum();
            isNotFullColumn = isOutOfBoard(position);
        }

        board.placeCounter(isPlayer1, position);
        board.printBoard();

        return board.check4Placement(mySymbol);
    }
}