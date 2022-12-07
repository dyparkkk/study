package springBootBestPractice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
//@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    @NotBlank(message = "product type shouldn't be null or empty")
    private String name;

    private String description;

    @Min(value = 1, message = "quantity is not defined!")
    private int quantity;

    @Min(value = 200, message = "")
    @Max(value = 500000, message = "price can't be more than 5000")
    private double price;

    //...
}
