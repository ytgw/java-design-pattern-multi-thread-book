public class Main {
    public static void main(String[] args) {
        System.out.println("Testing SecureGate...");
        for (int trial = 0; true; trial++) {
            SecureGate gate = new SecureGate();
            CheckerThread[] t = new CheckerThread[5];

            // CheckerThread起動
            for (int i = 0; i < t.length; i++) {
                t[i] = new CheckerThread(gate);
                t[i].start();
            }

            // CheckerThread終了待ち
            for (int i = 0; i < t.length; i++) {
                try {
                    t[i].join();
                } catch (InterruptedException e) {
                }
            }

            // 確認
            if (gate.getCounter() == 0) {
                System.out.print(".");
            } else {
                System.out.println("SecureGate is NOT safe!");
                System.out.println("getCounter() == " + gate.getCounter());
                System.out.println("trial = " + trial);
                break;
            }
        }
    }
}