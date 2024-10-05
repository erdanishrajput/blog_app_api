//(1) To table created in db 

package com.blog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity                           //table in db will be created from here
@Table(name="users")             // to change table name in mysql
@NoArgsConstructor              // to make user abstract
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //TO Auto incrmnt id
	private int id;
	
	@Column(name="user_name",nullable = false,length = 100)         //to change column name in db
	private String name;
	private String email;
	private String password;
	private String about;
}
