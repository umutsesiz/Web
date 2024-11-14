package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.models.Product;

@Component
public class DataInitializerProducts implements CommandLineRunner {

	private final ProductsRepository productsRepository;

    @Autowired
    public DataInitializerProducts(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productsRepository.count() == 0) {
            Product product1 = new Product();
            product1.setUrun_adi("Çanta");
            product1.setKategori(1);
            product1.setFiyat("150");
            product1.setUrun_aciklama("Mini çanta");
            product1.setUrun_image("images/canta.jpg");
            productsRepository.save(product1);
            
            Product product2 = new Product();
            product2.setUrun_adi("Ayakkabı");
            product2.setKategori(2);
            product2.setFiyat("350");
            product2.setUrun_aciklama("Spor ayakkabı");
            product2.setUrun_image("images/ayakkabi.jpg");
            productsRepository.save(product2);
            
            Product product3 = new Product();
            product3.setUrun_adi("Pantolon");
            product3.setKategori(3);
            product3.setFiyat("220");
            product3.setUrun_aciklama("Kaliteli kumaş pantolon");
            product3.setUrun_image("images/pantolon.jpg");
            productsRepository.save(product3);
        }
    }
}
