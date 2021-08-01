
public class RealEstate {
	private int estateNumber;
	private String type;
	private String status;
	private boolean availability = true;
	private String address;
	private String town;
	private String city;
	private int surface_area;
	private int price;
	private int rooms;
	private boolean flag = true;

	public RealEstate(int estateNumber, String type, String status, boolean availability, String address, String town,
			String city, int surface_area, int price, int rooms) {
		this.estateNumber = estateNumber;
		this.type = type;
		this.status = status;
		this.availability = availability;
		this.address = address;
		this.town = town;
		this.city = city;
		this.surface_area = surface_area;
		this.price = price;
		this.rooms = rooms;

	}

	public int getestateNumber() {
		return estateNumber;
	}

	public int getEstateNumber() {
		return estateNumber;
	}

	public void setEstateNumber(int estateNumber) {
		this.estateNumber = estateNumber;
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

	public void setestateNumber(int estateNumber) {
		this.estateNumber = estateNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(int surface_area) {
		this.surface_area = surface_area;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	// display method
	public void display() {

		System.out.println("type : " + type);
		System.out.println("status : " + status);
		System.out.println("address : " + address);
		System.out.println("town : " + town);
		System.out.println("city : " + city);
		System.out.println("surface area : " + surface_area + " m2");
		System.out.println("price : " + price + " tl");
		System.out.println("room : " + rooms);

	}

}