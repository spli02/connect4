abstract class Player {
    private Board board;
    private String[] playerName;
    private int playerIndex;

    public Player(Board board, String[] playerName, int playerIndex) {
        this.board = board;
        this.playerName = playerName;
        this.playerIndex = playerIndex;
    }

    public abstract int getPositionNum();

    public String getPlayerName() {
        return playerName[playerIndex];
    }

    public boolean isOutOfBoard(int position) {
        boolean isFullPosition = board.isFullColumn(position);
        // MEMO: only when player is human, the error msg will be displayed
        if (isFullPosition && playerIndex == 0) {
            PrintHelper.displayErrorUnabledPut();
        }

        return isFullPosition;
    }

    public void putPosition(Player player) {
        PrintHelper.displayTurnMsg(getPlayerName());

        boolean isNotFullColumn = true;
        // MEMO: check non-exsisting board position number at first
        int position = 9999;

        while (isNotFullColumn) {
            position = player.getPositionNum();
            isNotFullColumn = isOutOfBoard(position);
        }

        board.placeCounter(playerIndex, position);
        board.printBoard();
    }

    public boolean hasWinPosition() {
        return board.check4Placement(playerIndex);
    }
}