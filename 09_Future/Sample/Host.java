public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) FutureDataのインスタンスを作る
        final FutureData future = new FutureData();

        // (2) RealDataのインスタンスを作るための新しいスレッドを起動する
        new Thread() {
            public void run() {
                RealData realData = new RealData(count, c);
                future.setRealData(realData);
            }
        }.start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) FutureDataのインスタンスを戻り値とする
        return future;
    }
}
