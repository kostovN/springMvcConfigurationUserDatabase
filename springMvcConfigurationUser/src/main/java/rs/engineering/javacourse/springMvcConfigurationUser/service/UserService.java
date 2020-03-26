package rs.engineering.javacourse.springMvcConfigurationUser.service;

import java.util.List;

import rs.engineering.javacourse.springMvcConfigurationUser.dto.User;


public interface UserService {
	
	void save(User user);
	
	List<User> getAll();
	
	User findById(Long id);

}
