package springBootBestPractice.service;

import org.springframework.stereotype.Service;
import springBootBestPractice.dto.ProductRequestDto;
import springBootBestPractice.dto.ProductResponseDto;

import java.util.List;

@Service
public class ProductService {
    public ProductResponseDto createNewProduct(ProductRequestDto productRequestDto) {
        return null;
    }

    public List<ProductResponseDto> getProducts() {
        return null;
    }
}
