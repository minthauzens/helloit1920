package chess;

public class ChessGame {

    public static void main(String[] args) {
        // RUN GAME
        Board board = new Board();
        board.print();
        for (int i = 0; i < 3; i++) {
            board.move();
            board.print();
        }
    }
}
