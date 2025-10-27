public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(10);  // WorkerThreadの個数
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();

        // 一定時間立ったら終了する
        try {
            Thread.sleep(60_000);
        } catch (InterruptedException e) {
        }
        System.exit(0);
    }
}
