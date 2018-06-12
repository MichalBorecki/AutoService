package pl.coderslab.model;

public class Status {

	private String statusStr = "";

	public Status(String status) {
		super();
		if (status.equals("1")) {
			this.statusStr = "Przyjęty";
		} else if (status.equals("2")) {
			this.statusStr = "Zatwierdzone koszty naprawy";
		} else if (status.equals("3")) {
			this.statusStr = "W naprawie";
		} else if (status.equals("4")) {
			this.statusStr = "Gotowy do odbioru";
		} else if (status.equals("5")) {
			this.statusStr = "Rezygnacja";
		}

	}

	public Status() {
	}

	public String getStatus() {
		return statusStr;
	}

	public void setStatus(String status) {
		if (status.equals("1")) {
			this.statusStr = "Przyjęty";
		} else if (status.equals("2")) {
			this.statusStr = "Zatwierdzone koszty naprawy";
		} else if (status.equals("3")) {
			this.statusStr = "W naprawie";
		} else if (status.equals("4")) {
			this.statusStr = "Gotowy do odbioru";
		} else if (status.equals("5")) {
			this.statusStr = "Rezygnacja";
		} 
	}
}
