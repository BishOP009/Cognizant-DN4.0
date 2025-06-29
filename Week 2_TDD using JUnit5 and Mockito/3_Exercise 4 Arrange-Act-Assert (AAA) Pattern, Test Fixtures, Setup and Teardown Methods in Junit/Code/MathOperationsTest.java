import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathOperationsTest
{
    private MathOperations mathOps;
    private StringBuilder logBuffer;
    @BeforeEach
    public void setUp()
    {
        System.out.println("\n--- @BeforeEach: Setting up for a new test ---");
        mathOps = new MathOperations();
        logBuffer = new StringBuilder();
        logBuffer.append("Test Setup Complete.\n");
    }
    @AfterEach
    public void tearDown()
    {
        logBuffer.append("Test Teardown Complete.\n");
        System.out.println("--- @AfterEach: Tearing down after test ---");
        System.out.println("Captured Log for this test:\n" + logBuffer.toString());
        mathOps = null;
        logBuffer = null;
    }
    @Test
    public void testAddition()
    {
        System.out.println("Running testAddition()");
        logBuffer.append("Executing testAddition().\n");
        int num1 = 5;
        int num2 = 3;
        logBuffer.append("Arranged: num1=").append(num1).append(", num2=").append(num2).append(".\n");
        int result = mathOps.add(num1, num2);
        logBuffer.append("Acted: mathOps.add(").append(num1).append(", ").append(num2).append("), result=").append(result).append(".\n");
        assertEquals(8, result, "The sum of 5 and 3 should be 8");
        logBuffer.append("Asserted: Result is as expected.\n");
        System.out.println("testAddition() Passed.");
    }
    @Test
    public void testSubtraction()
    {
        System.out.println("Running testSubtraction()");
        logBuffer.append("Executing testSubtraction().\n");
        int num1 = 10;
        int num2 = 4;
        logBuffer.append("Arranged: num1=").append(num1).append(", num2=").append(num2).append(".\n");
        int result = mathOps.subtract(num1, num2);
        logBuffer.append("Acted: mathOps.subtract(").append(num1).append(", ").append(num2).append("), result=").append(result).append(".\n");
        assertEquals(6, result, "The difference of 10 and 4 should be 6");
        logBuffer.append("Asserted: Result is as expected.\n");
        System.out.println("testSubtraction() Passed.");
    }
    static class MathOperations
    {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }
    }
    public static void main(String[] args)
    {
        MathOperationsTest test = new MathOperationsTest();
        try
        {
            test.setUp();
            test.testAddition();
            test.tearDown();
            System.out.println("\n-----------------------------------\n");
            test.setUp();
            test.testSubtraction();
            test.tearDown();
            System.out.println("\nSUCCESS: All simulated tests executed without throwing an error.");
        }
        catch(AssertionError e)
        {
            System.err.println("\nFAILURE: An assertion failed in a simulated test!");
            System.err.println("Error Message: " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.err.println("\nAN UNEXPECTED ERROR OCCURRED during simulated test execution: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("\nMain method execution complete.");
    }
}
