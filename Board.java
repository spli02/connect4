public class Board {
    private char[][] board;
    private char[] playerSymbols;

    public Board(char[] playerSymbols) {
        board = new char[6][7];
        this.playerSymbols = playerSymbols;
    }

    private char hasPositionSymbol(char positionSymbol) {
        char symbol = ' ';
        for (char playerSymbol : playerSymbols) {
            if (playerSymbol == positionSymbol) {
                symbol = playerSymbol;
            }
        }

        return symbol;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char symbol = hasPositionSymbol(board[i][j]);
                if (symbol != ' ') {
                    System.out.print("| " + symbol + " ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    private boolean hasOpponentSymbol(char positionSymbol, char mySymbol) {
        boolean hasOpponentSymbol = false;
        for (char symbol : playerSymbols) {
            if (symbol == positionSymbol && symbol != mySymbol) {
                hasOpponentSymbol = true;
            }
        }

        return hasOpponentSymbol;
    }

    public void placeCounter(int playerIndex, int position) {
        boolean placed = false;
        char mySymbol = playerSymbols[playerIndex];

        for (int i = board.length - 1; i >= 0; i--) {
            if (!placed) {
                char checkPositionSymbol = board[i][position - 1];
                if (hasOpponentSymbol(checkPositionSymbol, mySymbol)) {
                    // skip
                } else if (checkPositionSymbol != mySymbol) {
                    board[i][position - 1] = mySymbol;
                    placed = true;
                }
            }
        }
    }

    public boolean checkHorizontal(char symbol) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == symbol) {
                    count = count + 1;
                    if (count >= 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        return false;
    }

    public boolean checkVertical(char symbol) {
        int count = 0;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == symbol) {
                    count = count + 1;
                    if (count >= 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        return false;
    }

    public boolean checkDiagonal(char symbol, boolean isRightDiagonal) {
        int count = 0;
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[0].length - 1; j++) {
                count = 0;
                for (int offset = 0; offset < 4; offset++) {
                    int row = i + offset;
                    int col = isRightDiagonal ? j - offset : j + offset;

                    if (row < 0 || row > board.length - 1) {
                        break;
                    }
                    if (col < 0 || col > board[0].length - 1) {
                        break;
                    }

                    if (board[row][col] == symbol) {
                        count++;

                        if (count >= 4) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean check4Placement(int playerIndex) {
        char playerSymbol = playerSymbols[playerIndex];
        return checkHorizontal(playerSymbol) || checkVertical(playerSymbol) || checkDiagonal(playerSymbol, true)
                || checkDiagonal(playerSymbol, false);
    }

    public boolean isFullColumn(int position) {
        char boardValue = board[0][position - 1];
        for (char symbol : playerSymbols) {
            if (boardValue == symbol) {
                return true;
            }
        }
        return false;
    }
}