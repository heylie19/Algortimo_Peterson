public class Main {
    public static void main(String[] args) {
        Peterson peterson = new Peterson();
        Thread process0 = new Thread(new Process(peterson, 0));
        Thread process1 = new Thread(new Process(peterson, 1));
        process0.start();
        process1.start();
    }
}
