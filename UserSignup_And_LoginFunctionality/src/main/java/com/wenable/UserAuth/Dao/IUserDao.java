package com.wenable.UserAuth.Dao;

import com.wenable.UserAuth.customException.EmailAlreadyExistException;
import com.wenable.UserAuth.customException.UserAlreadyExistException;
import com.wenable.UserAuth.entity.User;

public interface IUserDao {

	public boolean existsByUserName(String userName)throws UserAlreadyExistException;

	public User findByUserName(String email); 

	public  User save(User user);
	
	public boolean existsByEmail(String email) throws EmailAlreadyExistException ;
}
