package model;

public class User {
	
	private String username;
	private String name;
	private String location;
	private String birthday;
	private String pathPicture;
	private String email;
	private String permissions;
 
	public User()
	{
	}
	
	public String getPermissions() {
		return permissions;
	}
 
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPathPicture() {
		return pathPicture;
	}

	public void setPathPicture(String pathPicture) {
		this.pathPicture = pathPicture;
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
 
}
