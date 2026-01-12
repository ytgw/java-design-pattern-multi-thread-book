public class ClientThread extends Thread {
    public ClientThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + " BEGIN");
        Log.print();
        System.out.println(getName() + " END");
    }
}
