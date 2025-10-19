public class Main {
    public static void main(String[] args) {
        TestThread t = new TestThread();
        while (true) {
            t.start();
        }
    }
}
