package com.codemen.models;

import java.io.Serializable;

public class JsonItem implements Serializable {
	private static final long serialVersionUID = 1L;

	public String id;
	public String name;
	public String username;
	public String email;
	public String street;
	public String suite;
	public String city;
	public String zipcode;
	public String lat;
	public String lng;
	public String phone;
	public String website;
	public String companyname;
	public String catchPhrase;
	public String bs;
	public String comma;

//	  {
//		    "id": 1,
//		    "name": "Leanne Graham",
//		    "username": "Bret",
//		    "email": "Sincere@april.biz",
//		    "address": {
//		      "street": "Kulas Light",
//		      "suite": "Apt. 556",
//		      "city": "Gwenborough",
//		      "zipcode": "92998-3874",
//		      "geo": {
//		        "lat": "-37.3159",
//		        "lng": "81.1496"
//		      }
//		    },
//		    "phone": "1-770-736-8031 x56442",
//		    "website": "hildegard.org",
//		    "company": {
//		      "name": "Romaguera-Crona",
//		      "catchPhrase": "Multi-layered client-server neural-net",
//		      "bs": "harness real-time e-markets"
//		    }
//		  },

	public void addJsonRow(UserItem userItem, boolean isLast) {
		id = "  \"id\": " + userItem.getId() + ",";
		name = "  \"name\": \"" + userItem.getName() + "\",";
		username = "  \"username\": \"" + userItem.getUsername() + "\",";
		email = "  \"email\": \"" + userItem.getEmail() + "\",";
		// address
		street = "  \"street\": \"" + userItem.getStreet() + "\",";
		suite = "  \"suite\": \"" + userItem.getSuite() + "\",";
		city = "  \"city\": \"" + userItem.getCity() + "\",";
		zipcode = "  \"zipcode\": \"" + userItem.getZipcode() + "\",";
		// geo
		lat = "  \"lat\": \"" + userItem.getLat() + "\",";
		lng = "  \"lng\": \"" + userItem.getLng() + "\"";
		//
		phone = "  \"phone\": \"" + userItem.getPhone() + "\",";
		website = "  \"website\": \"" + userItem.getWebsite() + "\",";
		// company
		companyname = "  \"name\": \"" + userItem.getCompanyname() + "\", ";
		catchPhrase = "  \"catchPhrase\": \"" + userItem.getCatchPhrase() + "\", ";
		bs = "  \"bs\": \"" + userItem.getBs() + "\", ";

		comma = (!isLast) ? comma = "}," : "}";
	}
}
