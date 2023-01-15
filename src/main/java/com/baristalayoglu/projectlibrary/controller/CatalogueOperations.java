package com.baristalayoglu.projectlibrary.controller;

import com.baristalayoglu.projectlibrary.entity.Catalogue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/defaultCatalogue")
@Controller
public interface CatalogueOperations {

    @GetMapping("/list")
    public String listCategories(Model theModel);

    @ModelAttribute("catalogue")
    public Catalogue getCategories();
}
