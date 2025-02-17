package net.codejava.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired private UserRepository repo;
	
	@Test
	public void testCreateUser() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode("nam2022");
		
		User newUser = new User("test2@codejava.net", password);
		User savedUser = repo.save(newUser);
		
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
	}

	@Test
	public void testAssignRoleToUser() {
		Integer userId = 1;
		Integer roleId = 1;
		User user = repo.findById(userId).get();
		user.addRole(new Role(roleId));

		User updatedUser = repo.save(user);
		assertThat(updatedUser.getRoles()).hasSize(1);

	}
	@Test
	public void testAssignRoleToUser2() {
		Integer userId = 5;
		User user = repo.findById(userId).get();
		user.addRole(new Role(2));
		user.addRole(new Role(3));

		User updatedUser = repo.save(user);
		assertThat(updatedUser.getRoles()).hasSize(2);
	}
}
