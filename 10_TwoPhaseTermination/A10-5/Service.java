public class Service {
    private static GracefulThread thread = null;

    // サービス実行開始(実行中ならbalkする)
    public synchronized static void service() {
        System.out.print("service");
        if (thread != null && thread.isAlive()) {
            // Balking
            System.out.print(" is balked.");
            return;
        }

        // Threa-Per-Message
        thread = new ServiceThread();
        thread.start();
    }

    // サービス中止
    public synchronized static void cancel() {
        if (thread != null) {
            System.out.println("cancel.");
            thread.shutdownRequest();
        }
    }
}
