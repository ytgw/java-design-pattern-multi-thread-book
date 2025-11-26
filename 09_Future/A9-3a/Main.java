import content.Retriever;
import content.Content;

import java.io.IOException;
import java.io.FileOutputStream;


public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Content content1 = Retriever.retrieve("https://www.youtube.com/");
        Content content2 = Retriever.retrieve("https://www.google.com/");
        Content content3 = Retriever.retrieve("https://www.hyuki.com/");

        saveToFile("youtube.html", content1);
        saveToFile("google.html", content2);
        saveToFile("hyuki.html", content3);

        long end = System.currentTimeMillis();

        System.out.println("Elapsed time = " + (end - start) + "msec.");
    }

    // filenameという名前のファイルにcontentの中身を書き出す
    private static void saveToFile(String filename, Content content) {
        byte[] bytes = content.getBytes();
        try {
            System.out.println(Thread.currentThread().getName() + ": Saving to " + filename);
            FileOutputStream out = new FileOutputStream(filename);
            for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
