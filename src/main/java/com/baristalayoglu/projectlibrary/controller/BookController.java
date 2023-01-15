package com.baristalayoglu.projectlibrary.controller;

import com.baristalayoglu.projectlibrary.dao.BookRepository;
import com.baristalayoglu.projectlibrary.entity.Book;
import com.baristalayoglu.projectlibrary.entity.Reciept;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/books")
public class BookController implements BookOperations {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String listBooks(Model theModel){
        List<Book> books = bookRepository.findAll();
        theModel.addAttribute("books",books);

        return "list-books";
    }

    @Override
    public String showFormForAdd(Model theModel){
        Book newBook = new Book();
        theModel.addAttribute("book",newBook);

        return "book-form";
    }

    @Override
    public String saveBook(@ModelAttribute("book") Book theBook){
        bookRepository.save(theBook);
        return "redirect:/books/list";
    }

    @Override
    public String showFormForUpdate(@RequestParam("id") Long theId, Model theModel){
        Optional<Book> theBook = bookRepository.findById(theId);
        theModel.addAttribute("book",theBook);

        return "book-form";
    }

    @Override
    public String delete(@RequestParam("id") Long id){
        bookRepository.deleteById(id);
        return "redirect:/books/list";
    }

    @Override
    public String orderBook(@RequestParam("id") Long id, Model theModel){
        Optional<Book> theBook = bookRepository.findById(id);
        theBook.get().setBookStatus(false);
        theModel.addAttribute("book",theBook);

        return "book-order";
    }




}