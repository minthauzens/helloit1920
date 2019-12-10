package lv.helloit;

public class Calculator {
    private int counter;

    public Calculator() {
        this.counter = 0;
    }

    public int add(int i1, int i2) {
        counter++;
        return i1 + i2;
    }

    public double divide(double f1, double f2) {
        counter++;
        return f1/f2;
    }

    public int getCounter() {
        return counter;
    }
}
