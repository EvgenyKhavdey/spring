package com.example.hw10.repository.spec;


import com.example.hw10.model.Product;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;
import java.util.Objects;

@UtilityClass
public class ProductSpecification {

    private static Specification<Product> nameEq(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), name);
    }

    private static Specification<Product> nameLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + name + "%");
    }

    public Specification<Product> getSpecification(Map<String, String> params) {
        return params.entrySet().stream()
                .map(it -> {
                    if ("title".equals(it.getKey())) {
                        return nameEq(it.getValue());
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElse(null);
    }
}
