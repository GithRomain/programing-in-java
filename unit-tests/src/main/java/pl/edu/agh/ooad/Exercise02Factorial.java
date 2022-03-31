package pl.edu.agh.ooad;

public final class Exercise02Factorial {
    
    public static int factorial(int x) {
        if (x < 0)
        {
            throw new IllegalArgumentException("negative value can't be factorized");
        }
        if(x == 0)
        {
            return 1;
        }
        else
        {
            return x * factorial(x-1);
        }
    }
}
