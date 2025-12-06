package com.practiceApi.dbconnect.service;

import com.practiceApi.dbconnect.entity.Book;
import com.practiceApi.dbconnect.repository.Bookrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public final Bookrepository bookrepository;

    public BookService(Bookrepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    public List<Book> getAllBooks() {
        return bookrepository.findAll();
    }

    public Book getBook(Long id) {
        return bookrepository.findById(id).orElseThrow(()-> new RuntimeException("Book Not Found"));
    }

    public Book add(Book book) {
        return bookrepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book existing = getBook(id);
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setCategory(book.getCategory());
        existing.setIsavailable(book.isIsavailable());
        return bookrepository.save(existing);
    }

    public void delete(Long id) {
        bookrepository.deleteById(id);
    }
}
