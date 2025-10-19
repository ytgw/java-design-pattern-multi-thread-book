import java.util.concurrent.TimeUnit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class RequestQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

    public Request getRequest() throws LivenessException {
        Request request = null;
        try {
            request = queue.poll(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }

        if (request == null) {
            throw new LivenessException("thrown by " + Thread.currentThread().getName());
        }
        return request;
    }

    public void putRequest(Request request) throws LivenessException{
        try {
            boolean isOffered = queue.offer(request, 3L, TimeUnit.SECONDS);
            if (!isOffered) {
                throw new LivenessException("thrown by " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
        }
    }
}
