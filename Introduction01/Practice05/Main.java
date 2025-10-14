public class Main {
    public static void main(String[] args) {
        // インスタンスを作る
        MyThread t = new MyThread();
        // スレッドを起動する
        t.start();
        // 起動したスレッドを一時停止させる
        try {
            t.sleep(1000);
        } catch (InterruptedException e){
        }
    }
}
