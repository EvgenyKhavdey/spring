package com.example.hw8.repository.spec;


import com.example.hw8.model.Product;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;
import java.util.Objects;

/**
 * @author antonkuznetsov
 */
@UtilityClass
public class ProductSpecification {

    private static Specification<Product> nameEq(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    private static Specification<Product> nameLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public Specification<Product> getSpecification(Map<String, String> params) {
        return params.entrySet().stream()
                .map(it -> {
                    if ("name".equals(it.getKey())) {
                        return nameEq(it.getValue());
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElse(null);
    }
}
