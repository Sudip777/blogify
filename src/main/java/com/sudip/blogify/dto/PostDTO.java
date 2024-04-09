package com.sudip.blogify.dto;


import com.sudip.blogify.entities.Comment;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	
	@Getter
	private String postTitle;
	@Getter
	private String postContent;
	@Getter
	private String postImageName;
	@Getter
	private Date postAddedData;
	
	@Getter
	private CategoryDTO category;
	@Getter
	private UserDTO user;
	
	private List<Comment> comment = new ArrayList<Comment>();


}