public class ThreadExample extends Thread {
    public int i = 0;

    @Override
    public void run() {
        while (i < 100) {
            System.out.println(i + " " + this.getName());
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
