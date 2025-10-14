public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("test", 1);
        for (int i = 0; i < 10; i++) {
            new BankThread(bank).start();
        }
    }
}
