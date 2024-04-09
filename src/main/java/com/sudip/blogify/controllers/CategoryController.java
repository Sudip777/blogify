package com.sudip.blogify.controllers;

import java.util.List;

import com.sudip.blogify.dto.ApiResponse;
import com.sudip.blogify.dto.CategoryDTO;
import com.sudip.blogify.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("/create")
    public ResponseEntity<CategoryDTO> createC(@RequestBody CategoryDTO categoryDTO){
    	CategoryDTO categoryDTO1 = this.categoryService.createCategory(categoryDTO);
    	return new ResponseEntity<CategoryDTO>(categoryDTO1 , HttpStatus.CREATED);
    }
	
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<CategoryDTO> updateC(@RequestBody CategoryDTO categoryDTO ,@PathVariable("categoryId") Integer catId){
		CategoryDTO categoryDTO1 = categoryService.updateCategory(categoryDTO, catId);
		return new ResponseEntity<CategoryDTO>(categoryDTO1 , HttpStatus.OK);
	}
	
	@GetMapping("/get/{categoryId}")
	public ResponseEntity<CategoryDTO> getById(@PathVariable("categoryId") Integer catId){
		CategoryDTO categoryDTO1 = categoryService.getCategoryById(catId);
		return new ResponseEntity<CategoryDTO>(categoryDTO1 , HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<ApiResponse> deletebyId(@PathVariable("categoryId") Integer categoryId){
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully" , false) , HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDTO>> getAll(){
		List<CategoryDTO> categoryDTOS = categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDTO>>(categoryDTOS , HttpStatus.OK);
	}
}