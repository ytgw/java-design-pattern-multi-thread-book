package activeobject;

import java.math.BigInteger;


class Servant implements ActiveObject {
    public Result<String> add(String x, String y) {
        BigInteger xInt = new BigInteger(x);
        BigInteger yInt = new BigInteger(y);
        BigInteger sum = xInt.add(yInt);
        String result = sum.toString();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return new RealResult<String>(result);
    }

    public Result<String> makeString(int count, char fillChar) {
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = fillChar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        return new RealResult<String>(new String(buffer));
    }

    public void displayString(String string) {
        try {
            System.out.println("displayString: " + string);
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }
}
