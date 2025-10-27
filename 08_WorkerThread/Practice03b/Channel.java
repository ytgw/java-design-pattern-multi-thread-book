public class Channel {
    public void putRequest(Request request) {
        new Thread() {
            public void run() {
                request.execute();
            }
        }.start();
    }
}
