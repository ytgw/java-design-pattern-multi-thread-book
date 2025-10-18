public class Main {
    public static void main(String[] args) {
        // インスタンス生成
        UserInfo userInfo = new UserInfo("Alice", "Alaska");

        // 表示
        System.out.println("userInfo = " + userInfo);

        // 状態を変更
        StringBuffer info = userInfo.getInfo();
        info.replace(12, 17, "Bobby");  // 12以上17未満がAliceの位置

        // 再度表示
        System.out.println("userInfo = " + userInfo);
    }
}
