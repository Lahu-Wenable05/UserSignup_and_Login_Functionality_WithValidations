package com.wenable.UserAuth.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wenable.UserAuth.Repository.UserRepository;
import com.wenable.UserAuth.customException.EmailAlreadyExistException;
import com.wenable.UserAuth.customException.UserAlreadyExistException;
import com.wenable.UserAuth.entity.User;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User save(User user) { 
		return userRepo.save(user);
	}

	@Override
	public boolean existsByUserName(String userName) throws UserAlreadyExistException {
		if (userRepo.existsByUserName(userName)) {
			throw new UserAlreadyExistException("User Name Already exisit..");
		} else {
			return true;
		} 
	}

	@Override
	public User findByUserName(String userName) {

		return userRepo.findByUserName(userName);
	}

	@Override
	public boolean existsByEmail(String email) throws EmailAlreadyExistException {
		if(userRepo.existsByEmail(email)) {
			throw new EmailAlreadyExistException("User already exist with this email");
		}
		return true; 
	}  

//	@Override
//	public User findByEmail(String email)throws EmailAlreadyExistException {
//		return userRepo.findByEmail(email);
//	}

}
