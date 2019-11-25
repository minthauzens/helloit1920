package chess.figures;

import chess.Figure;
import chess.PlayerColors;

public class Bishop extends Figure {
    public Bishop(PlayerColors color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == PlayerColors.WHITE) {
            return '\u2657';
        }
        return '\u265D';
    }
}
