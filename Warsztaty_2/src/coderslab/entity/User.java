
package coderslab.entity;

public class User {
	
	protected String email ; 
	protected String name ; 
	protected String surname; 
	protected String password;
	protected int id ;
	public User(int id , String email, String name, String surname, String password) {
		this.id = id ; 
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}
	

	public User() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
//	  @Override
//	    public String toString() {
//	        return "User{" +
//	                "id=" + id +
//	                ", name='" + name + '\'' +
//	                ", surname='" + surname + '\'' +
//	                ", email='" + email + '\'' +
//	                ", password='" + password + '\'' +
//	                '}';
//	}


	
}
