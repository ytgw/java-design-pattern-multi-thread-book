package activeobject;


public interface ActiveObject {
    public abstract Result<String> add(String x, String y);
    public abstract Result<String> makeString(int count, char fillChar);
    public abstract void displayString(String string);
}
