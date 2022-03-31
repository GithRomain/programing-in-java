import java.util.LinkedList;
import java.util.List;

public class Substraction implements Operation {
    private List<Integer> numbers = new LinkedList<>();
    private int lastRes;
    private String name;

    public Substraction(int... values)
    {
        for (int value : values)
        {
            numbers.add(value);
        }
    }

    @Override
    public int doOperation() {
        int res = numbers.get(0);
        for (int value : numbers.subList(1, numbers.size()))
        {
            res -= value;
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
