import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

interface ExternalApi
{
    String getData();
    String saveData(String data);
}

class MyService
{
    private ExternalApi externalApi;
    public MyService(ExternalApi externalApi)
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

public class MyServiceTest
{
    @Test
    public void testExternalApi()
    {
        System.out.println("--- Running testExternalApi() ---");
        ExternalApi mockApi = mock(ExternalApi.class);
        System.out.println("Step 1: Mock object for ExternalApi created.");
        when(mockApi.getData()).thenReturn("Mock Data");
        System.out.println("Step 2: ExternalApi.getData() stubbed to return 'Mock Data'.");
        MyService service = new MyService(mockApi);
        System.out.println("MyService instance created with the mock ExternalApi.");
        String result = service.fetchData();
        System.out.println("Step 3 (Act): MyService.fetchData() called. Result received: \"" + result + "\"");
        assertEquals("Mock Data", result, "MyService should return the stubbed data from ExternalApi.");
        System.out.println("Assertion Passed: MyService returned the expected mock data.");
    }
    @Test
    public void testStoreData()
    {
        System.out.println("\n--- Running testStoreData() ---");
        ExternalApi mockApi = mock(ExternalApi.class);
        String dataToSave = "Important Data";
        String expectedResponse = "Data Saved: " + dataToSave;
        when(mockApi.saveData(dataToSave)).thenReturn(expectedResponse);
        System.out.println("Arranged: Mock ExternalApi created and saveData stubbed.");
        MyService service = new MyService(mockApi);
        String actualResponse = service.storeData(dataToSave);
        System.out.println("Acted: MyService.storeData() called. Response: \"" + actualResponse + "\"");
        assertEquals(expectedResponse, actualResponse, "Service should return the stubbed response for saving data.");
        System.out.println("Assertion Passed: Service returned expected response for saving data.");
        verify(mockApi, times(1)).saveData(dataToSave);
        System.out.println("Verification Passed: ExternalApi.saveData() was called once with the correct data.");
    }
    public static void main(String[] args)
    {
        System.out.println("Starting Mockito demonstration via main method...");
        MyServiceTest testRunner = new MyServiceTest();
        try
        {
            testRunner.testExternalApi();
            System.out.println("\n-------------------------------------------------\n");
            testRunner.testStoreData();
            System.out.println("\nAll Mockito demonstration tests completed successfully!");

        }
        catch(AssertionError e)
        {
            System.err.println("\nTEST FAILED: An assertion failed during execution.");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }catch(Exception e)
        {
            System.err.println("\nAN UNEXPECTED ERROR OCCURRED during test execution.");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}