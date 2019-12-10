package lv.helloit;

public class Modifier {
    private int first = 1;
    private int second = 1;

    public void strike() {
        first += 1;
        second += 1;
    }

    public void spare() {
        first += 1;
    }

    public int getModifier() {
        int modifier = first;
        first = second;
        second = 1;
        return modifier;
    }
}
