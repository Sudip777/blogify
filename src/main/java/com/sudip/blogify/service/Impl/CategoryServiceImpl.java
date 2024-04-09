package com.sudip.blogify.service.Impl;
import java.util.List;
import java.util.stream.Collectors;

import com.sudip.blogify.dto.CategoryDTO;
import com.sudip.blogify.entities.Category;
import com.sudip.blogify.exceptions.ResourseNotFoundExceptions;
import com.sudip.blogify.repositories.CategoryRepositories;
import com.sudip.blogify.service.CategoryService;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepositories categoryrepositories;

	public CategoryServiceImpl(CategoryRepositories categoryrepositories) {
		this.categoryrepositories = categoryrepositories;
	}


	@Override
	public CategoryDTO createCategory(CategoryDTO cateDTO) {
		
		 Category category = dtoToCategory(cateDTO);
		 Category savingCategory = categoryrepositories.save(category);
		 return categoryToDto(savingCategory);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO cateDTO, Integer cateId) {
		
		Category cat = categoryrepositories.findById(cateId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("category" , "category Id" , cateId));
		cat.setCategoryTitle(cateDTO.getCategoryTitle());
		cat.setCategoryDiscription(cateDTO.getCategoryDescription());
		
		Category updatedOne = categoryrepositories.save(cat);
		return categoryToDto(updatedOne);
	}

	@Override
	public CategoryDTO getCategoryById(Integer categoryId) {
	  Category cat = categoryrepositories.getById(categoryId);
	   return categoryToDto(cat);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = categoryrepositories.findById(categoryId).orElseThrow(() -> new ResourseNotFoundExceptions("category" , "categoryId" , categoryId));
		categoryrepositories.delete(cat);
		
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> cat = categoryrepositories.findAll();
		List<CategoryDTO> categoryDto = cat.stream().map(e -> categoryToDto(e)).collect(Collectors.toList());
		return categoryDto;
	}
	
	
	// Convert DTO to Category and vice versa
	
	public Category dtoToCategory(CategoryDTO cateDto) {
		
		Category s = new Category();
		s.setCategoryTitle(cateDto.getCategoryTitle());
		s.setCategoryDiscription(cateDto.getCategoryDescription());
		return s;
		
	}
	
	public CategoryDTO categoryToDto(Category category) {
		
		CategoryDTO ss = new CategoryDTO();
		ss.setCategoryTitle(category.getCategoryTitle());
		ss.setCategoryDescription(category.getCategoryDiscription());
		return ss;
		
	}

}