package com.library3;
import com.library3.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryMnagementApplication3
{
    public static void main(String args[])
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("The Hitchhiker's Guide to the Galaxy");
        ((ClassPathXmlApplicationContext) context).close();
    }
}
