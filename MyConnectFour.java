public class MyConnectFour {
	private Board board;
	private Input input;
	private char player1Symbol = 'r';
	private char player2Symbol = 'y';

	public MyConnectFour() {
		board = new Board(player1Symbol, player2Symbol);
		input = new Input();
		playGame();
	}

	private void playGame() {
		PrintHelper.displayFirstMsg();
		board.printBoard();
		boolean win = false;

		while (!win) {
			// player 1
			int userInput = input.getUserInput();
			board.placeCounter(true, userInput);
			boolean hasWon = board.check4Placement(player1Symbol);

			board.printBoard();
			if (hasWon) {
				win = true;
			} else {
				// player 2
				userInput = input.getUserInput();
				board.placeCounter(false, userInput);
				hasWon = board.check4Placement(player2Symbol);
				board.printBoard();
				if (hasWon) {
					win = true;
				}
			}
		}

		PrintHelper.displayWinMsg();
	}

}
