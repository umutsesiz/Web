package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.models.Category;

@Component
public class DataInitializerCategory implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public DataInitializerCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            Category category1 = new Category();
            category1.setKategoriAdi("Çanta");
            categoryRepository.save(category1);
          
            Category category2 = new Category();
            category2.setKategoriAdi("Ayakkabı");
            categoryRepository.save(category2);
            
            Category category3 = new Category();
            category3.setKategoriAdi("Pantolon");
            categoryRepository.save(category3);
        }
    }
}