public class Main {
    public static void main(String[] args) {
        HostExecutorThread hostExecutorThread = new HostExecutorThread();
        hostExecutorThread.start();

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
        }
        hostExecutorThread.interrupt();
    }
}


public class HostExecutorThread extends Thread{
    public HostExecutorThread() {
        super("HostExecutorThread");
    }

    public void run(){
        Host.execute(10);
    }
}
