public class Main {
    public static void main(String[] args) {
        ThreadExample te1 = new ThreadExample();
        ThreadExample te2 = new ThreadExample();

        te1.setName("Thread 1");
        te2.setName("Thread 2");

        te1.start();
        te2.start();
    }
}
