package com.example.demo.services;
import java.util.List;
import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
	List<Product> findByUrunAdiContaining(String keyword);
	List<Product> findByKategori(int kategoriID);
}
