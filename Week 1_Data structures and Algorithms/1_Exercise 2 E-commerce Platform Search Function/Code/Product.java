public class Product
{
    String productId;
    String productName;
    String category;
    public Product(String productId, String productName, String category, double price)
    {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    public String getProductId()
    {
        return productId;
    }
    public String getProductName()
    {
        return productName;
    }
    public String getCategory() {
        return category;
    }
    public String toString()
    {
        return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}