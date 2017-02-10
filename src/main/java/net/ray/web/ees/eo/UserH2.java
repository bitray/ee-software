package net.ray.web.ees.eo;

public class UserH2 {
	private Integer id;
	private String name;
	private String username;

	public String getUsername() {
		return "convert="+name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
