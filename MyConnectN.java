public class MyConnectN {
	private Board board;
	private User user;
	private Input input;
	private Computer computerOne;
	private Computer computerTwo;
	private String[] playerNames = { "Player1", "Computer1", "Computer2" };
	private char[] playerSymbols = { 'r', 'y', 'b' };

	public MyConnectN() {
		input = new Input();
		playGame();
	}

	private void prepareGame(int connectN) {
		board = new Board(playerSymbols, connectN);
		user = new User(board, playerNames, 0);
		computerOne = new Computer(board, playerNames, 1);
		computerTwo = new Computer(board, playerNames, 2);
	}

	private void playGame() {
		PrintHelper.showFirstMsg();
		int connectN = input.getConnectNInput();
		prepareGame(connectN);
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

		PrintHelper.showWinMsg(winnerName);
	}
}
