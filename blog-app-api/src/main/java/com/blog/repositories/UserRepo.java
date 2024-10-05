//(2) to post user data and get user in db

package com.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<Object[]> getUserDetailsById(@Param("Id") Integer Id);
	
}
