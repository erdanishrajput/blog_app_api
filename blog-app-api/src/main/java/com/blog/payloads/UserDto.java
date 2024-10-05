//(3) to transfer user data

package com.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	//jahan par bhi data transfer karna hoga wahan par userdto use krenge
	//jo data user se lena hai wahi data fiels use karenge is class m
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	
}
