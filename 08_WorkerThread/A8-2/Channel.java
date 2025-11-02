public class Channel {
    public Channel(int threads) {
    }

    public void startWorkers() {
    }

    public synchronized void putRequest(Request request) {
        new Thread() {
            public void run() {
                request.execute();
            }
        }.start();
    }
}
