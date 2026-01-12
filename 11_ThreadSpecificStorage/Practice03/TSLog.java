import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TSLog {
    private PrintWriter writer = null;

    // writerフィールドの初期化
    public TSLog(String fileName) {
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ログを書く
    public void println(String s) {
        writer.println(s);
    }

    // ログを閉じる
    public void close() {
        writer.println("=== End of log ===");
        writer.close();
    }
}
