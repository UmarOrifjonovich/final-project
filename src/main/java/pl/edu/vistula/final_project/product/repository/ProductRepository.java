package pl.edu.vistula.final_project.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.vistula.final_project.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
