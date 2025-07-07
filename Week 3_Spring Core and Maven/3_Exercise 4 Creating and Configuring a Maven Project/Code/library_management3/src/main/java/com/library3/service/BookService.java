package com.library3.service;
import com.library3.repository.BookRepository;

public class BookService
{
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }
    public void addBook(String bookName)
    {
        System.out.println("BookService: Adding book - " + bookName);
        bookRepository.saveBook(bookName);
    }
}