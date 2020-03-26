package rs.engineering.javacourse.springMvcConfigurationUser.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.springMvcConfigurationUser.dto.User;
import rs.engineering.javacourse.springMvcConfigurationUser.repository.UserRepository;


@Repository(value = "userJdbcRepository")
public class UserJdbcRepository implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

//	public UserJdbcRepository(DataSource dataSource) {
//		System.out.println("Constructor: UserJdbcRepository(DataSource dataSource)...start");
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//		System.out.println("Constructor: UserJdbcRepository(DataSource dataSource)...end");
//	}

	@Override
	public void save(User user) {
		System.out.println("UserJdbcRepository...... save().....");
		jdbcTemplate.update("insert into user (firstname,lastname,username,password)" + " values(?,?,?,?)",
				user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword());
		System.out.println("end....");

	}

	@Override
	public List<User> getAll() {
		String query = "select * from user";
		return jdbcTemplate.query(query, new UserMapper());
	}

	@Override
	public User findById(Long id) {
		String query = "select * from user where id = ?";
		return jdbcTemplate.queryForObject(query,new Object[] {id}, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("Row number: " + rowNum);
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			
		});
		
		
	}
}

class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("Row number: " + rowNum);
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
