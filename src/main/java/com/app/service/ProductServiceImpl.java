package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.pojo.ProductPojo;
import com.app.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepository;

	@Override
	public Page<ProductPojo> getAllProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public ProductPojo getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public ProductPojo createProduct(ProductPojo product) {
		return productRepository.save(product);
	}

	@Override
	public ProductPojo updateProduct(Long id, ProductPojo product) {
		if (productRepository.existsById(id)) {
			product.setId(id);
			return productRepository.save(product);
		} else {
			return null;
		}
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
