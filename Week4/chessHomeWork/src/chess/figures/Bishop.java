package chess.figures;

import chess.Figure;
import chess.Player;

public class Bishop extends Figure {
    public Bishop(Player color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == Player.WHITE) {
            return '\u2657';
        }
        return '\u265D';
    }
}
