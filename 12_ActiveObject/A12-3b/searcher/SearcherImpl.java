package searcher;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class SearcherImpl implements Searcher {
    private final ExecutorService service = Executors.newSingleThreadExecutor();

    public void shutdown() {
        service.shutdown();
    }

    public void search(String word, Display display) {
        class SearchRequest implements Runnable {
            public void run() {
                System.out.print("search(" + word + ")");
                for (int i = 0; i < 50; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("found.");
                String url = "http://somewhere/" + word + ".html";  // dummy URL
                display.display("word = " + word + ", URL = " + url);
            }
        }
        service.execute(new SearchRequest());
    }
}
