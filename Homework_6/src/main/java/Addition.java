import java.util.LinkedList;
import java.util.List;

public class Addition implements Operation {
    private List<Integer> numbers = new LinkedList<>();
    private int lastRes;
    private String name;

    public Addition(int... values)
    {
        for (int value : values)
        {
            numbers.add(value);
        }
    }

    @Override
    public int doOperation() {
        int res = 0;
        for (int value : numbers)
        {
            res += value;
        }
        lastRes = res;
        return res;
    }

    @Override
    public int getLastRes() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
