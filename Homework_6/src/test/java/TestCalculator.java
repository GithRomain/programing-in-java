import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.print.attribute.SupportedValuesAttribute;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCalculator {
    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Test addition")
    public void testAddition() {
        //Given
        Operation operation_deleted = new Addition(4, 4);
        calculator.addOperation(new Addition(1));
        calculator.addOperation(new Addition(4, 0));
        calculator.addOperation(new Addition(1, 6, 2));
        calculator.addOperation(operation_deleted);
        calculator.removeOperation(operation_deleted);

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(4);
        expected.add(9);

        //When
        calculator.runOperations();
        List<Integer> tested = calculator.getSolutions();

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test substraction")
    public void testSubstraction() {
        //Given
        Operation operation_deleted = new Substraction(7, 2);
        calculator.addOperation(new Substraction(5));
        calculator.addOperation(new Substraction(4,6));
        calculator.addOperation(operation_deleted);
        calculator.addOperation(new Substraction(9, 1, 1));
        calculator.removeOperation(operation_deleted);

        List<Integer> expected = new LinkedList<>();
        expected.add(5);
        expected.add(-2);
        expected.add(7);

        //When
        calculator.runOperations();
        List<Integer> tested = calculator.getSolutions();

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Multiplication")
    public void testMultiplication() {
        //Given
        Operation operation_deleted = new Multiplication(7, 2);
        calculator.addOperation(new Multiplication(7));
        calculator.addOperation(operation_deleted);
        calculator.addOperation(new Multiplication(0,6));
        calculator.addOperation(new Multiplication(9, 2, 1));
        calculator.removeOperation(operation_deleted);

        List<Integer> expected = new LinkedList<>();
        expected.add(7);
        expected.add(0);
        expected.add(18);

        //When
        calculator.runOperations();
        List<Integer> tested = calculator.getSolutions();

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Division")
    public void testDivision() {
        //Given
        Operation operation_deleted = new Division(7, 2);
        calculator.addOperation(operation_deleted);
        calculator.addOperation(new Division(5));
        calculator.addOperation(new Division(6,6));
        calculator.addOperation(new Division(9, 3, 1));
        calculator.removeOperation(operation_deleted);

        List<Integer> expected = new LinkedList<>();
        expected.add(5);
        expected.add(1);
        expected.add(3);

        //When
        calculator.runOperations();
        List<Integer> tested = calculator.getSolutions();

        //Then
        assertEquals(expected, tested);
    }

    @Test
    @DisplayName("Test Division Error")
    public void testMDivisionError() {
        //Given
        calculator.addOperation(new Division(5,0));

        //Exception catch expected
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.runOperations();
        }, "Exception Can't divide by 0");
    }

    @Test
    @DisplayName("Test Composition")
    public void testComposition() {
        //Given
        calculator.addOperation(new Division(5));
        calculator.addOperation(new Addition(6,4));
        calculator.addOperation(new Substraction(9, 3, 10));
        calculator.addOperation(new Multiplication(2,2,2,1));

        List<Integer> expected = new LinkedList<>();
        expected.add(5);
        expected.add(10);
        expected.add(-4);
        expected.add(8);

        //When
        calculator.runOperations();
        List<Integer> tested = calculator.getSolutions();

        //Then
        assertEquals(expected, tested);
    }
}


