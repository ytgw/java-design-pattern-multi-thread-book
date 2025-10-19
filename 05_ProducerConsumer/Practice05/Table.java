public class Table {
    private final String[] buffer;
    private int tail;  // 次にputする場所
    private int head;  // 次にtakeする場所
    private int count;  // buffer内のケーキ数

    public Table(int count) {
        this.buffer = new String[count];
        this.tail = 0;
        this.head = 0;
        this.count = 0;
    }

    // ケーキを置く
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    // ケーキを取る
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        notifyAll();
        return cake;
    }

    // ケーキを全部取り除く
    public synchronized void clear() {
        tail = 0;
        head = 0;
        count = 0;
        notifyAll();
    }
}
