package springBootBestPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBootBestPractice.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
