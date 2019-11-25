package chess;
import chess.figures.*;


class Board {

    private Figure[][] board;

    Board() {
        this.board = new Figure[8][8];
        fillBoard();
    }

    private void fillBoard() {
        // todo finish implementation;

        // PAWNS
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(PlayerColors.WHITE);
            board[6][i] = new Pawn(PlayerColors.BLACK);
        }
        // ROOKS
        board[0][0] = new Rook(PlayerColors.WHITE);
        board[0][7] = new Rook(PlayerColors.WHITE);
        board[7][0] = new Rook(PlayerColors.BLACK);
        board[7][7] = new Rook(PlayerColors.BLACK);

        // KNIGHTS
        board[0][1] = new Knight(PlayerColors.WHITE);
        board[0][6] = new Knight(PlayerColors.WHITE);
        board[7][1] = new Knight(PlayerColors.BLACK);
        board[7][6] = new Knight(PlayerColors.BLACK);

        // BISHOPS
        board[0][2] = new Bishop(PlayerColors.WHITE);
        board[0][5] = new Bishop(PlayerColors.WHITE);
        board[7][2] = new Bishop(PlayerColors.BLACK);
        board[7][5] = new Bishop(PlayerColors.BLACK);

        // QUEENS
        board[0][3] = new Queen(PlayerColors.WHITE);
        board[7][3] = new Queen(PlayerColors.BLACK);

        // KINGS
        board[0][4] = new King(PlayerColors.WHITE);
        board[7][4] = new King(PlayerColors.BLACK);

    }

    void print() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    System.out.print(String.format("%-2s", board[i][j]));
                } else {
                    // some random symbol
                    System.out.print(String.format("%-2s", '\u2609'));
                }
            }
            System.out.println();
        }
    }
}
