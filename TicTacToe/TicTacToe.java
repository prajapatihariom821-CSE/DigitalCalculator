import java.util.Scanner;
public class TicTacToe {
    private static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        for (int turn = 0; turn < 9; turn++) {
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            if (!makeMove(move)) {
                System.out.println("Invalid move! Try again.");
                turn--;
                continue;
            }

            printBoard();

            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';  //ternary operator
        }

        if (!gameWon) {
            System.out.println("It's a draw!"); 
        }

        scanner.close();
    }

    private static void printBoard() {     //for board print
        for (char[] row : board) {  //enhanced for loop 
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static boolean makeMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;

        if (move < 1 || move > 9 || board[row][col] == 'X' || board[row][col] == 'O') {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    private static boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }
}