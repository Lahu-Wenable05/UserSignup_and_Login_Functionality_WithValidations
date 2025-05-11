package com.wenable.UserAuth.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wenable.UserAuth.customException.EmailAlreadyExistException;
import com.wenable.UserAuth.customException.UserAlreadyExistException;
import com.wenable.UserAuth.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

//    boolean existsByEmail(String email);
	boolean existsByUserName(String userName) throws UserAlreadyExistException;
	public boolean existsByEmail(String email)throws EmailAlreadyExistException;
	public User findByUserName(String userName);
//	public User findByEmail(String email) throws EmailAlreadyExistException;

}
