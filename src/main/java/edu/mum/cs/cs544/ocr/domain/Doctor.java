package edu.mum.cs.cs544.ocr.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Doctor {

	@Id
	@GeneratedValue
	@Column(name = "DOCTOR_ID")
	private Long id;

	@NotEmpty(message = "{String.empty}")
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@NotEmpty(message = "{String.empty}")
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@NotEmpty(message = "{String.empty}")
	@Column(name = "PORTFOLIO")
	@Size(max = 4096, message = "{String.maxLength}")
	private String portfolio;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PHONE_ID")
	private Phone phone;

	@Transient
	private MultipartFile picture;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category doctorCategory;
	
	@NotEmpty(message = "{timespan.empty}")
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Timespan> availableTimespans;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	public Category getDoctorCategory() {
		return doctorCategory;
	}

	public void setDoctorCategory(Category doctorCategory) {
		this.doctorCategory = doctorCategory;
	}

	public List<Timespan> getAvailableTimespans() {
		return availableTimespans;
	}

	public void setAvailableTimespans(List<Timespan> availableTimespans) {
		this.availableTimespans = availableTimespans;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", portfolio=" + portfolio
				+ ", address=" + address + ", phone=" + phone + ", picture=" + picture + ", doctorCategory="
				+ doctorCategory + ", availableTimespans=" + availableTimespans + "]";
	}
}