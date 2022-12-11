package springBootBestPractice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springBootBestPractice.dto.ProductRequestDto;
import springBootBestPractice.dto.ProductResponseDto;
import springBootBestPractice.repository.ProductRepository;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createNewProduct(ProductRequestDto productRequestDto) {
        return null;
    }

    public List<ProductResponseDto> getProducts() {
        return null;
    }

    public ProductResponseDto getProductById(long productId) {
        return null;
    }

    public Map<String, List<ProductResponseDto>> getProductsByTypes() {
        return null;
    }
}
