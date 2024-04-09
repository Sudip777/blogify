package com.sudip.blogify.service;

import com.sudip.blogify.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
	
	//create
	CategoryDTO createCategory(CategoryDTO cateDTO);
	
	//update
	CategoryDTO updateCategory(CategoryDTO cateDTO , Integer cateId);
	
	//get
	
	CategoryDTO getCategoryById(Integer cateId);
	
	//delet
	void deleteCategory(Integer cateId);
	
	// get all category
	
	List<CategoryDTO> getAllCategory();
	

}