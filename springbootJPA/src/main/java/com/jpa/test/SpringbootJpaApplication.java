package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.*;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJpaApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);

		/*
		 * save
		 * 
		 * 
		 * User user = new User(); user.setName("Sourav Adak");
		 * user.setCity("Rourkela"); user.setStatus("I am programmer");
		 * 
		 * User user2 = repository.save(user); System.out.println(user2);
		 */

		/*
		 * save all
		 * 
		 * 
		 * User user = new User(); user.setName("Vikash Adak");
		 * user.setCity("Rourkela"); user.setStatus("I am MBA");
		 * 
		 * 
		 * User user2 = new User(); user2.setName("Tanmay Adak");
		 * user2.setCity("Rourkela"); user2.setStatus("I am ETC Engineer");
		 * 
		 * List<User> li = List.of(user,user2);
		 * 
		 * Iterable<User> it = repository.saveAll(li);
		 * 
		 * for(User disp:it) { System.out.println(disp); }
		 */

		/*
		 * update
		 * 
		 * 
		 * Optional<User> op = repository.findById(1); User user = op.get();
		 * user.setName("Sourav Ganguli"); User user2 = repository.save(user);
		 * System.out.println(user2);
		 */

		/*
		 * Delete
		 * 
		 * 
		 * repository.deleteById(3); System.out.println("deleted");
		 */

		/*
		 * View all
		 * 
		 * Iterable<User> iterable = repository.findAll(); iterable.forEach(user ->
		 * System.out.println(user));
		 */
		//

		/*
		 * List<User> findbyname = repository.findByName("Vikash Adak");
		 * findbyname.forEach(e -> System.out.println(e));
		 * 
		 * 
		 * List<User> findbynameandcity =
		 * repository.findByNameAndCity("Sourav Ganguli","Rourkela");
		 * findbynameandcity.forEach(e->System.out.println(e));
		 * 
		 *
		 */
		
		/*
		 * List<User> u = repository.getAllUser(); u.forEach(e->System.out.println(e));
		 */
		
		/*
		 * List<User> u = repository.getUserByName("Sourav Ganguli");
		 * u.forEach(e->System.out.println(e));
		 */
		
		List<User> u1 = repository.getUsers();
		u1.forEach(e->System.out.println(e));
		
	}

}
