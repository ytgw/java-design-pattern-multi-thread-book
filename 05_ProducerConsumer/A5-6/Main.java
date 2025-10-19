public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);  // ケーキを3個までおけるテーブルを作る
        Thread[] threads = {
            new MakerThread("Maker-1", table, 31415),
            new MakerThread("Maker-2", table, 92653),
            new MakerThread("Maker-3", table, 58979),
            new EaterThread("Eater-1", table, 32384),
            new EaterThread("Eater-2", table, 62643),
            new EaterThread("Eater-3", table, 38327)
        };

        // スレッドの起動
        for (Thread t : threads) {
            t.start();
        }

        // 約10秒休み
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
        }

        System.out.println("***** interrupt *****");

        // インタラプト
        for (Thread t : threads) {
            t.interrupt();
        }
    }
}
