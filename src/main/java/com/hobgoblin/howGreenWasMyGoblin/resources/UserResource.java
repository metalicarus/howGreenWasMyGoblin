package com.hobgoblin.howGreenWasMyGoblin.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hobgoblin.howGreenWasMyGoblin.domain.Const;
import com.hobgoblin.howGreenWasMyGoblin.entities.User;
import com.hobgoblin.howGreenWasMyGoblin.repositories.interaces.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Secured({ Const.ROLE_ADMIN })
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User user) {
		user = this.userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@Secured({ Const.ROLE_ADMIN })
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<User> edit(@RequestBody User user) {
		user = this.userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@Secured({ Const.ROLE_CLIENT, Const.ROLE_ADMIN })
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Page<User>> list(@RequestParam("page") int page, @RequestParam("size") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
		return new ResponseEntity<Page<User>>(userRepository.findAll(pageable), HttpStatus.OK);
	}
}
