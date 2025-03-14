package agroindia.agro.repository;


import agroindia.agro.model.Category;
import agroindia.agro.model.FarmerProduct;
import agroindia.agro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmerProductRepository extends JpaRepository<FarmerProduct, Long> {
    List<FarmerProduct> findByFarmer(User farmer);
    FarmerProduct findByFarmerAndProduct_Id(User farmer, Long productId);
     
    List<FarmerProduct> findByFarmerAndProduct_Category(User farmer, Category category);
    @Query("SELECT fp FROM FarmerProduct fp JOIN FETCH fp.product p JOIN FETCH fp.farmer f")
    List<FarmerProduct> findAllWithProductAndFarmer();
    
    @Query("SELECT fp FROM FarmerProduct fp JOIN FETCH fp.product p JOIN FETCH fp.farmer f WHERE p.id = :productId")
    List<FarmerProduct> findAllByProductIdWithFarmer(Long productId);
    
    List<FarmerProduct> findByProduct_Category(Category category);
}