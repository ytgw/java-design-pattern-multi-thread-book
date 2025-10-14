public class BankThread extends Thread {
    private Bank bank;
    public BankThread(Bank bank) {
        this.bank = bank;
    }
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            bank.withdraw(1);
            bank.deposit(1);
        }
    }
}
