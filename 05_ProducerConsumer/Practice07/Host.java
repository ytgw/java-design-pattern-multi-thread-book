public class Host {
    public static void execute(int count) {
        for (int i = 0; i < count; i++) {
            doHeavyJob();
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " is interrupted.");
                break;
            }
        }
    }

    public static void doHeavyJob() {
        // 以下はキャンセル不可能な重い処理の代用
        System.out.println("doHeavyJob BEGIN");
        long start = System.currentTimeMillis();
        while (start + 1000 > System.currentTimeMillis()) {
            // busy loop
        }
        System.out.println("doHeavyJob END");
    }
}
