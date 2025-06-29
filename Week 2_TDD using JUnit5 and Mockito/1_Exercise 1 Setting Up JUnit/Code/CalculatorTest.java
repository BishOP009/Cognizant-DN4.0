import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CalculatorTest
{
    @Test
    public void testAdd()
    {
        Calculator calculator = new Calculator();
        int sum = calculator.add(5, 3);
        assertEquals("The add method should return 8", 8, sum);
        int sumNegative = calculator.add(-5, 3);
        assertEquals("The add method should handle negative numbers", -2, sumNegative);
    }

    @Test
    public void testSubtract()
    {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 4);
        assertEquals("The subtract method should return 6", 6, result);
        int resultNegative = calculator.subtract(3, 7);
        assertEquals("The subtract method should handle negative results", -4, resultNegative);
    }

    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(CalculatorTest.class);
        for (Failure failure : result.getFailures())
            System.err.println("Test Failed: " + failure.toString());
        System.out.println("\n--- Test Summary ---");
        System.out.println("Total tests run: " + result.getRunCount());
        System.out.println("Tests ignored: " + result.getIgnoreCount());
        System.out.println("Tests failed: " + result.getFailureCount());
        System.out.println("All tests passed: " + result.wasSuccessful());
        if (result.wasSuccessful())
            System.out.println("All JUnit tests completed successfully!");
        else
            System.out.println("Some JUnit tests failed.");
    }
}
