package com.codemen.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codemen.models.UserItem;
import com.codemen.repositories.UserItemRepository;

@SpringBootTest
class UserItemServiceTest {

	@Autowired
	private UserItemService service;

	@Autowired
	private UserItemRepository repository;

	@AfterEach
	void deleteAllItems() {
		repository.deleteAll();
	}

	@Test
	@DisplayName("find a given UserItem by its Id")
	void findAUserItemById() {
		// find a specific UserItem by its id
		UserItem item = new UserItem();
		item.setName("user item1");
		// item.setIsComplete(false);

		item = service.save(item);

		Optional<UserItem> testItem = service.getById(item.getId());
		assertEquals(testItem.isPresent(), true);
		assertEquals(testItem.get().getId(), item.getId());
	}

	@Test
	void getAllUserItems() {

		UserItem item1 = new UserItem();
		item1.setName("user name 1");
		// item1.setIsComplete(false);

		item1 = service.save(item1);

		UserItem item2 = new UserItem();
		item2.setName("user name 2");
		// item2.setIsComplete(false);

		item2 = service.save(item2);

		Iterable<UserItem> items = service.getAll();
		List<UserItem> list = new ArrayList<>();
		items.iterator().forEachRemaining(list::add);
		assertNotEquals(list.size(), 0);
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).getId(), item1.getId());
		assertEquals(list.get(1).getId(), item2.getId());
	}

	@Test
	void savingAValidUserItemSucceeds() {
		UserItem item = new UserItem();
		item.setName("user name 1");
		// item.setIsComplete(false);

		item = service.save(item);
		assertNotEquals(item.getId(), null);
	}

	@Test
	void savingAnInvalidUserItemFails() {

		UserItem item = new UserItem();
		Exception exception = assertThrows(Exception.class, () -> service.save(item));
		assertEquals("Could not commit JPA transaction", exception.getMessage());
	}

	@Test
	void deletingAValidUserItemSucceeds() {
		UserItem item = new UserItem();
		item.setName("user name 1");
		// item.setIsComplete(false);

		item = service.save(item);
		service.delete(item);

		Iterable<UserItem> items = service.getAll();
		List<UserItem> list = new ArrayList<>();
		items.iterator().forEachRemaining(list::add);
		assertEquals(list.size(), 0);
	}
}