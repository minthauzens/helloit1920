package chess.figures;

import chess.Figure;
import chess.Player;

public class Knight extends Figure {
    public Knight(Player color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == Player.WHITE){
            return '\u2658';
        }
        return '\u265E';
    }
}
