package org.example.MappingsPractice.Controller;

import org.example.MappingsPractice.Model.Book;
import org.example.MappingsPractice.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping("Books")
    public List<Book> getAllBooks(){
        return bookService.getAllBoooks();
    }


    @PutMapping("book")
    public String updateBook(@RequestParam Long Id, @RequestParam String title, @RequestParam String Author, @RequestParam String description, @RequestParam String price){
        return bookService.updateBook(Id,title,Author,description,price);
    }

    @PostMapping("book")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("book/{Id}")
    public String deleteBook(@PathVariable Long Id){
        return bookService.deleteBook(Id);
    }
}
