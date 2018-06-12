package pl.coderslab.model;

public class Vehicle {

	public Vehicle() {
		super();
	}
	public Vehicle(int id, String model, String manufacturer, int year, String registrationNo, int customerId,
		String nextServicingDate) {
		super();
		this.id = id;
		this.model = model;
		this.manufacturer = manufacturer;
		this.year = year;
		this.registrationNo = registrationNo;
		this.customerId = customerId;
		this.nextServicingDate = nextServicingDate;
	}
	public Vehicle(String model, String manufacturer, int year, String registrationNo, int customerId,
		String nextServicingDate) {
		super();
		this.model = model;
		this.manufacturer = manufacturer;
		this.year = year;
		this.registrationNo = registrationNo;
		this.customerId = customerId;
		this.nextServicingDate = nextServicingDate;
	}
	
	private int id = 0;
	private String model ="";
	private String manufacturer ="";
	private int year = 0;
	private String registrationNo ="";
	private int customerId = 0;
	private String nextServicingDate ="";
	
	public int getId() {
		return id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getNextServicingDate() {
		return nextServicingDate;
	}
	public void setNextServicingDate(String nextServicingDate) {
		this.nextServicingDate = nextServicingDate;
	}
	
	
}
