package ru.kpfu.AminovNiaz.entities;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private String country;
	private String city;
	private String date;
	
	public User(int id, String name, String email, String password, String country, String city, String date) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
		this.city = city;
		this.date = date;
	}
	
	public User(String name, String email, String password, String country, String city, String date) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
		this.city = city;
		this.date = date;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
