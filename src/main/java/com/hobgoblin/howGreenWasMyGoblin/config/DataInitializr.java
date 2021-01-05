package com.hobgoblin.howGreenWasMyGoblin.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.hobgoblin.howGreenWasMyGoblin.domain.Const;
import com.hobgoblin.howGreenWasMyGoblin.entities.Role;
import com.hobgoblin.howGreenWasMyGoblin.entities.User;
import com.hobgoblin.howGreenWasMyGoblin.repositories.RoleRepository;
import com.hobgoblin.howGreenWasMyGoblin.repositories.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<User> users = userRepository.findAll();
		if(users.isEmpty()) {
            createUser("Mateus", "mateus@verdemeuduende.com.br", passwordEncoder.encode("123456"), Const.ROLE_ADMIN);
            createUser("Renata", "renata@verdemeuduende.com.br", passwordEncoder.encode("123456"), Const.ROLE_ADMIN);

		}
		
	}

    public void createUser(String name, String email, String password, String roleName) {
        Role role = new Role(roleName);
        this.roleRepository.save(role);
        User user = new User(name, email, password, Arrays.asList(role));
        userRepository.save(user);	 
	}

}
