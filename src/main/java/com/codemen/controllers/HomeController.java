package com.codemen.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codemen.models.JsonItem;
import com.codemen.models.UserItem;
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

	@GetMapping("/json")
	public ModelAndView json() {
		ModelAndView modelAndView = new ModelAndView("json");

		if (!usersReadFromURL) {
			String url = "https://jsonplaceholder.typicode.com/users";
			userItemService.readUsersFromURL(url);
			usersReadFromURL = true;
		}

		Iterable<UserItem> userItems = userItemService.getAll();
		ArrayList<JsonItem> jsonList = new ArrayList<JsonItem>();

		int userItemSize = 0;
		for (UserItem userItem : userItems) {
			userItemSize++;
		}

		int itemNumber = 0;
		for (UserItem userItem : userItems) {
			itemNumber++;
			JsonItem jsonItem = new JsonItem();
			boolean isLast = (itemNumber == userItemSize);
			jsonItem.addJsonRow(userItem, isLast);
			jsonList.add(jsonItem);
		}

		modelAndView.addObject("jsonItems", jsonList);
		return modelAndView;
	}

}
