import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MiniServer {
    private final int portNumber;

    public MiniServer(int portNumber) {
        this.portNumber = portNumber;
    }

    public void execute() throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("Listening on " + serverSocket);
        try {
            while (true) {
                System.out.println("Accepting...");
                final Socket cilentSocket = serverSocket.accept();
                System.out.println("Connected to " + cilentSocket);
                executorService.execute(
                    new Runnable() {
                        public void run() {
                            try {
                                Service.service(cilentSocket);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}
