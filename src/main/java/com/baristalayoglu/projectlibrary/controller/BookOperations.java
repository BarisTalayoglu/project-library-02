package com.baristalayoglu.projectlibrary.controller;

import com.baristalayoglu.projectlibrary.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/defaultBook")
@Controller
public interface BookOperations {

    @GetMapping("/list")
    public String listBooks(Model theModel);

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel);

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book theBook);

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") Long theId, Model theModel);

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id);

    @GetMapping("/order")
    public String orderBook(@RequestParam("id") Long id, Model theModel);

}
