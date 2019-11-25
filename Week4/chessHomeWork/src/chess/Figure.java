package chess;

public abstract class Figure {
    public abstract char icon();
    protected PlayerColors color;

    public Figure(PlayerColors color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.valueOf(icon());
    }
}
