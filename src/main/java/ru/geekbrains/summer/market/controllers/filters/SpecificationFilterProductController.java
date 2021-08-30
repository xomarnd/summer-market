package ru.geekbrains.summer.market.controllers.filters;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.summer.market.model.ProductEntity;
import ru.geekbrains.summer.market.repositories.specifications.ProductSpecifications;

import java.math.BigDecimal;
import java.util.HashMap;

public class SpecificationFilterProductController {
	private HashMap<String, Object> specificationList = new HashMap<>();

	public SpecificationFilterProductController(HashMap<String, Object> specificationList) {
		this.specificationList = specificationList;
	}

	public Specification<ProductEntity> getSpecification() {
		Specification<ProductEntity> spec = Specification.where(null);
		if (specificationList.get("min_price") != null) {
			spec = spec.and(ProductSpecifications.priceGreaterThanOrEqualTo((BigDecimal) specificationList.get("min_price")));
		}
		if (specificationList.get("max_price") != null) {
			spec = spec.and(ProductSpecifications.priceLessThanOrEqualTo((BigDecimal) specificationList.get("max_price")));
		}
		if (specificationList.get("title") != null) {
			spec = spec.and(ProductSpecifications.titleLike((String) specificationList.get("title")));
		}
		return spec;
	}
}
