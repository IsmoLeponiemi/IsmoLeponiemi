package com.codemen.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemen.models.UserItem;
import com.codemen.repositories.UserItemRepository;

@Service
public class UserItemService {

	@Autowired
	private UserItemRepository userItemRepository;

	public Optional<UserItem> getById(Long id) {
		return userItemRepository.findById(id);
	}

	public Iterable<UserItem> getAll() {
		return userItemRepository.findAll();
	}

	public UserItem save(UserItem userItem) {
		// if (userItem.getId() == null) {
		// userItem.setCreatedAt(Instant.now());
		// }
		// userItem.setUpdatedAt(Instant.now());
		return userItemRepository.save(userItem);
	}

	public void delete(UserItem userItem) {
		userItemRepository.delete(userItem);
	}

	public void readUsersFromURL(String url) {
		// String url = "https://jsonplaceholder.typicode.com/users";

		// Hashtable<Long, User> userTable = new Hashtable<Long, User>();

		try {
			// Create a URL object
			URL apiUrl = new URL(url);

			// Open a connection to the URL
			HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

			// Set request method to GET
			connection.setRequestMethod("GET");

			// Read the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			// Parse JSON data
			JSONArray jsonArray = new JSONArray(response.toString());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject userObject = jsonArray.getJSONObject(i);
				Long id = userObject.getLong("id");
				String name = userObject.getString("name");
				String username = userObject.getString("username");
				String email = userObject.getString("email");

				JSONObject addressObject = userObject.getJSONObject("address");
				String street = addressObject.getString("street");
				String suite = addressObject.getString("suite");
				String city = addressObject.getString("city");
				String zipcode = addressObject.getString("zipcode");

				JSONObject geoObject = addressObject.getJSONObject("geo");
				String lat = geoObject.getString("lat");
				String lng = geoObject.getString("lng");

				String phone = userObject.getString("phone");
				String website = userObject.getString("website");

				JSONObject companyObject = userObject.getJSONObject("company");
				String companyname = companyObject.getString("name");
				String catchPhrase = companyObject.getString("catchPhrase");
				String bs = companyObject.getString("bs");

				UserItem userItem = new UserItem();

				userItem.setId(id);
				userItem.setName(name);
				userItem.setUsername(username);
				userItem.setEmail(email);
				userItem.setStreet(street);
				userItem.setSuite(suite);
				userItem.setCity(city);
				userItem.setZipcode(zipcode);
				userItem.setLat(lat);
				userItem.setLng(lng);
				userItem.setPhone(phone);
				userItem.setWebsite(website);
				userItem.setCompanyname(companyname);
				userItem.setCatchPhrase(catchPhrase);
				userItem.setBs(bs);

				userItemRepository.save(userItem);

				// System.out.println(user.toString());

				// Add new user to the user list
				// userTable.put(id, user);

				// System.out.println("User ID: " + id);
				// System.out.println("Name: " + name);
				// System.out.println("Username: " + username);
				// System.out.println("Email: " + email);
				//
				// System.out.println("Address:");
				// System.out.println(" Street: " + street);
				// System.out.println(" Suite: " + suite);
				// System.out.println(" City: " + city);
				// System.out.println(" Zipcode: " + zipcode);
				// System.out.println(" Street: " + street);
				//
				// System.out.println("Geo:");
				// System.out.println(" Lat: " + lat);
				// System.out.println(" Lng: " + lng);
				//
				// System.out.println("Phone: " + phone);
				// System.out.println("Website: " + website);
				//
				// System.out.println("Company:");
				// System.out.println(" Company Name: " + companyname);
				// System.out.println(" Catch Phrase: " + catchPhrase);
				// System.out.println(" Company Bs: " + bs);
				//
				// System.out.println("------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
