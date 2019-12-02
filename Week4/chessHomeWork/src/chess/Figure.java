package chess;

public abstract class Figure {
    public abstract char icon();
    protected Player color;

    public Figure(Player color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.valueOf(icon());
    }
}
