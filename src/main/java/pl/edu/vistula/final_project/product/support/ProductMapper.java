package pl.edu.vistula.final_project.product.support;

import org.springframework.stereotype.Component;
import pl.edu.vistula.final_project.product.api.request.ProductRequest;
import pl.edu.vistula.final_project.product.api.response.ProductResponse;
import pl.edu.vistula.final_project.product.domain.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return product;
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
