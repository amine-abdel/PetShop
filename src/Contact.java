
public class Contact {
 
	public Contact() {
		super();
	}

	public Contact(String name, String company, String phone, String email, String message) {
		super();
		this.name = name;
		this.company = company;
		this.phone = phone;
		this.email = email;
		this.message = message;
	}

	private String name,company,phone,email,message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
