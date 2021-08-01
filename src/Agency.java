
public class Agency {
	private int agencyNumber;
	private String name;
	private String address;
	private String town;
	private String city;
	private String phone;
	private double income = 0;

	public Agency(int agencyNumber, String name, String address, String town, String city, String phone,
			double income) {

		this.agencyNumber = agencyNumber;
		this.name = name;
		this.address = address;
		this.town = town;
		this.city = city;
		this.phone = phone;

	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(int agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	// display method
	public void display() {
		System.out.println("name : " + name);
		System.out.println("address : " + address);
		System.out.println("town : " + town);
		System.out.println("city : " + city);
		System.out.println("phone : " + phone);

	}

}