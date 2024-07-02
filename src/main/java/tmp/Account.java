package tmp;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable{
	private int id;
	private String name;
	private String password;
	private List<String> imageList;
	private boolean isAdmin;
	
	public Account(int id, String name,String password,List<String> imageList, boolean isAdmin) {
		this.setId(id);
		this.setName(name);
		this.setPassword(password);
		this.setImageList(imageList);
		this.setAdmin(isAdmin);
	}
	
	public Account(String name, String password) {
		this.setName(name);
		this.setPassword(password);
	}

	private void setId(int id) {
		this.id = id;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	private void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
}
