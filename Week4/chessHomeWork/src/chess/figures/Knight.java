package chess.figures;

import chess.Figure;
import chess.PlayerColors;

public class Knight extends Figure {
    public Knight(PlayerColors color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == PlayerColors.WHITE){
            return '\u2658';
        }
        return '\u265E';
    }
}
