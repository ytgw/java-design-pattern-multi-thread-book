import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class RequestQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

    public Request getRequest() throws LivenessException {
        Request request = null;
        try {
            request = queue.poll(3, java.util.concurrent.TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }

        if (request == null) {
            throw new LivenessException("No request for 3 seconds.");
        }
        return request;
    }

    public void putRequest(Request request) throws LivenessException{
        try {
            boolean isOffered = queue.offer(request, 3, java.util.concurrent.TimeUnit.SECONDS);
            if (!isOffered) {
                throw new LivenessException("Cannot offer request for 3 seconds.");
            }
        } catch (InterruptedException e) {
        }
    }
}
