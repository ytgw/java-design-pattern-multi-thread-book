public class CheckerThread extends Thread {
    private final SecureGate gate;

    public CheckerThread(SecureGate gate) {
        this.gate = gate;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            gate.enter();
            gate.exit();
        }
    }
}