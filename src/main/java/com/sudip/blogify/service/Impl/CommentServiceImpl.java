package com.sudip.blogify.service.Impl;

import com.sudip.blogify.dto.CommentDTO;
import com.sudip.blogify.entities.Comment;
import com.sudip.blogify.entities.Post;
import com.sudip.blogify.entities.Users;
import com.sudip.blogify.exceptions.ResourseNotFoundExceptions;
import com.sudip.blogify.repositories.CommentRepositories;
import com.sudip.blogify.repositories.PostRepositories;
import com.sudip.blogify.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	private final CommentRepositories commentRepositories;
	private final PostRepositories postrepositories;
	public CommentServiceImpl(CommentRepositories commentRepositories, PostRepositories postrepositories) {
		this.commentRepositories = commentRepositories;
		this.postrepositories = postrepositories;
	}
	public CommentDTO createComment(CommentDTO commentdto , Integer postId) {
		Post post = postrepositories.findById(postId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("post" , "postId" , postId));
		
		Comment comment = dtoToComment(commentdto);
		comment.setPost(post);
		Comment savecomment = commentRepositories.save(comment);
		return commentToDto(savecomment);
	}


	@Override
	public void deleteComment(Integer commentId) {
		
		Comment comment = commentRepositories.findById(commentId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("comment" , "commentId" , commentId));
		commentRepositories.delete(comment);
	}
	// Conversion Convert CommentDTOs to Comment and Vice-Versa
	public Comment dtoToComment(CommentDTO commentdto) {
		Comment c = new Comment();
		c.setCommentContent(commentdto.getCommentContent());
		return c;
	}
	public CommentDTO commentToDto(Comment comment) {
		CommentDTO c = new CommentDTO();
		c.setCommentContent(comment.getCommentContent());
		return c;
	}

}