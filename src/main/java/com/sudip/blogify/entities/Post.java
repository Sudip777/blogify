package com.sudip.blogify.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post_table")
public class Post {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	
	@Column(name = "Title")
	private String postTitle;
	
	@Column(name = "Content")
	private String postContent;
	
	@Column(name = "Image")
	private String postImageName;
	
	@Column(name = "Date")
	private Date postAddedData;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	private Users user;
	
	@OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<Comment>();

}