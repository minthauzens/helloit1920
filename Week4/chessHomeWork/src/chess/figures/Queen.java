package chess.figures;

import chess.Figure;
import chess.PlayerColors;

public class Queen extends Figure {
    public Queen(PlayerColors color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == PlayerColors.WHITE){
            return '\u2655';
        }
        return '\u265B';

    }
}
