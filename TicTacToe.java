import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWinningMove(int row, int col) {
        // Check row
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return true;
        }

        // Check column
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return true;
        }

        // Check diagonal
        if ((row == col || row + col == 2) &&
                ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                        (board[0][2] == board[1][1] && board[1][1] == board[2][0]))) {
            return true;
        }

        return false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-') {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            printBoard();

            if (isWinningMove(row, col)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It's a tie!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
