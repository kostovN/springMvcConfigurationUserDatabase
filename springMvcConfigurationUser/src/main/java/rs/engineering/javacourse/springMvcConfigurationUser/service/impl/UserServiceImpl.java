package rs.engineering.javacourse.springMvcConfigurationUser.service.impl;

import java.util.List;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.engineering.javacourse.springMvcConfigurationUser.dto.User;
import rs.engineering.javacourse.springMvcConfigurationUser.repository.UserRepository;
import rs.engineering.javacourse.springMvcConfigurationUser.service.UserService;


@Service(value = "userService")
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Override
	public void save(User user) {
		System.out.println("UserService......save().....start");
		userRepository.save(user);
		System.out.println("UserService......save().....end");
	}

	@Override
	public List<User> getAll() {
		return userRepository.getAll();
	}

	@Override
	public User findById(Long id) {
		
		return userRepository.findById(id);
	}

	

}
