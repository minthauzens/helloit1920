package chess.figures;

import chess.Figure;
import chess.Player;

public class Pawn extends Figure {

    public Pawn(Player color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == Player.WHITE) {
            return '\u2659';
        }
        return '\u265F';
    }
}
