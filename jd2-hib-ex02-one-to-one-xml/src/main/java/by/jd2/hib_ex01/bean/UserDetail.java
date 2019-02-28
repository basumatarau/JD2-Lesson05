package by.jd2.hib_ex01.bean;

import java.sql.Timestamp;

public class UserDetail {

	private int idUserDetails;
	private String country;
	private String city;
	private Timestamp birthday;
	
	public UserDetail() {}

	public UserDetail(String country, String city, Timestamp birthday) {
		super();
		this.country = country;
		this.city = city;
		this.birthday = birthday;
	}

	public int getIdUserDetails() {
		return idUserDetails;
	}

	public void setIdUserDetails(int idUserDetails) {
		this.idUserDetails = idUserDetails;
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

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

}
