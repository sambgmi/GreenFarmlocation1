package agroindia.agro.controller;


import agroindia.agro.model.Category;
import agroindia.agro.model.Product;
import agroindia.agro.model.User;
import agroindia.agro.service.CategoryService;
import agroindia.agro.service.ProductService;
import agroindia.agro.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminController {
    
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/products/by-category/{category}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable String category) {
        if (!categoryService.isCategoryValid(category)) {
            return ResponseEntity.badRequest().body("Invalid category");
        }
        return ResponseEntity.ok(productService.getProductsByCategory(Category.valueOf(category)));
    }

    @GetMapping("/users/farmers")
    public ResponseEntity<List<User>> getAllFarmers() {
        return ResponseEntity.ok(userService.getAllFarmers());
    }

    @GetMapping("/users/buyers")
    public ResponseEntity<List<User>> getAllBuyers() {
        return ResponseEntity.ok(userService.getAllBuyers());
    }

    @GetMapping("/public/products")
    public ResponseEntity<List<Product>> getAllProductsPublic() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

   

    @DeleteMapping ("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            Product savedProduct = productService.addProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}