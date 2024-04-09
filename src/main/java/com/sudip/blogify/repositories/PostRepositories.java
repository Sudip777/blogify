package com.sudip.blogify.repositories;
import com.sudip.blogify.entities.Category;
import com.sudip.blogify.entities.Post;
import com.sudip.blogify.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepositories extends JpaRepository<Post, Integer>{
	
	List<Post> findAllByUser(Users user);
	List<Post> findAllByCategory(Category category);
	
	

}