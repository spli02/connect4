public class MyConnectFour {
	private Board board;
	private User user;
	private Computer computerOne;
	private Computer computerTwo;
	private String[] playerNames = { "Player1", "Computer1", "Computer2" };
	private char[] playerSymbols = { 'r', 'y', 'b' };

	public MyConnectFour() {
		board = new Board(playerSymbols);
		user = new User(board, playerNames, 0);
		computerOne = new Computer(board, playerNames, 1);
		computerTwo = new Computer(board, playerNames, 2);
		playGame();
	}

	private void playGame() {
		PrintHelper.displayFirstMsg();
		board.printBoard();
		String winnerName = "";
		Player[] playerTurnOrder = { user, computerOne, computerTwo };

		while (winnerName == "") {
			for (Player player : playerTurnOrder) {
				player.putPosition(player);
				if (player.hasWinPosition()) {
					winnerName = player.getPlayerName();
					break;
				}
			}
		}

		PrintHelper.displayWinMsg(winnerName);
	}
}
