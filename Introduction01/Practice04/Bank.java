public class Bank {
    private int money;
    private String name;

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // 預金する
    public void deposit(int m) {
        money += m;
    }

    // 引き出す
    public boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            check();
            return true;  // 引き出せた
        } else {
            return false;  // 残高不足
        }
    }

    public String getName() {
        return name;
    }

    private void check() {
        if (money < 0) {
            System.out.println("預金残高がマイナスです! money = " + money);
        }
    }
}
