package pl.coderslab.model;

public class Order {

	private int id = 0;
	private String orderDate = null;
	private String plannedServiceStart = null;
	private String serviceStartDate = null;
	private String serviceEndDate = null;
	private int employeeId = 0;
	private String descriptionOfProblem = "";
	private String descriptionOfRepair = "";
	private String status = "";
	private int vehicleId = 0;
	private Double costForCustomer = 0.0;
	private Double costOfSpareParts = 0.0;
	private Double costOfOneHour = 0.0;
	private Double repairTime = 0.0;

	public Order() {
		super();
	}

	public Order(int id, String orderDate, String plannedServiceStart, String serviceStartDate, String serviceEndDate, int employeeId,
		String descriptionOfProblem, String descriptionOfRepair, String status, int vehicleId, Double costForCustomer,
		Double costOfSpareParts, Double costOfOneHour, Double repairTime) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		if (!(plannedServiceStart == "")) {
			this.plannedServiceStart = plannedServiceStart;
		}
		if (!(serviceStartDate == "")) {
			this.serviceStartDate = serviceStartDate;
		}
		if (!(serviceEndDate == "")) {
			this.serviceEndDate = serviceEndDate;
		}
		this.employeeId = employeeId;
		this.descriptionOfProblem = descriptionOfProblem;
		this.descriptionOfRepair = descriptionOfRepair;
		this.status = status;
		this.vehicleId = vehicleId;
		this.costForCustomer = costForCustomer;
		this.costOfSpareParts = costOfSpareParts;
		this.costOfOneHour = costOfOneHour;
		this.repairTime = repairTime;
	}

	public Order(String orderDate, String plannedServiceStart, String serviceStartDate, String serviceEndDate, int employeeId,
		String descriptionOfProblem, String descriptionOfRepair, String status, int vehicleId, Double costForCustomer,
		Double costOfSpareParts, Double costOfOneHour, Double repairTime) {
		super();
		this.orderDate = orderDate;
		if (!(plannedServiceStart == "")) {
			this.plannedServiceStart = plannedServiceStart;
		}
		if (!(serviceStartDate == "")) {
			this.serviceStartDate = serviceStartDate;
		}
		if (!(serviceEndDate == "")) {
			this.serviceEndDate = serviceEndDate;
		}
		this.employeeId = employeeId;
		this.descriptionOfProblem = descriptionOfProblem;
		this.descriptionOfRepair = descriptionOfRepair;
		this.status = status;
		this.vehicleId = vehicleId;
		this.costForCustomer = costForCustomer;
		this.costOfSpareParts = costOfSpareParts;
		this.costOfOneHour = costOfOneHour;
		this.repairTime = repairTime;
	}
	
	public Order(int employeeId, Double repairTime) {
		super();
		this.employeeId = employeeId;
		this.repairTime = repairTime;
	}


	/*
	 * Constructor without employeeId
	 */
	public Order(String orderDate, String plannedServiceStart, String serviceStartDate, String serviceEndDate, String descriptionOfProblem,
		String descriptionOfRepair, String status, int vehicleId, Double costForCustomer,
		Double costOfSpareParts, Double costOfOneHour, Double repairTime) {
		super();
		this.orderDate = orderDate;
		if (!(plannedServiceStart == "")) {
			this.plannedServiceStart = plannedServiceStart;
		}
		if (!(serviceStartDate == "")) {
			this.serviceStartDate = serviceStartDate;
		}
		if (!(serviceEndDate == "")) {
			this.serviceEndDate = serviceEndDate;
		}
		this.descriptionOfProblem = descriptionOfProblem;
		this.descriptionOfRepair = descriptionOfRepair;
		this.status = status;
		this.vehicleId = vehicleId;
		this.costForCustomer = costForCustomer;
		this.costOfSpareParts = costOfSpareParts;
		this.costOfOneHour = costOfOneHour;
		this.repairTime = repairTime;
	}

	public Order(int id, String serviceStartDate, String descriptionOfRepair) {
		super();
		this.id = id;
		if (!(serviceStartDate == "")) {
			this.serviceStartDate = serviceStartDate;
		}
		this.descriptionOfRepair = descriptionOfRepair;
	}

	public int getId() {
		return id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getPlannedServiceStart() {
		return plannedServiceStart;
	}

	public void setPlannedServiceStart(String plannedServiceStart) {
		this.plannedServiceStart = plannedServiceStart;
	}

	public String getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(String serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public String getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDescriptionOfProblem() {
		return descriptionOfProblem;
	}

	public void setDescriptionOfProblem(String descriptionOfProblem) {
		this.descriptionOfProblem = descriptionOfProblem;
	}

	public String getDescriptionOfRepair() {
		return descriptionOfRepair;
	}

	public void setDescriptionOfRepair(String descriptionOfRepair) {
		this.descriptionOfRepair = descriptionOfRepair;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Double getCostForCustomer() {
		return costForCustomer;
	}

	public void setCostForCustomer(Double costForCustomer) {
		this.costForCustomer = costForCustomer;
	}

	public Double getCostOfSpareParts() {
		return costOfSpareParts;
	}

	public void setCostOfSpareParts(Double costOfSpareParts) {
		this.costOfSpareParts = costOfSpareParts;
	}

	public Double getCostOfOneHour() {
		return costOfOneHour;
	}

	public void setCostOfOneHour(Double costOfOneHour) {
		this.costOfOneHour = costOfOneHour;
	}

	public Double getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(Double repairTime) {
		this.repairTime = repairTime;
	}

}
