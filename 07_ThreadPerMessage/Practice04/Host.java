public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new HelperThread(helper, count, c).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}


class HelperThread extends Thread {
    private final Helper helper;
    private int count;
    private char c;

    public HelperThread(Helper helper, int count, char c) {
        this.helper = helper;
        this.count = count;
        this.c = c;
    }

    public void run() {
        helper.handle(count, c);
    }
}
