package content;


public class AsyncContentImpl implements Content {
    private SyncContentImpl syncContent;
    private boolean ready = false;

    public synchronized void setContent(SyncContentImpl syncContent) {
        this.syncContent = syncContent;
        ready = true;
        notifyAll();
    }

    public synchronized byte[] getBytes() {
        if (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return syncContent.getBytes();
    }
}
