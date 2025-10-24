public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized (obj) {
            System.out.println("Step 3 (never reached here)");
        }
   }

   public static void magic(Object obj) {
        new Thread() {
            public void run() {
                synchronized (obj) {
                    while (true) {
                    }
                }
            }
        }.start();

        // 直近で起動したThreadに切り替えるためにスリープさせる。
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
   }
}
