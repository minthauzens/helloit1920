package chess.figures;

import chess.Figure;
import chess.Player;

public class Queen extends Figure {
    public Queen(Player color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == Player.WHITE){
            return '\u2655';
        }
        return '\u265B';

    }
}
