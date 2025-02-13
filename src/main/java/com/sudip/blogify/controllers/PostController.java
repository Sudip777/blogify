package com.sudip.blogify.controllers;

import java.util.List;

import com.sudip.blogify.dto.ApiResponse;
import com.sudip.blogify.dto.PostDTO;
import com.sudip.blogify.service.PostService;
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
@RequestMapping("/api/v1/post")
public class PostController {
	
	private  final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@PostMapping("/create/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDTO> createNewPost(@RequestBody PostDTO postdto,
												 @PathVariable Integer userId , @PathVariable Integer categoryId){
		
	PostDTO createdPost = postService.createPost(postdto , userId , categoryId);
	  return new ResponseEntity<PostDTO>(createdPost, HttpStatus.CREATED);
	
	}
	
	@PutMapping("/update/{postId}")
	public ResponseEntity<PostDTO> updatesPost(@RequestBody PostDTO postdto , Integer postId){
		PostDTO pdto = postService.updatePost(postdto, postId);
		return new ResponseEntity<PostDTO>(pdto , HttpStatus.OK);	
	}
	
	@DeleteMapping("delete/{postId}")
	public ResponseEntity<
			ApiResponse> deletedPost(@PathVariable Integer postId){
		postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("this post has been deleted" , true) , HttpStatus.OK);	
		
	}

	@GetMapping("/all")
	public ResponseEntity<List<PostDTO>> getAllPostS(){
		List<PostDTO> listpost = postService.getAllPosts();
		return new ResponseEntity<List<PostDTO>>(listpost , HttpStatus.OK);	

   }
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDTO> getSinglePost(@PathVariable Integer postId){
		PostDTO postdto = postService.getSinglePost(postId);
		return new ResponseEntity<PostDTO>(postdto , HttpStatus.OK);	
	 }
	
	// New Learning....
	@GetMapping("/all/{userId}/posts")
	public ResponseEntity<List<PostDTO>> getallpostbyusers(@PathVariable Integer userId){
		List<PostDTO> post = postService.getAllPostByUser(userId);
		return new ResponseEntity<List<PostDTO>>(post , HttpStatus.OK);	
		
	}
	
	@GetMapping("/all/{categoryId}/posts")
	public ResponseEntity<List<PostDTO>> getAlluserByCategories(@PathVariable Integer categoryId){
		List<PostDTO> post = postService.getAllPostByCategory(categoryId);
		return new ResponseEntity<List<PostDTO>>(post , HttpStatus.OK);		
	}
}