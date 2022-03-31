package pl.edu.agh.ooad;

public final class Exercise05Change {
    
    public final static int[] NOMINAL_VALUES = new int[]{50, 20, 10, 5, 2, 1};
    
    public static int[] countChanges(int amount) {

        if (amount < 0)
        {
            throw new IllegalArgumentException("Can't calculate change of a negative number");
        }

        int[] result = new int[NOMINAL_VALUES.length];
        int count;
        int rest;
        int cpt = 0;

        for(int val : NOMINAL_VALUES)
        {
            count = amount / val;
            rest = amount - count * val;

            result[cpt] = count;

            cpt++;
            amount = rest;
        }
        return result;
    }
    
}
