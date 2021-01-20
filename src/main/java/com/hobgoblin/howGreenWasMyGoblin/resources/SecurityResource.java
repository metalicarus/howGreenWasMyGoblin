package com.hobgoblin.howGreenWasMyGoblin.resources;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hobgoblin.howGreenWasMyGoblin.domain.Const;
import com.hobgoblin.howGreenWasMyGoblin.entities.User;

@Controller
public class SecurityResource {

	@RequestMapping(value = "/api/user-auth", method = RequestMethod.GET)
	@ResponseBody
	@Secured({ Const.ROLE_CLIENT, Const.ROLE_ADMIN })
	public User user() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
