/**
 * 
 */
package com.ashish.spring.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashish.spring.web.dao.User;
import com.ashish.spring.web.service.UsersService;

/**
 * @author ashish
 * 
 */
@Controller
public class LoginController {

	private UsersService	usersService;

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/logout")
	public String showLoggedOut() {
		return "logout";
	}

	@RequestMapping("/newAccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newAccount";
	}

	@RequestMapping("/createAccount")
	public String createAccount() {
		return "accountCreated";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(Model model, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "newAccount";
		}

		user.setAuthority("user");
		user.setEnabled(true);

		if (usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newAccount";
		}
		usersService.createUser(user);
		System.out.println(user);
		return "accountCreated";
	}

}
