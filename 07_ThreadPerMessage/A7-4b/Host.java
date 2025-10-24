public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new HelperThread(count, c).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }

    // Inner class
    public class Helper {
        public void handle(int count, char c) {
            System.out.println("        handle(" + count + ", " + c + ") BEGIN");
            for (int i = 0; i < count; i++) {
                slowly();
                System.out.print(c);
            }
            System.out.println("");
            System.out.println("        handle(" + count + ", " + c + ") END");
        }

        public void slowly() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    // Inner class
    public class HelperThread extends Thread {
        private final int count;
        private final char c;

        public HelperThread(int count, char c) {
            this.count = count;
            this.c = c;
        }

        public void run() {
            helper.handle(count, c);
        }
    }
}
