package springBootBestPractice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import springBootBestPractice.dto.ProductRequestDto;
import springBootBestPractice.dto.ProductResponseDto;
import springBootBestPractice.entity.Product;

public class ValueMapper {

    public static Product convertToEntity(ProductRequestDto productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setProductType(productRequestDTO.getProductType());
        product.setQuantity(productRequestDTO.getQuantity());
        product.setPrice(productRequestDTO.getPrice());
        product.setSupplierName(productRequestDTO.getSupplierName());
        product.setSupplierCode(productRequestDTO.getSupplierCode());
        return product;
    }

    public static ProductResponseDto convertToDTO(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setDesc(product.getDescription());
        productResponseDto.setProductType(product.getProductType());
        productResponseDto.setQuantity(product.getQuantity());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setSupplierName(product.getSupplierName());
        productResponseDto.setSupplierCode(product.getSupplierCode());
        return productResponseDto;
    }

    public static String jsonAsString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
