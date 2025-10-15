public class Pair {
    public final Tool leftHand;
    public final Tool rightHand;

    public Pair(Tool leftHand, Tool rightHand) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    public String toString() {
        return "[ " + leftHand + " and " + rightHand + " ]";
    }
}
