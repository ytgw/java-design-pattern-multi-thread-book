import java.util.LinkedList;
import java.util.Queue;


public class RequestQueue {
    private final long TIMEOUT = 3000L;
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() throws LivenessException {
        long startTime = System.currentTimeMillis();  // 開始時刻
        while (queue.peek() == null) {
            long now = System.currentTimeMillis();  // 現在時刻
            long rest = TIMEOUT - (now - startTime);  // 残りの待ち時間
            if (rest <= 0) {
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
            }
            try {
                wait(rest);
            } catch (InterruptedException e) {
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
