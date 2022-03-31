import java.util.LinkedList;
import java.util.List;

public class Multiplication implements Operation {
    private List<Integer> numbers = new LinkedList<>();
    private int lastRes;
    private String name;

    public Multiplication(int... values)
    {
        for (int value : values)
        {
            numbers.add(value);
        }
    }

    @Override
    public int doOperation() {
        int res = 1;
        for (int value : numbers)
        {
            res *= value;
        }
        lastRes = res;
        return res;
    }

    public int getLastRes() {
        return lastRes;
    }

    @Override
    public String getName() {
        return name;
    }
}
