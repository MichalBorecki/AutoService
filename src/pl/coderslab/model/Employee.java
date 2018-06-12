package pl.coderslab.model;

public class Employee {


	public Employee() {
		super();
	}
	
	public Employee(int id, String firstName, String lastName, String address, int telephone, String note,
		Double costOfOneHour) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telephone = telephone;
		this.note = note;
		this.costOfOneHour = costOfOneHour;
	}
	
	public Employee(String firstName, String lastName, String address, int telephone, String note,
		Double costOfOneHour) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telephone = telephone;
		this.note = note;
		this.costOfOneHour = costOfOneHour;
	}
	
	private int id = 0;
	private String firstName = "";
	private String lastName = "";
	private String address = "";
	private int telephone = 0;
	private String note = "";
	private Double costOfOneHour = 0.0;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Double getCostOfOneHour() {
		return costOfOneHour;
	}
	public void setCostOfOneHour(Double costOfOneHour) {
		this.costOfOneHour = costOfOneHour;
	}
	
}
