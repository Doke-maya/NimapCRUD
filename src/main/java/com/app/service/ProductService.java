package com.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.pojo.ProductPojo;

public interface ProductService {

	Page<ProductPojo> getAllProducts(Pageable pageable);

	ProductPojo getProductById(Long id);

	ProductPojo createProduct(ProductPojo product);

	ProductPojo updateProduct(Long id, ProductPojo product);

	void deleteProduct(Long id);
}
