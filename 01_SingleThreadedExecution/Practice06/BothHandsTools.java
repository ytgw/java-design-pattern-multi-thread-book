public class BothHandsTools {
    private final Tool tool1;
    private final Tool tool2;

    public BothHandsTools(Tool tool1, Tool tool2) {
        this.tool1 = tool1;
        this.tool2 = tool2;
    }

    public synchronized void use(String userName, boolean shouldHoldTool1InLeftHand) {
        Tool left, right;
        if (shouldHoldTool1InLeftHand) {
            left = tool1;
            right = tool2;
        } else {
            left = tool2;
            right = tool1;
        }

        System.out.println(userName + " takes up " + left + " (left).");
        System.out.println(userName + " takes up " + right + " (right).");
        System.out.println(userName + " is eating now, yum yum!");
        System.out.println(userName + " puts down " + right + " (right).");
        System.out.println(userName + " puts down " + left + " (left).");
    }
}
