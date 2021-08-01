
public class Agent {
	private int agentNumber;
	private String name;
	private String birthdate;
	private String address;
	private String town;
	private String city;
	private String phone;
	private String gender;
	private double salary=2000;
	private boolean flag=true;
	private int agencyID;
	
	public Agent(int agentNumber, String name, String birthdate, String address, String town, String city, String phone,
			String gender, int agencyID) {
		this.agentNumber = agentNumber;
		this.name = name;
		this.birthdate = birthdate;
		this.address = address;
		this.town = town;
		this.city = city;
		this.phone = phone;
		this.gender = gender;
		this.agencyID=agencyID;
	}
	
	public int getAgencyID() {
		return agencyID;
	}

	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}

	public int getAgentNumber() {
		return agentNumber;
	}

	public void setAgentNumber(int agentNumber) {
		this.agentNumber = agentNumber;
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

	public int agentNumber() {
		return agentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
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