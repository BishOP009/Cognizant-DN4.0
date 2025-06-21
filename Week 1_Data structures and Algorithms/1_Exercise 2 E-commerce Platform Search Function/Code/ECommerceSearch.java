import java.util.*;
public class ECommerceSearch
{
    public Product linearSearch(Product products[], String productId)
    {
        System.out.println("\nPerforming Linear Search for Product ID: " + productId);
        for(int i = 0; i < products.length; i++)
        {
            if (products[i].getProductId().equals(productId))
            {
                System.out.println("Linear Search: Found product at index " + i);
                return products[i];
            }
        }
        System.out.println("Linear Search: Product with ID " + productId + " not found.");
        return null;
    }
    public Product binarySearch(Product Products[], String productId)
    {
        System.out.println("\nPerforming Binary Search for Product ID: " + productId);
        int l = 0;
        int u = Products.length - 1;
        
        while (l <= u)
        {
            int mid = (l+u)/2;
            int comp = productId.compareTo(Products[mid].getProductId());
            if (comp == 0)
            {
                System.out.println("Binary Search: Found product at index " + mid);
                return Products[mid];
            }
            else if (comp < 0)
                u = mid - 1;
            else
                l = mid + 1;
        }
        System.out.println("Binary Search: Product with ID " + productId + " not found.");
        return null;
    }
    public static void main(String[] args)
    {
        Product pls[] =
        {
            new Product("P005", "Gaming Mouse", "Electronics", 49.99),
            new Product("P001", "Laptop Pro", "Electronics", 1200.00),
            new Product("P007", "Bluetooth Speaker", "Audio", 75.50),
            new Product("P003", "Mechanical Keyboard", "Electronics", 99.00),
            new Product("P002", "Smartwatch X", "Wearables", 199.99),
            new Product("P008", "Desk Lamp", "Home Office", 25.00),
            new Product("P004", "External SSD", "Storage", 150.00),
            new Product("P006", "Webcam HD", "Accessories", 60.00)
        };
        Product pbs[] = Arrays.copyOf(pls, pls.length);
        Arrays.sort(pbs, Comparator.comparing(Product::getProductId));
        ECommerceSearch searcher = new ECommerceSearch();
        System.out.println("\n--- Testing Linear Search ---");
        Product x = searcher.linearSearch(pls, "P003");
        if (x != null)
            System.out.println("Found: " + x);
        else
            System.out.println("Not Found");
        System.out.println("\n--- Testing Binary Search ---");
        Product y = searcher.binarySearch(pbs, "P001");
        if (y != null)
            System.out.println("Found: " + y);
        else
            System.out.println("Not Found");
    }
}