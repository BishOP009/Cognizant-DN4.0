package com.library2;
import com.library2.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication2
{
    public static void main(String args[])
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("The Theory of Everything");
        ((ClassPathXmlApplicationContext) context).close();
    }
}