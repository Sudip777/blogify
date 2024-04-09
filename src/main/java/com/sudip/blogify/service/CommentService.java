package com.sudip.blogify.service;

import com.sudip.blogify.dto.CommentDTO;
import org.springframework.stereotype.Service;

@Service

public interface CommentService {
	
	//create
	CommentDTO createComment(CommentDTO commentdto , Integer postId);
   
	//deleted Comment
	void deleteComment(Integer commentId);

	
}