public class Service {
    private static ServiceThread serviceThread = new ServiceThread();
    private static boolean isStarted = false;

    // サービス実行開始
    public static void service() {
        // 複数回でスレッドをstartさせると例外が発生するため、その対策としてキャンセルとスレッドの再作成を行う
        if (isStarted) {
            serviceThread.cancel();
            serviceThread = new ServiceThread();
        }
        serviceThread.start();
        isStarted = true;
    }

    // サービス中止
    public static void cancel() {
        serviceThread.cancel();
    }
}
