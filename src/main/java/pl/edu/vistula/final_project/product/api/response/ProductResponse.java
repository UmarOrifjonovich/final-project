package pl.edu.vistula.final_project.product.api.response;

public record ProductResponse(
        Long id,
        String name,
        Double price
) {}
