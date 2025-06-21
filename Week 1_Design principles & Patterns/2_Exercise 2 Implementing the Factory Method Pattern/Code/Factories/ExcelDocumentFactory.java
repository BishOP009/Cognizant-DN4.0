package Factories;
import Documents.Document;
import Documents.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory
{
    public Document createDocument()
    {
        System.out.println("Creating Excel Document using ExcelDocumentFactory.");
        return new ExcelDocument();
    }
}