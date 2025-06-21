package Factories;
import Documents.Document;
import Documents.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory
{
    public Document createDocument()
    {
        System.out.println("Creating PDF Document using PdfDocumentFactory.");
        return new PdfDocument();
    }
}