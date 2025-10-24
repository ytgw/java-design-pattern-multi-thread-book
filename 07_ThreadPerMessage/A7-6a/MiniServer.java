import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;


public class MiniServer {
    private final int portNumber;

    public MiniServer(int portNumber) {
        this.portNumber = portNumber;
    }

    public void execute() throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Listening on " + serverSocket);
        try {
            while (true) {
                System.out.println("Accepting...");
                final Socket cilentSocket = serverSocket.accept();
                System.out.println("Connected to " + cilentSocket);
                new Thread() {
                    public void run() {
                        try {
                            Service.service(cilentSocket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}
