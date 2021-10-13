public class MyConnectFour {
	private Board board;
	private User user;
	private Computer computer;
	private char player1Symbol = 'r';
	private char player2Symbol = 'y';

	public MyConnectFour() {
		board = new Board(player1Symbol, player2Symbol);
		user = new User(board, player1Symbol, true);
		computer = new Computer(board, player2Symbol, false);
		playGame();
	}

	private void playGame() {
		PrintHelper.displayFirstMsg();
		board.printBoard();
		boolean win = false;
		boolean hasWon;

		while (!win) {
			hasWon = user.getWon(user);
			if (hasWon) {
				win = true;
			} else {
				hasWon = computer.getWon(computer);
			}
		}

		PrintHelper.displayWinMsg();
	}

}
