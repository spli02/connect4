public class Board {
    private char[][] board;
    private char player1Symbol;
    private char player2Symbol;

    public Board(char player1Symbol, char player2Symbol) {
        board = new char[6][7];
        this.player1Symbol = player1Symbol;
        this.player2Symbol = player2Symbol;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player1Symbol) {
                    System.out.print("| " + player1Symbol + " ");
                } else if (board[i][j] == player2Symbol) {
                    System.out.print("| " + player2Symbol + " ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public void placeCounter(boolean isPlayer1, int position) {
        boolean placed = false;
        char mySymbol = isPlayer1 ? player1Symbol : player2Symbol;
        char opponentSymbol = isPlayer1 ? player2Symbol : player1Symbol;

        for (int i = board.length - 1; i >= 0; i--) {
            if (!placed) {
                if (board[i][position - 1] == opponentSymbol) {
                    // skip
                } else if (board[i][position - 1] != mySymbol) {
                    board[i][position - 1] = mySymbol;
                    placed = true;
                }
            }
        }
    }

    public boolean checkHorizontal(char symbol) {
        boolean hasWon = false;
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == symbol) {
                    count = count + 1;
                    if (count >= 4) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }

        }

        return hasWon;
    }

    public boolean checkVertical(char symbol) {
        boolean hasWon = false;
        int count = 0;

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == symbol) {
                    count = count + 1;
                    if (count >= 4) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        return hasWon;
    }

    public boolean check4Placement(char symbol) {
        return checkHorizontal(symbol) || checkVertical(symbol);
    }
}
