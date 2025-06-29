import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest
{
    @Test
    public void testAssertions()
    {
        assertEquals(5, 2 + 3, "2 + 3 should be equal to 5");
        assertTrue(5 > 3, "5 should be greater than 3");
        assertFalse(5 < 3, "5 should not be less than 3");
        Object nullObject = null;
        assertNull(nullObject, "The object should be null");
        Object nonNullObject = new Object();
        assertNotNull(nonNullObject, "The object should not be null");
    }
    public static void main(String args[])
    {
        System.out.println("Attempting to run JUnit-like assertions via main method...");
        AssertionsTest test = new AssertionsTest();
        try
        {
            test.testAssertions();
            System.out.println("\nSUCCESS: All assertions executed without throwing an error.");
        }
        catch(AssertionError e)
        {
            System.err.println("\nFAILURE: An assertion failed!");
            System.err.println("Error Message: " + e.getMessage());
        }
        catch(Exception e)
        {
            System.err.println("\nAN UNEXPECTED ERROR OCCURRED: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("\nMain method execution complete.");
    }
}