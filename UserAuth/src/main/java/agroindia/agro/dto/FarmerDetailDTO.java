package agroindia.agro.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class FarmerDetailDTO {
    private Long farmerId;
    private String farmerName;
    private String email;
    private String phoneNumber;
    private String location;
    private Integer stock;
    private BigDecimal bargainPrice;
    private String profileImage;
    private Boolean isVerified;
    private Integer totalProducts;
    private Double averageRating;
}