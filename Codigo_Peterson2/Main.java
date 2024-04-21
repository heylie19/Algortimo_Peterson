public class Main {
    public static void main(String[] args) {
        Thread worker0 = new Thread(new Worker(0));
        Thread worker1 = new Thread(new Worker(1));
        worker0.start();
        worker1.start();
    }
}