package Factories;
import Documents.Document;
import Documents.WordDocument;

public class WordDocumentFactory extends DocumentFactory
{
    public Document createDocument()
    {
        System.out.println("Creating Word Document using WordDocumentFactory.");
        return new WordDocument();
    }
}