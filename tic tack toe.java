import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        char currentPlayer = 'X';
        boolean gameOver = false;

        // Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Game loop
        while (!gameOver) {
            // Display board
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            // Get player's move
            System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Make move if valid
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;

                // Check for win or draw
                if (checkWin(board, currentPlayer)) {
                    gameOver = true;
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (checkDraw(board)) {
                    gameOver = true;
                    System.out.println("It's a draw!");
                }

                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        scanner.close();
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true; // Row win
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true; // Column win
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true; // Diagonal win
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true; // Diagonal win
        return false;
    }

    public static boolean checkDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false; // If any cell is empty, game is not a draw
            }
        }
        return true; // No empty cells found, game is a draw
    }
}