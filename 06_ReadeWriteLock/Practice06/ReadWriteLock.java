public final class ReadWriteLock {
    private int readingReaders = 0;  // (a)...実際に読んでいる最中のスレッドの数
    private int writingWriters = 0;  // (b)...実際に書いている最中のスレッドの数

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0) {
            wait();
        }
        readingReaders++;  // (a)
    }

    public synchronized void readUnlock() {
        readingReaders--; // (a)
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        while (readingReaders > 0 || writingWriters > 0) {
            wait();
        }
        writingWriters++;  // (b)
    }

    public synchronized void writeUnlock() {
        writingWriters--;  // (b)
        notifyAll();
    }
}
