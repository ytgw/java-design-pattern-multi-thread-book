public class ServiceThread extends Thread {
    // 終了要求が出されたらtrue
    private volatile boolean shutdownRequested = false;

    // サービス中止
    public void cancel() {
        System.out.println("cancel.");
        shutdownRequested = true;
        interrupt();
    }

    // 終了要求が出されたかどうかのテスト
    private boolean isShutdownRequested() {
        return shutdownRequested;
    }

    // サービス実行開始
    public void run() {
        System.out.print("service");
        try {
            for (int i = 0; i < 50; i++) {
                while (!isShutdownRequested()) {
                    break;
                }
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    private void doWork() throws InterruptedException {
        System.out.print(".");
        Thread.sleep(100);
    }

    // 終了処理
    private void doShutdown() {
        System.out.println("done.");
    }
}
