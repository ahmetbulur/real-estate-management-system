
public class Contract {

	private int contractNumber;
	private int estateNumber;
	private int customerNumber;
	private int agentNumber;
	private Date date;
	private String day;
	private String month;
	private String year;

	public Contract(int contractNumber, int estateNumber, int customerNumber, int agentNumber, String day, String month,
			String year) {

		this.contractNumber = contractNumber;
		this.agentNumber = agentNumber;
		this.estateNumber = estateNumber;
		this.customerNumber = customerNumber;

		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}

	public int getAgentNumber() {
		return agentNumber;
	}

	public void setAgentNumber(int agentNumber) {
		this.agentNumber = agentNumber;
	}

	public int getEstateNumber() {
		return estateNumber;
	}

	public void setEstateNumber(int estateNumber) {
		this.estateNumber = estateNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// display method
	public void display() {
		System.out.println("real estate number : " + estateNumber);
		System.out.println("customer number : " + customerNumber);
		System.out.println("agent number : " + agentNumber);

		System.out.println("date : " + day + "/" + month + "/" + year);

	}

}