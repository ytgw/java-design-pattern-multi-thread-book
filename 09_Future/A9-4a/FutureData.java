import java.util.concurrent.ExecutionException;


public class FutureData implements Data {
    private RealData realData = null;
    private ExecutionException exception = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData) {
        if (ready) {
            return;  // balk
        }
        this.realData = realData;
        ready = true;
        notifyAll();
    }

    public synchronized void setException(Throwable throwable) {
        if (ready) {
            return;  // balk
        }
        this.exception = new ExecutionException(throwable);
        ready = true;
        notifyAll();
    }

    public synchronized String getContent() throws ExecutionException {
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
