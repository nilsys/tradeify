package com.tradeify.tradeify_ws.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tradeify.tradeify_ws.category.vm.CategoryVM;
import com.tradeify.tradeify_ws.product.vm.BrandVM;

@RestController
public class BrandController {

	@Autowired
	BrandService brandService;
	
	@GetMapping("/api/1.0/brands/{id}/{generalId}")
	List<CategoryVM> getCategories(@PathVariable(name = "id") Long id, @PathVariable(name = "generalId") Long generalId) {
		List<CategoryVM> categoryVM = new ArrayList<>();
		
		List<Brand> categories = brandService.getBrands(id, generalId);
		for(Brand category: categories) {
			categoryVM.add(new CategoryVM(category));
		}
		
		return categoryVM;
	}
	
	@GetMapping("/api/1.0/brands")
	List<BrandVM> getAllCategories() {
		List<BrandVM> brandVM = new ArrayList<>();
		
		List<Brand> categories = brandService.getAllBrands();
		for(Brand category: categories) {
			brandVM.add(new BrandVM(category));
		}
		
		return brandVM;
	}
}
	