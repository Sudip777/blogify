package com.sudip.blogify.controllers;

import com.sudip.blogify.dto.ApiResponse;
import com.sudip.blogify.dto.CommentDTO;
import com.sudip.blogify.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/comment")
public class CommentController {
	
	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PostMapping("/create/{postId}")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentdto , @PathVariable Integer postId){
		
		CommentDTO commentdtos = commentService.createComment(commentdto, postId);
		return new ResponseEntity<CommentDTO>(commentdtos , HttpStatus.CREATED);
	}
	
	// here Update API is Implement
	
	@DeleteMapping("/delete/{commentId}")
	public ResponseEntity<ApiResponse> deletComment(@PathVariable Integer commentId){
		
		commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully" , true),
				HttpStatus.OK);
		
	}
	
}