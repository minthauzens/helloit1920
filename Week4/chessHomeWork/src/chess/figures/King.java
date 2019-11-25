package chess.figures;

import chess.Figure;
import chess.PlayerColors;

public class King extends Figure {
    public King(PlayerColors color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == PlayerColors.WHITE){
            return '\u2654';
        }
        return '\u265A';

    }
}
