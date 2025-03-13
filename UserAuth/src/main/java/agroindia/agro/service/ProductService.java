package agroindia.agro.service;


import agroindia.agro.model.Category;
import agroindia.agro.model.Product;
import agroindia.agro.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    public Product addProduct(Product product) {


        System.out.println("hi");
        return productRepository.save(product);
        
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
}
