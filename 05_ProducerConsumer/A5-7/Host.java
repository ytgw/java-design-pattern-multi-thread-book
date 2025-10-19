public class Host {
    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            doHeavyJob();
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
