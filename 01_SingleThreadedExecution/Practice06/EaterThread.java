public class EaterThread extends Thread {
    private final String name;
    private final BothHandsTools aBothHandsTools;
    private final boolean shouldHoldTool1InLeftHand;;

    public EaterThread(String name, BothHandsTools aBothHandsTools, boolean shouldHoldTool1InLeftHand) {
        this.name = name;
        this.aBothHandsTools = aBothHandsTools;
        this.shouldHoldTool1InLeftHand = shouldHoldTool1InLeftHand;
    }

    public void run() {
        while (true) {
            eat();
        }
    }

    public void eat() {
        aBothHandsTools.use(name, shouldHoldTool1InLeftHand);
    }
}
