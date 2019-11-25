package chess.figures;

import chess.Figure;
import chess.PlayerColors;

public class Pawn extends Figure {

    public Pawn(PlayerColors color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == PlayerColors.WHITE) {
            return '\u2659';
        }
        return '\u265F';
    }
}
