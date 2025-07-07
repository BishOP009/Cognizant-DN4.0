package com.library2.repository;

public class BookRepository
{
    public void saveBook(String bookName)
    {
        System.out.println("BookRepository: Saving book to database - " + bookName);
    }
}