package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String emailId;
	private String password;
	private int userIsAdmin; // false for user, true for admin

	public Users() {}
	
	public Users(String name, String emailId, String password, int isAdmin) {
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.setUserIsAdmin(userIsAdmin);
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserIsAdmin() {
		return userIsAdmin;
	}

	public void setUserIsAdmin(int userIsAdmin) {
		this.userIsAdmin = userIsAdmin;
	}

	
}
