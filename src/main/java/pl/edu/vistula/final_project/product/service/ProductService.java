package pl.edu.vistula.final_project.product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.final_project.product.api.request.ProductRequest;
import pl.edu.vistula.final_project.product.api.response.ProductResponse;
import pl.edu.vistula.final_project.product.domain.Product;
import pl.edu.vistula.final_project.product.exception.ProductNotFoundException;
import pl.edu.vistula.final_project.product.repository.ProductRepository;
import pl.edu.vistula.final_project.product.support.ProductMapper;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = mapper.toEntity(request);
        return mapper.toResponse(repository.save(product));
    }

    public ProductResponse getById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return mapper.toResponse(product);
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(request.getName());
        product.setPrice(request.getPrice());

        return mapper.toResponse(repository.save(product));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
