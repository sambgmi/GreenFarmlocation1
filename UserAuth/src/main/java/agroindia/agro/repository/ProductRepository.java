package agroindia.agro.repository;

import agroindia.agro.model.Category;
import agroindia.agro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
    
    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts();
    
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    List<Product> searchByName(String name);

    List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String name, String description);
    List<Product> findByOrderByCreatedAtDesc();
}
