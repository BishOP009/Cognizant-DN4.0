import Documents.Document;
import Factories.DocumentFactory;
import Factories.ExcelDocumentFactory;
import Factories.PdfDocumentFactory;
import Factories.WordDocumentFactory;

public class FactoryMethodTest
{
    public static void main(String[] args)
    {
        System.out.println("--- Creating Word Document ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();
        System.out.println("\n--- Creating PDF Document ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();
        System.out.println("\n--- Creating Excel Document ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
        System.out.println("\nFactory Method pattern successfully demonstrated.");
    }
}