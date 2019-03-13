package com.sapient.category;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sapient.category.entity.Product;

@FeignClient(name = "category", url = "localhost:8000")
public interface CategoryProxy {

	@GetMapping("/category/{categoryId}/products")
	public Product getProducts(@PathVariable(name = "categoryId") int categoryId);
}
