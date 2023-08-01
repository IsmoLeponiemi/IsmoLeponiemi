package com.codemen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadUsersFromURL2 {
	public static void main(String[] args) {
		String url = "https://jsonplaceholder.typicode.com/users";

		Hashtable<Long, User> userTable = new Hashtable<Long, User>();

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

				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setUsername(username);
				user.setEmail(email);
				user.setStreet(street);
				user.setSuite(suite);
				user.setCity(city);
				user.setZipcode(zipcode);
				user.setLat(lat);
				user.setLng(lng);
				user.setPhone(phone);
				user.setWebsite(website);
				user.setCompanyname(companyname);
				user.setCatchPhrase(catchPhrase);
				user.setBs(bs);

				// System.out.println(user.toString());

				// Add new user to the user list
				userTable.put(id, user);

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

		listUsers(userTable);

		System.out.println("------------------------");

		removeUser(2L, userTable);
		listUsers(userTable);

		// for (Enumeration<User> e = userTable.elements(); e.hasMoreElements();) {
		// User u = e.nextElement();
		// System.out.println(u.toString());
		// }

		// User user1 = userTable.get(1);
		// System.out.println(user1.toString());

	}

	public static void listUsers(Hashtable<Long, User> userTable) {
		// Step 1: Convert Hashtable to a List of Map.Entry objects
		List<Map.Entry<Long, User>> list = new ArrayList<>(userTable.entrySet());

		// Step 2: Sort the List based on the keys using a Comparator
		Collections.sort(list, new Comparator<Map.Entry<Long, User>>() {
			@Override
			public int compare(Map.Entry<Long, User> entry1, Map.Entry<Long, User> entry2) {
				User user1 = entry1.getValue();
				String name1 = user1.getName();
				User user2 = entry2.getValue();
				String name2 = user2.getName();

				return (name1 != null) ? name1.compareTo(name2) : -1;

				// return entry1.getKey().compareTo(entry2.getKey());
			}
		});

		// Step 3: Create a new LinkedHashMap and add the sorted entries
		LinkedHashMap<Long, User> sortedHashtable = new LinkedHashMap<>();
		for (Map.Entry<Long, User> entry : list) {
			sortedHashtable.put(entry.getKey(), entry.getValue());
		}

		// Display the sorted Hashtable
		for (Map.Entry<Long, User> entry : sortedHashtable.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}

	// for (Enumeration<User> e = userTable.elements(); e.hasMoreElements();) {
	// User u = e.nextElement();
	// System.out.println(u.toString());
	// }
	// }

	public static void removeUser(Long id, Hashtable<Long, User> userTable) {
		User user = userTable.get(id);

		if (user != null) {
			userTable.remove(id);
		}
	}
}
