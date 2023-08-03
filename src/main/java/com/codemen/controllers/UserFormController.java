package com.codemen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codemen.models.UserItem;
import com.codemen.services.UserItemService;

import jakarta.validation.Valid;

@Controller
public class UserFormController {
	@Autowired
	private UserItemService userItemService;

	@PostMapping("/json")
	public String showjSONForm(BindingResult result, Model model) {
		return "json";
	}

	@GetMapping("/create-user")
	public String showCreateForm(UserItem userItem) {
		return "new-user-item";
	}

	@PostMapping("/user")
	public String createUserItem(@Valid UserItem userItem, BindingResult result, Model model) {
		UserItem item = new UserItem();

		item.setName(userItem.getName());
		item.setUsername(userItem.getUsername());
		item.setEmail(userItem.getEmail());
		item.setStreet(userItem.getStreet());
		item.setSuite(userItem.getSuite());
		item.setCity(userItem.getCity());
		item.setZipcode(userItem.getZipcode());
		item.setLat(userItem.getLat());
		item.setLng(userItem.getLng());
		item.setPhone(userItem.getPhone());
		item.setWebsite(userItem.getWebsite());
		item.setCompanyname(userItem.getCompanyname());
		item.setCatchPhrase(userItem.getCatchPhrase());
		item.setBs(userItem.getBs());

		userItemService.save(userItem);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteUserItem(@PathVariable("id") Long id, Model model) {
		UserItem userItem = userItemService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("UserItem id: " + id + " not found"));

		userItemService.delete(userItem);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		UserItem userItem = userItemService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("UserItem id: " + id + " not found"));

		model.addAttribute("user", userItem);
		return "edit-user-item";
	}

	@PostMapping("/user/{id}")
	public String updateUserItem(@PathVariable("id") Long id, @Valid UserItem userItem, BindingResult result,
			Model model) {

		UserItem item = userItemService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("UserItem id: " + id + " not found"));

		item.setName(userItem.getName());
		item.setUsername(userItem.getUsername());
		item.setEmail(userItem.getEmail());
		item.setStreet(userItem.getStreet());
		item.setSuite(userItem.getSuite());
		item.setCity(userItem.getCity());
		item.setZipcode(userItem.getZipcode());
		item.setLat(userItem.getLat());
		item.setLng(userItem.getLng());
		item.setPhone(userItem.getPhone());
		item.setWebsite(userItem.getWebsite());
		item.setCompanyname(userItem.getCompanyname());
		item.setCatchPhrase(userItem.getCatchPhrase());
		item.setBs(userItem.getBs());

		userItemService.save(item);

		return "redirect:/";
	}
}
