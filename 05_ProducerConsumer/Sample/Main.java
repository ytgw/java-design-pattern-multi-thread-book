public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);  // ケーキを3個までおけるテーブルを作る
        new MakerThread("Maker-1", table, 31415).start();
        new MakerThread("Maker-2", table, 92653).start();
        new MakerThread("Maker-3", table, 58979).start();
        new EaterThread("Eater-1", table, 32384).start();
        new EaterThread("Eater-2", table, 62643).start();
        new EaterThread("Eater-3", table, 38327).start();
    }
}
