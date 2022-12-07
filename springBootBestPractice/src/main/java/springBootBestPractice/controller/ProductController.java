package springBootBestPractice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBootBestPractice.dto.APIResponse;
import springBootBestPractice.dto.ProductRequestDto;
import springBootBestPractice.dto.ProductResponseDto;
import springBootBestPractice.service.ProductService;

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
}
