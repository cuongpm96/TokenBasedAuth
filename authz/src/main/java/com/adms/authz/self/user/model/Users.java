package com.adms.authz.self.user.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;

	@Column(name = "email", unique=true)
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String password;

	@Column(name = "first_name")
	// @NotEmpty(message = "*Please provide your first name")
	private String name;

	@Column(name = "last_name")
	// @NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Column(name = "date_of_birth")
	private Date dob;

	@Column(name = "current_grade")
	private String grade;

	@Column(name = "gender")
	private String gender;

	@Column(name = "mobile_number")
	// @Length(min = 7, message = "*Your phone number must have at least 7
	// digit")
	private Integer mobileNumber;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "enabled")
	private boolean active;

	@Column(name = "Is_Term_Of_Use_Accepted")
	private boolean isTOSAccepted;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isTOSAccepted() {
		return isTOSAccepted;
	}

	public void setTOSAccepted(boolean isTOSAccepted) {
		this.isTOSAccepted = isTOSAccepted;
	}

	public Date getDob() {
		return dob;
	}

	public String getGrade() {
		return grade;
	}

	public String getGender() {
		return gender;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
