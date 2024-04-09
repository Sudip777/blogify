package com.sudip.blogify.repositories;

import com.sudip.blogify.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepositories extends JpaRepository<Comment, Integer> {

}