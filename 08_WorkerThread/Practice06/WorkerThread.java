public class WorkerThread extends Thread {
    private final Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            while (true) {
                Request request = channel.takeRequest();
                request.execute();
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + ": END");
        }
    }
}
