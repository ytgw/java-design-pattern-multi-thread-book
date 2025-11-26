package content;


public class AsyncContentImpl implements Content {
    private byte[] contentBytes;
    private boolean isReady = false;

    public AsyncContentImpl(String urlstr) {
        new Thread() {
            public void run() {
                setBytes(new SyncContentImpl(urlstr).getBytes());
            }
        }.start();
    }

    public synchronized void setBytes(byte[] bytes) {
        if (isReady) {
            return;
        }
        contentBytes = bytes;
        isReady = true;
        notifyAll();
    }

    public synchronized byte[] getBytes() {
        if (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return contentBytes;
    }
}
