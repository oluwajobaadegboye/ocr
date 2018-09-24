package edu.mum.cs.cs544.ocr.domain;


import edu.mum.cs.cs544.ocr.validator.PasswordFeildConstraint;
import edu.mum.cs.cs544.ocr.validator.PasswordsEqualConstraint;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity(name = "USERS")
@PasswordsEqualConstraint
public class Credentials {

	@Id
	@Column(name = "USERNAME", nullable = false, unique = true,length = 100)

	@NotEmpty
    String username;

	@Column(name = "PASSWORD", nullable = false)
	@NotEmpty
	@PasswordFeildConstraint
    String password;
	
	@NotEmpty
	@Transient
    String verifyPassword;

	Boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    List<Authority> authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

}
