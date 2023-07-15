package org.example.MappingsPractice.Service;

import org.example.MappingsPractice.Model.Book;
import org.example.MappingsPractice.Repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    IBookRepo bookRepo;

    public List<Book> getAllBoooks(){
        return bookRepo.findAll();
    }


    public String addBook(Book book){
        bookRepo.save(book);
        return "Book has been added";
    }
    public String updateBook(Long Id, String bookAuthor, String bookDescription,String bookTitle, String bookPrice) {
        Optional<Book> bookOptional = bookRepo.findById(Id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setBookAuthor(bookAuthor);
            book.setBookDescription(bookDescription);
            book.setBookPrice(bookPrice);
            book.setBookTitle(bookTitle);
            bookRepo.save(book);
            return "Book has been updated ";
        }
        return "Book not found of Id : " + Id;
    }

        public String deleteBook(Long Id){
            Optional<Book>bookoptional = bookRepo.findById(Id);
            if(bookoptional.isPresent()){
                Book book = bookoptional.get();
                bookRepo.delete(book);
                return "Book has been removed ";
            }return "could not find a book of Id : " + Id;
        }


}
