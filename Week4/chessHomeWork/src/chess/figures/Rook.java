package chess.figures;

import chess.Figure;
import chess.Player;

public class Rook extends Figure {
    public Rook(Player color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == Player.WHITE){
            return '\u2656';
        }
        return '\u265C';

    }
}
