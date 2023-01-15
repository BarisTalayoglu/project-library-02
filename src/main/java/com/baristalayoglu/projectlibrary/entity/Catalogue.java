package com.baristalayoglu.projectlibrary.entity;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    public List<Category> categories;

    public Catalogue() {
        categories = new ArrayList<>();
        this.categories = categories;

    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
