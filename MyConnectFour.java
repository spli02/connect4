public class MyConnectFour {
	private Board board;
	private User user;
	private Computer computer;
	private String[] playerNames = { "User1", "Computer1" };
	private char[] playerSymbols = { 'r', 'y' };

	public MyConnectFour() {
		board = new Board(playerSymbols);
		user = new User(board, playerNames, 0);
		computer = new Computer(board, playerNames, 1);
		playGame();
	}

	private void playGame() {
		PrintHelper.displayFirstMsg();
		board.printBoard();
		String winnerName = "";
		Player[] playerTurnOrder = { user, computer };

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