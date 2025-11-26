public class FutureData implements Data {
    private RealData realData = null;
    private Exception exception = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData) {
        if (ready) {
            return;  // balk
        }
        this.realData = realData;
        ready = true;
        notifyAll();
    }

    public synchronized void setException(Exception exception) {
        if (ready) {
            return;  // balk
        }
        this.exception = exception;
        ready = true;
        notifyAll();
    }

    public synchronized String getContent() throws Exception {
        if (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        if (exception != null) {
            throw exception;
        }

        return realData.getContent();
    }
}
