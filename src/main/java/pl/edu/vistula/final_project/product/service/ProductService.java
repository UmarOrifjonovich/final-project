package pl.edu.vistula.final_project.product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.final_project.product.api.request.ProductRequest;
import pl.edu.vistula.final_project.product.api.response.ProductResponse;
import pl.edu.vistula.final_project.product.domain.Product;
import pl.edu.vistula.final_project.product.exception.ProductNotFoundException;
import pl.edu.vistula.final_project.product.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;   // ✅ THIS WAS MISSING

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;      // ✅ REQUIRED
    }

    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        Product saved = productRepository.save(product);
        return new ProductResponse(saved.getId(), saved.getName(), saved.getPrice());
    }

    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(p -> new ProductResponse(
                        p.getId(),
                        p.getName(),
                        p.getPrice()
                ))
                .toList();
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(request.getName());
        product.setPrice(request.getPrice());

        Product updated = productRepository.save(product);
        return new ProductResponse(updated.getId(), updated.getName(), updated.getPrice());
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
