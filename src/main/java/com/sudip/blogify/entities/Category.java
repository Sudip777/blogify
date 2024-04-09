package com.sudip.blogify.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Categories_tables")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
	@Column(name = "Titles")
	private String categoryTitle;
	
	@Column(name = "Discription")
	private String categoryDiscription;
	
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<Post>();
	

}