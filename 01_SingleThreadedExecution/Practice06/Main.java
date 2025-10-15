public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit.");
        BothHandsTools aBothHandsTools = new BothHandsTools(new Tool("Spoon"), new Tool("Fork"));
        new EaterThread("Alice", aBothHandsTools, true).start();
        new EaterThread("Bobby", aBothHandsTools, false).start();
    }
}
