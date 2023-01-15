package com.baristalayoglu.projectlibrary.controller;

import com.baristalayoglu.projectlibrary.dao.BookRepository;
import com.baristalayoglu.projectlibrary.entity.Book;
import com.baristalayoglu.projectlibrary.entity.Catalogue;
import com.baristalayoglu.projectlibrary.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController implements CatalogueOperations{

    private BookRepository bookRepository;

    public CatalogueController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String listCategories(Model theModel){
        List<Book> books = bookRepository.findAll();
        theModel.addAttribute("books",books);

        return "list-category";
    }

    @GetMapping("/error?continue")
    public String continueErrorHandler(){
        return "redirect:/catalogue/list";
    }

    // The reason why I am not using database for Catalogue is to make Catalogue modificable
    @Override
    public Catalogue getCategories(){
        Catalogue catalogue = new Catalogue();
        List<Book> bookList = bookRepository.findAll();
        Category comedyCategory = new Category(1L, "Comedy");
        Category dramaCategory = new Category(2L, "Drama");
        Category adventureCategory = new Category(3L, "Adventure");
        Category childrenCategory = new Category(4L, "Children");
        Category crimeCategory = new Category(5L, "Crime");

        for(Book book: bookList){
            if(book.getBookType()!=null && book.getBookType().equals("Adventure")) {
                adventureCategory.getBooks().add(book);
            }
            else if(book.getBookType()!=null && book.getBookType().equals("Drama")) {
                dramaCategory.getBooks().add(book);
            }
            else if(book.getBookType()!=null && book.getBookType().equals("Comedy")) {
                comedyCategory.getBooks().add(book);
            }
            else if(book.getBookType()!=null && book.getBookType().equals("Children")) {
                childrenCategory.getBooks().add(book);
            }
            else if(book.getBookType()!=null && book.getBookType().equals("Crime")) {
                crimeCategory.getBooks().add(book);
            }
        }
        catalogue.getCategories().add(comedyCategory);
        catalogue.getCategories().add(dramaCategory);
        catalogue.getCategories().add(adventureCategory);
        catalogue.getCategories().add(childrenCategory);
        catalogue.getCategories().add(crimeCategory);

        return catalogue;
    }


}
