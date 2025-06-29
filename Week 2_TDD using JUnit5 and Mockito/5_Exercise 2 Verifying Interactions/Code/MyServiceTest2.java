import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

interface ExternalApi2
{
    String getData();
    String saveData(String data);
}

class MyService2
{
    private ExternalApi2 externalApi;

    public MyService2(ExternalApi2 externalApi)
    {
        this.externalApi = externalApi;
    }

    public String fetchData()
    {
        return externalApi.getData();
    }

    public String storeData(String data)
    {
        return externalApi.saveData(data);
    }
}

public class MyServiceTest2
{
    @Test
    public void testExternalApi()
    {
        System.out.println("--- Running testExternalApi() ---");
        ExternalApi2 mockApi = mock(ExternalApi2.class);
        System.out.println("Step 1: Mock object for ExternalApi2 created.");
        when(mockApi.getData()).thenReturn("Mock Data");
        System.out.println("Step 2: ExternalApi2.getData() stubbed to return 'Mock Data'.");
        MyService2 service = new MyService2(mockApi);
        System.out.println("MyService2 instance created with the mock ExternalApi2.");
        String result = service.fetchData();
        System.out.println("Step 3 (Act): MyService2.fetchData() called. Result received: \"" + result + "\"");
        assertEquals("Mock Data", result, "MyService2 should return the stubbed data from ExternalApi2.");
        System.out.println("Assertion Passed: MyService2 returned the expected mock data.");
    }
    @Test
    public void testStoreData()
    {
        System.out.println("\n--- Running testStoreData() ---");
        ExternalApi2 mockApi = mock(ExternalApi2.class);
        String dataToSave = "Important Data";
        String expectedResponse = "Data Saved: " + dataToSave;
        when(mockApi.saveData(dataToSave)).thenReturn(expectedResponse);
        System.out.println("Arranged: Mock ExternalApi2 created and saveData stubbed.");
        MyService2 service = new MyService2(mockApi);
        String actualResponse = service.storeData(dataToSave);
        System.out.println("Acted: MyService2.storeData() called. Response: \"" + actualResponse + "\"");
        assertEquals(expectedResponse, actualResponse, "Service should return the stubbed response for saving data.");
        System.out.println("Assertion Passed: Service returned expected response for saving data.");
        verify(mockApi, times(1)).saveData(dataToSave);
        System.out.println("Verification Passed: ExternalApi2.saveData() was called once with the correct data.");
    }
    @Test
    public void testVerifyInteraction()
    {
        System.out.println("\n--- Running testVerifyInteraction() ---");
        ExternalApi2 mockApi = mock(ExternalApi2.class);
        System.out.println("Step 1: Mock object for ExternalApi2 created for interaction verification.");
        MyService2 service = new MyService2(mockApi);
        System.out.println("MyService2 instance created with the mock ExternalApi2 for verification.");
        service.fetchData();
        System.out.println("Step 2: MyService2.fetchData() called (which internally calls mockApi.getData()).");
        String testData = "Hello World";
        service.storeData(testData);
        System.out.println("Step 2: MyService2.storeData(\"" + testData + "\") called.");
        verify(mockApi).getData();
        System.out.println("Step 3: Verified that mockApi.getData() was called.");
        verify(mockApi, times(1)).saveData(testData);
        System.out.println("Step 3: Verified that mockApi.saveData() was called once with argument \"" + testData + "\".");
        System.out.println("testVerifyInteraction() Passed: All interactions verified.");
    }
    public static void main(String[] args)
    {
        System.out.println("Starting Mockito demonstration via main method...");
        MyServiceTest2 testRunner = new MyServiceTest2();

        try
        {
            System.out.println("\n===== Running testExternalApi =====");
            testRunner.testExternalApi();

            System.out.println("\n===== Running testStoreData =====");
            testRunner.testStoreData();

            System.out.println("\n===== Running testVerifyInteraction =====");
            testRunner.testVerifyInteraction();

            System.out.println("\nAll Mockito demonstration tests completed successfully!");
        }
        catch(AssertionError e)
        {
            System.err.println("\nTEST FAILED: An assertion failed during execution.");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.err.println("\nAN UNEXPECTED ERROR OCCURRED during test execution.");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}