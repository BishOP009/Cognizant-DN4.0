public class SingletonTest
{
    public static void main(String[] args)
    {
        System.out.println("Attempting to get Logger instance 1...");
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        System.out.println("\nAttempting to get Logger instance 2...");
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        System.out.println("\nAttempting to get Logger instance 3...");
        Logger logger3 = Logger.getInstance();
        logger3.log("This is the third log message.");

        System.out.println("\nVerifying instances:");
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger1 == logger3: " + (logger1 == logger3));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));

        System.out.println("\nSingleton pattern successfully demonstrated.");
    }
}