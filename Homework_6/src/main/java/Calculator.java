import java.util.LinkedList;
import java.util.List;

public class Calculator {
    List<Operation> operations;
    List<Integer> solutions;

    public Calculator()
    {
        operations = new LinkedList<>();
        solutions = new LinkedList<>();
    }

    public void addOperation(Operation operation)
    {
        operations.add(operation);
    }

    public void removeOperation(Operation operation)
    {
        operations.remove(operation);
    }

    public void runOperations()
    {
        for (Operation operation : operations)
        {
            solutions.add(operation.doOperation());
        }
    }

    public List<Integer> getSolutions() {
        return solutions;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "operations=" + operations +
                "\n" +
                "solutions=" + solutions +
                '}';
    }
}
