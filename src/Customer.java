
public class Customer {
	private int customerNumber;
	private String name;
	private String birthdate;
	private String address;
	private String town;
	private String city;
	private String phone;
	private String gender;
	private boolean flag = true;

	public Customer(int customerNumber, String name, String birthdate, String address, String town, String city,
			String phone, String gender) {

		this.customerNumber = customerNumber;
		this.name = name;
		this.birthdate = birthdate;
		this.address = address;
		this.town = town;
		this.city = city;
		this.phone = phone;
		this.gender = gender;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getcustomerNumber() {
		return customerNumber;
	}

	public void setcustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// display method
	public void display() {

		System.out.println("name : " + name);
		System.out.println("birtdate : " + birthdate);
		System.out.println("address : " + address);
		System.out.println("town : " + town);
		System.out.println("city : " + city);
		System.out.println("phone : " + phone);
		System.out.println("gender : " + gender);

	}

}