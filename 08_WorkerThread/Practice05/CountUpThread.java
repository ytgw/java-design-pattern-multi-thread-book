import javax.swing.JLabel;


public class CountUpThread extends Thread {
    private final JLabel label;

    public CountUpThread(JLabel label) {
        this.label = label;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":countUp:setText(" + i + ")");
                label.setText("" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
    }
}
