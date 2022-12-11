package springBootBestPractice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBootBestPractice.dto.APIResponse;
import springBootBestPractice.dto.ProductRequestDto;
import springBootBestPractice.dto.ProductResponseDto;
import springBootBestPractice.service.ProductService;
import springBootBestPractice.util.ValueMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    public static final String SUCCESS = "Success";
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<APIResponse> createNewProduct(@RequestBody @Valid ProductRequestDto productRequestDto) {
        ProductResponseDto productResponseDto = productService.createNewProduct(productRequestDto);

        APIResponse<ProductResponseDto> responseDto = APIResponse.<ProductResponseDto>builder()
                .status(SUCCESS)
                .results(productResponseDto)
                .build();

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<APIResponse> getProducts() {
        List<ProductResponseDto> products = productService.getProducts();
        // Builder Design pattern (to avoid complex object creation headache)
        APIResponse<List<ProductResponseDto>> responseDto = APIResponse
                .<List<ProductResponseDto>>builder()
                .status(SUCCESS)
                .results(products)
                .build();

        log.info("productController::getProducts response {}", ValueMapper.jsonAsString(responseDto));

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable long productId){
        ProductResponseDto productResponseDto = productService.getProductById(productId);
        APIResponse<ProductResponseDto> responseDTO = APIResponse
                .<ProductResponseDto>builder()
                .status(SUCCESS)
                .results(productResponseDto)
                .build();

        log.info("ProductController::getProduct by id  {} response {}", productId,ValueMapper
                .jsonAsString(productResponseDto));

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/types")
    public ResponseEntity<APIResponse> getProductsGroupByType() {

        Map<String, List<ProductResponseDto>> products = productService.getProductsByTypes();
        APIResponse<Map<String, List<ProductResponseDto>>> responseDTO = APIResponse
                .<Map<String, List<ProductResponseDto>>>builder()
                .status(SUCCESS)
                .results(products)
                .build();

        log.info("ProductController::getProductsGroupByType by types  {}", ValueMapper.jsonAsString(responseDTO));

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

