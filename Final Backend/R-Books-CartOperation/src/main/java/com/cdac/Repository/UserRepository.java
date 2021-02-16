package com.cdac.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdac.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByEmailAndPassword(String email, String password);
	//public User updatePassword(String email);
	
	public User findByUserId(int userId);
	//public boolean isUserPresent()
	public boolean existsById(int userId);
	
	//public User findByUserEmail(String email);

	public User findByEmail(String email);
	
	
	@Modifying
	@Transactional
	@Query(value="update user u set u.password=:password where u.email=:email",nativeQuery = true)
	public void updatePass(@Param(value = "email") String email,@Param(value = "password") String password);
}
