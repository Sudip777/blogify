package com.sudip.blogify.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users_table")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Passwords")
	private String password;
	
	@Column(name = "About")
	private String about;
	

	
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<Post>();

}