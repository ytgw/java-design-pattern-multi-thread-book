package activeobject;

import java.util.concurrent.Future;


public interface ActiveObject {
    public abstract Future<String> add(String x, String y);
    public abstract Future<String> makeString(int count, char fillChar);
    public abstract void displayString(String string);
    public abstract void shutdown();
}
