package com.codemen;

public class User {
	private Long id;
	private String name;
	private String username;
	private String email;
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private String lat;
	private String lng;
	private String phone;
	private String website;
	private String companyname;
	private String catchPhrase;
	private String bs;

	public static void main(String[] args) {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getStreet() {
		return street;
	}

	public String getSuite() {
		return suite;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getLat() {
		return lat;
	}

	public String getLng() {
		return lng;
	}

	public String getPhone() {
		return phone;
	}

	public String getWebsite() {
		return website;
	}

	public String getCompanyname() {
		return companyname;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setId(Long _id) {
		this.id = _id;
	}

	public void setName(String _name) {
		this.name = _name;
	}

	public void setUsername(String _username) {
		this.username = _username;
	}

	public void setEmail(String _email) {
		this.email = _email;
	}

	public void setStreet(String _street) {
		this.street = _street;
	}

	public void setSuite(String _suite) {
		this.suite = _suite;
	}

	public void setCity(String _city) {
		this.city = _city;
	}

	public void setZipcode(String _zipcode) {
		this.zipcode = _zipcode;
	}

	public void setLat(String _lat) {
		this.lat = _lat;
	}

	public void setLng(String _lng) {
		this.lng = _lng;
	}

	public void setPhone(String _phone) {
		this.phone = _phone;
	}

	public void setWebsite(String _website) {
		this.website = _website;
	}

	public void setCompanyname(String _companyname) {
		this.companyname = _companyname;
	}

	public void setCatchPhrase(String _catchPhrase) {
		this.catchPhrase = _catchPhrase;
	}

	public void setBs(String _bs) {
		this.bs = _bs;
	}

	@Override
	public String toString() {
		return "User [User ID=" + id + ", Name=" + name + ", Username=" + username + ", eMail=" + email + ", Street="
				+ street + ", Suite=" + suite + ", City=" + city + ", Zipcode=" + zipcode + ", Lat=" + lat + ", Lng="
				+ lng + ", Phone=" + phone + ", Website=" + website + ", Companyname=" + companyname + ", CatchPhrase="
				+ catchPhrase + ", Bs=" + bs + "]";
	}

}
