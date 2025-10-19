import java.util.LinkedList;
import java.util.Queue;


public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() throws LivenessException {
        while (queue.peek() == null) {
            try {
                wait(3_000);
            } catch (InterruptedException e) {
            }
            if (queue.peek() == null) {
                throw new LivenessException("No request for 3 seconds.");
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
