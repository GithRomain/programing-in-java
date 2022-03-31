package pl.edu.agh.ooad;

public final class Exercise04Fibonacci {
    
    public static int fibonacci(int n) {
        if (n < 0)
        {
            throw new IllegalArgumentException("Can't calculate fibonnacci number of a negative number");
        }

        int a = 0, b = 1;

        int counter = 0;

        // Iterate till counter is N
        while (counter < n) {

            int c = b + a;
            a = b;
            b = c;
            counter = counter + 1;
        }
        return a;
    }
}
