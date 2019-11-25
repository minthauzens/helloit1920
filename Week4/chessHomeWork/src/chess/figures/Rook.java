package chess.figures;

import chess.Figure;
import chess.PlayerColors;

public class Rook extends Figure {
    public Rook(PlayerColors color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == PlayerColors.WHITE){
            return '\u2656';
        }
        return '\u265C';

    }
}
