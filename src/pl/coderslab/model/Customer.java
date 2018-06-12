package pl.coderslab.model;

public class Customer {

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String email, String dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		// If dateOfBirth is empty, value stay on null
		if (!(dateOfBirth == "")) {
			this.dateOfBirth = dateOfBirth;
		} 

	}

	public Customer(int id, String firstName, String lastName, String email, String dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		if (!(dateOfBirth == "")) {
			this.dateOfBirth = dateOfBirth;
		} 

	}

	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	private int id = 0;
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String dateOfBirth = null;

	// getId required in ClientEdit
	public int getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
