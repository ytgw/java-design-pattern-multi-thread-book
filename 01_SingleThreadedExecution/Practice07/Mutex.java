public class Mutex {
    private boolean isLocked = false;

    private synchronized boolean checkAndLock() {
        // 成功したら true を返す
        if (!isLocked) {
            isLocked = true;
            return true;
        }
        return false;
    }

    public void lock() {
        while (true) {
            if (checkAndLock()) {
                return;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void unlock() {
        isLocked = false;
    }
}
