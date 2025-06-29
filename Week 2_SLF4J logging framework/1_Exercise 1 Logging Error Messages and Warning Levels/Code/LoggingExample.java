import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample
{
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);
    public static void main(String[] args)
    {
        System.out.println("Starting LoggingExample application...");
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        System.out.println("Logging demonstration complete. Check console for output.");
    }
}