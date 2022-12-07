package springBootBestPractice.util;

import springBootBestPractice.dto.ProductRequestDto;
import springBootBestPractice.entity.Product;

public class ValueMapper {

    public static Product convertToEntity(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getName());
    }

}
