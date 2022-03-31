package pl.edu.agh.ooad;

public final class Exercise03GCD {

    public static int gcd(int a, int b) {
        if (b == 0)
        {
            throw new IllegalArgumentException("Can't divided by zero");
        }
        int temp = 0;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        if (a < 0)
        {
            return -a;
        }
        return a;
    }
}
