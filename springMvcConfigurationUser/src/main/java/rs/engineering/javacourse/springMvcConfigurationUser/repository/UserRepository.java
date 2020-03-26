package rs.engineering.javacourse.springMvcConfigurationUser.repository;

import java.util.List;

import rs.engineering.javacourse.springMvcConfigurationUser.dto.User;


public interface UserRepository {
	void save(User user);
	List<User> getAll();
	User findById(Long id);

}
