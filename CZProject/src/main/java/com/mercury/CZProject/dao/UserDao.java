package com.mercury.CZProject.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.CZProject.bean.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
	
	@Modifying
	@Query(value = "insert into userprofile (userid, profileid)"
			+ "values (:userid, :profileid)"
			, nativeQuery = true)
	@Transactional
	public void addUserProfile(@Param("userid") int userid, @Param("profileid") int profileid);
	//@Param("userid") int userid, @Param("profileid") int profileid
}
