import java.util.Scanner;

enum Cell {
    X, O, EMPTY
}

public class TicTacToe {
    private Cell[][] board;
    private Cell currentPlayer;

    public TicTacToe() {
        board = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Cell.EMPTY;
            }
        }
        currentPlayer = Cell.X;
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == Cell.EMPTY) {
            board[row][col] = currentPlayer;
            return true;
        } else {
            return false;
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == Cell.X) ? Cell.O : Cell.X;
    }

    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Cell.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.displayBoard();
        Scanner scanner = new Scanner(System.in);

        while (!game.checkWinner() && !game.isBoardFull()) {
            System.out.print("Enter the row (0, 1, or 2): ");
            int row = scanner.nextInt();
            System.out.print("Enter the column (0, 1, or 2): ");
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                game.displayBoard();
                if (game.checkWinner()) {
                    System.out.println("Player " + game.currentPlayer + " wins!");
                } else if (game.isBoardFull()) {
                    System.out.println("It's a draw!");
                } else {
                    game.switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }
}
