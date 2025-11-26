public class FutureData implements Data {
    private RealData realData = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData) {
        if (ready) {
            return;  // balk
        }
        this.realData = realData;
        ready = true;
        notifyAll();
    }

    public synchronized String getContent() {
        if (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        return realData.getContent();
    }
}
