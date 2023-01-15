package com.baristalayoglu.projectlibrary.controller;

import com.baristalayoglu.projectlibrary.dao.BookRepository;
import com.baristalayoglu.projectlibrary.dao.RecieptRepository;
import com.baristalayoglu.projectlibrary.entity.Book;
import com.baristalayoglu.projectlibrary.entity.Reciept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller
public class RecieptController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    RecieptRepository recieptRepository;

    @GetMapping("/books/reciept")
    public String getReciept(@ModelAttribute("book") Book theBook, Model theModel) {
        bookRepository.save(theBook);
        Reciept reciept = new Reciept();
        Date date = reciept.getDate();
        Date futureDate = reciept.getReturnDate();
        reciept.setMemberName(theBook.getMemberName());
        reciept.setBookName(theBook.getBookName());
        recieptRepository.save(reciept);
        theModel.addAttribute("futureDate",futureDate);
        theModel.addAttribute("date",date);

        return "book-reciept";
    }

}
