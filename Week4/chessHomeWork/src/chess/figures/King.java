package chess.figures;

import chess.Figure;
import chess.Player;

public class King extends Figure implements Comparable<King>{
    public King(Player color) {
        super(color);
    }

    @Override
    public char icon() {
        if (color == Player.WHITE){
            return '\u2654';
        }
        return '\u265A';

    }

    @Override
    public int compareTo(King o) {
        return 0;
    }
}
