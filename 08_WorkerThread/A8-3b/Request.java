public class Request {
    private final String name;  // 依頼者
    private final int number;  // リクエストの番号

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
    }

    public String toString() {
        return "[ Request from " + name + " No." + number + " ]";
    }
}
