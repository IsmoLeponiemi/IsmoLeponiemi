package com.codemen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codemen.services.UserItemService;

@Controller
public class HomeController {

	@Autowired
	private UserItemService userItemService;
	private boolean usersReadFromURL = false;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");

		if (!usersReadFromURL) {
			String url = "https://jsonplaceholder.typicode.com/users";
			userItemService.readUsersFromURL(url);
			usersReadFromURL = true;
		}

		modelAndView.addObject("userItems", userItemService.getAll());
		return modelAndView;
	}

}
