import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import enigma.core.Enigma;

public class Management {

	public enigma.console.Console cn = Enigma.getConsole("DERE");

	Scanner scan;

	// generating necessary variables and arrays
	private Customer[] customers;
	private int customerNumber;
	private Agent[] agents;
	private int agentNumber;
	private Agency[] agencies;
	private int agencyNumber;
	private RealEstate[] estates;
	private int estateNumber;
	private Contract[] contracts;
	private int contractNumber;

	public Management() throws NumberFormatException, IOException {

		customers = new Customer[1000];
		customerNumber = 0;

		agents = new Agent[1000];
		agentNumber = 0;

		agencies = new Agency[1000];
		agencyNumber = 0;

		estates = new RealEstate[1000];
		estateNumber = 0;

		contracts = new Contract[1000];
		contractNumber = 0;

		Command();
	}

	public void Menu() {
		System.out.println(" ___      ___  ____     ___ \r\n" + "|   \\    /  _]|    \\   /  _]\r\n"
				+ "|    \\  /  [_ |  D  ) /  [_ \r\n" + "|  D  ||    _]|    / |    _]\r\n"
				+ "|     ||   [_ |    \\ |   [_ \r\n" + "|     ||     ||  .  \\|     |\r\n"
				+ "|_____||_____||__|\\_||_____|\r\n" + "                            ");
	}

	// add methods
	public void addAgency(int agencyNumber, String name, String address, String town, String city, String phone) {
		agencies[agencyNumber] = new Agency(agencyNumber, name, address, town, city, phone, agencyNumber);
		agencyNumber++;
	}

	public void addAgent(int agentNumber, String name, String birthdate, String address, String town, String city,
			String phone, String gender, int agencyNumber) {
		agents[agentNumber] = new Agent(agentNumber, name, birthdate, address, town, city, phone, gender, agencyNumber);
		agentNumber++;
	}

	public void addRealEstate(int estateNumber, String type, String status, boolean availability, String address,
			String town, String city, int surface_area, int price, int rooms) {
		estates[estateNumber] = new RealEstate(estateNumber, type, status, availability, address, town, city,
				surface_area, price, rooms);
		estateNumber++;
	}

	public void addCustomer(int customerNumber, String name, String birthdate, String address, String town, String city,
			String phone, String gender) {

		customers[customerNumber] = new Customer(customerNumber, name, birthdate, address, town, city, phone, gender);
		customerNumber++;
	}

	public void addContract(int contractNumber, int estateNumber, int customerNumber, int agentNumber, String day,
			String month, String year) {

		contracts[contractNumber] = new Contract(contractNumber, estateNumber, customerNumber, agentNumber, day, month,
				year);

		contractNumber++;

	}

	// display methods
	public void displayAgencies() {
		System.out.println("---- Agencies ----");
		System.out.println();
		for (int i = 0; i <= agencyNumber; i++) {
			if (agencies[i] != null)
				agencies[i].display();
		}
		System.out.println();
	}

	public void displayAgents() {
		System.out.println("---- Agents ----");
		System.out.println();
		for (int i = 0; i <= agentNumber; i++) {
			if (agents[i] != null && agents[i].isFlag() == true)
				agents[i].display();
		}
		System.out.println();
	}

	public void displayRealEstates() {
		System.out.println("---- Real Estates ----");
		System.out.println();
		for (int i = 0; i <= estateNumber; i++) {
			if (estates[i] != null && estates[i].isFlag() == true)
				estates[i].display();
		}
		System.out.println();
	}

	public void displayCustomers() {
		System.out.println("---- Customers ----");
		System.out.println();
		for (int i = 0; i <= customerNumber; i++) {
			if (customers[i] != null && customers[i].isFlag() == true)
				customers[i].display();
		}
		System.out.println();
	}

	public void displayContracts() {
		System.out.println("---- Contracts ----");
		System.out.println();
		for (int i = 0; i <= contractNumber; i++) {
			if (contracts[i] != null)
				contracts[i].display();
		}
		System.out.println();
	}

	public void Command() throws NumberFormatException, IOException {

		// receiving data from text file and operations
		File file = new File("input.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;

		while ((st = br.readLine()) != null) {

			String Array[] = st.split(";", -1);

			// calling add methods
			if (Array[0].equals("addAgency")) {
				addAgency(agencyNumber, Array[1], Array[2], Array[3], Array[4], Array[5]);
				agencyNumber++;

			}
			if (Array[0].equals("addAgent")) {
				String dateArray[] = Array[3].split("/");
				Date birthdate = new Date(dateArray[0], dateArray[1], dateArray[2]);

				addAgent(agentNumber, Array[2], Array[3], Array[4], Array[5], Array[6], Array[7], Array[8],
						Integer.parseInt(Array[1]));
				agentNumber++;
			}
			if (Array[0].equals("addRealEstate")) {

				addRealEstate(estateNumber, Array[1], Array[2], true, Array[3], Array[4], Array[5],
						Integer.parseInt(Array[6]), Integer.parseInt(Array[7]), Integer.parseInt(Array[8]));
				estates[estateNumber].setAvailability(true);
				estateNumber++;

			}
			if (Array[0].equals("addCustomer")) {
				addCustomer(customerNumber, Array[1], Array[2], Array[3], Array[4], Array[5], Array[6], Array[7]);

				customerNumber++;
			}

			if (Array[0].equals("addContract")) {

				String[] date_contents;
				date_contents = Array[4].split("/");
				addContract(contractNumber, Integer.parseInt(Array[1]), Integer.parseInt(Array[2]),
						Integer.parseInt(Array[3]), date_contents[0], date_contents[1], date_contents[2]);

				contractNumber++;
			}
			// calling display methods
			if (st.equals("displayAgencies")) {
				displayAgencies();
			}
			if (st.equals("displayAgents")) {
				displayAgents();
			}

			if (st.equals("displayRealEstates")) {
				displayRealEstates();
			}

			if (st.equals("displayCustomers")) {
				displayCustomers();
			}
			if (st.equals("displayContracts")) {
				displayContracts();
			}

			// delete operations
			if (Array[0].equals("DeleteAgent")) {
				for (int i = 0; i < agentNumber; i++) {
					if (Array[1].equals(agents[i].getAgentNumber())) {
						agents[i].setFlag(false);
					}
				}

			}
			if (Array[0].equals("DeleteRealEstate")) {
				for (int i = 0; i < estateNumber; i++) {
					if (Array[1].equals(estates[i].getestateNumber())) {
						estates[i].setFlag(false);
					}
				}

			}
			if (Array[0].equals("DeleteCustomer")) {
				for (int i = 0; i < customerNumber; i++) {
					if (Array[1].equals(customers[i].getcustomerNumber())) {
						customers[i].setFlag(false);
					}
				}

			}

			// search operations
			if (Array[0].equals("search")) {

				for (int i = 0; i < estateNumber; i++) {
					boolean search = true;

					if (!(Array[1].isEmpty())) {

						if (!(Array[1].equals(estates[i].getType()))) {
							search = false;
						}
					}
					if (!(Array[2].isEmpty())) {

						if (!(Array[2].equals(estates[i].getStatus()))) {
							search = false;
						}
					}
					if (!(Array[3].isEmpty())) {

						if (!(Array[3].equals(estates[i].getTown()))) {
							search = false;
						}
					}
					if (!(Array[4].isEmpty())) {

						if (!(Array[4].equals(estates[i].getCity()))) {
							search = false;
						}
					}

					if (!(Array[5].isEmpty())) {

						String[] surface_interval = Array[5].split("-");
						if (!(Integer.parseInt(surface_interval[0]) <= estates[i].getSurface_area()
								&& Integer.parseInt(surface_interval[1]) >= estates[i].getSurface_area())) {
							search = false;
						}
					}
					if (!(Array[6].isEmpty())) {

						String[] price_interval = Array[6].split("-");
						if (!(Integer.parseInt(price_interval[0]) <= estates[i].getPrice()
								&& Integer.parseInt(price_interval[1]) >= estates[i].getPrice())) {
							search = false;
						}
					}
					if (!(Array[7].isEmpty())) {

						String[] room_interval = Array[7].split("-");
						if (!(Integer.parseInt(room_interval[0]) <= estates[i].getRooms()
								&& Integer.parseInt(room_interval[1]) >= estates[i].getRooms())) {
							search = false;
						}
					}

					if (search) {

						System.out.println();
						estates[i].display();

					}

				}

			}

			// calculate salaries
			if (Array[0].equals("calculateSalaries")) {

				String[] month_year = Array[1].split("/");

				for (int i = 0; i < contractNumber; i++) {
					double comission = 0;
					if (month_year[0].equals(contracts[i].getMonth()) && month_year[1].equals(contracts[i].getYear())) {

						for (int j = 0; j < estateNumber; j++) {
							if (estates[j].getestateNumber() == contracts[i].getEstateNumber()) {

								estates[j].setAvailability(false);

								if (estates[j].getStatus().equals("For Sale")) {
									comission = (estates[j].getPrice()) * 5 / 1000;

								}
								if (estates[j].getStatus().equals("For Rent")) {
									comission = (estates[j].getPrice()) * 20 / 100;

								}
								for (int k = 0; k < agentNumber; k++) {
									if (agents[k].getAgentNumber() == contracts[i].getAgentNumber()) {
										agents[k].setSalary(agents[k].getSalary() + comission);

									}

								}
							}

						}

					}
				}
				System.out.println("---- Salaries ----");
				System.out.println();
				for (int l = 0; l < agentNumber; l++) {

					System.out.println(agents[l].getName() + "'s Salary : " + agents[l].getSalary());

				}
				System.out.println();

			}

			// calculate total income
			if (Array[0].equals("calculateTotalIncome")) {

				String[] month_year = Array[1].split("/");

				for (int i = 0; i < contractNumber; i++) {
					double income = 0;
					if (month_year[0].equals(contracts[i].getMonth()) && month_year[1].equals(contracts[i].getYear())) {

						for (int j = 0; j < estateNumber; j++) {
							if (estates[j].getestateNumber() == contracts[i].getEstateNumber()) {

								estates[j].setAvailability(false);

								if (estates[j].getStatus().equals("For Sale")) {

									income = (estates[j].getPrice()) * 15 / 1000;

								}
								if (estates[j].getStatus().equals("For Rent")) {

									income = (estates[j].getPrice()) * 80 / 100;
								}
								for (int k = 0; k < agentNumber; k++) {
									if (agents[k].getAgentNumber() == contracts[i].getAgentNumber()) {

										for (int m = 0; m < agencyNumber; m++) {
											if (agents[k].getAgencyID() == agencies[m].getAgencyNumber()) {

												agencies[m].setIncome(agencies[m].getIncome() + income);
											}
										}

									}

								}
							}

						}

					}
				}
				System.out.println("---- Total Income ----");
				System.out.println();
				double sum = 0;
				for (int l = 0; l < agencyNumber; l++) {

					sum += agencies[l].getIncome();

				}
				System.out.println(sum);
				System.out.println();

			}

			// determining the most profitable agency
			if (Array[0].equals("mostProfitableAgency")) {

				String[] month_year = Array[1].split("/");

				for (int i = 0; i < contractNumber; i++) {
					double income = 0;
					if (month_year[0].equals(contracts[i].getMonth()) && month_year[1].equals(contracts[i].getYear())) {

						for (int j = 0; j < estateNumber; j++) {
							if (estates[j].getestateNumber() == contracts[i].getEstateNumber()) {

								estates[j].setAvailability(false);

								if (estates[j].getStatus().equals("For Sale")) {

									income = (estates[j].getPrice()) * 15 / 1000;

								}
								if (estates[j].getStatus().equals("For Rent")) {

									income = (estates[j].getPrice()) * 80 / 100;
								}
								for (int k = 0; k < agentNumber; k++) {
									if (agents[k].getAgentNumber() == contracts[i].getAgentNumber()) {

										for (int m = 0; m < agencyNumber; m++) {
											if (agents[k].getAgencyID() == agencies[m].getAgencyNumber()) {
												agencies[m].setIncome(0);
												agencies[m].setIncome(agencies[m].getIncome() + income);
											}
										}

									}

								}
							}

						}

					}
				}
				System.out.println("---- Most Profitable Agency ----");
				System.out.println();
				double sum = 0;
				double max = 0;
				String agencyName = "";
				for (int l = 0; l < agencyNumber; l++) {
					if (agencies[l].getIncome() > max) {
						max = agencies[l].getIncome();
						agencyName = agencies[l].getName();
					}
				}
				System.out.println(agencyName + " " + max);

			}

		}

		// taking input from console

		Menu();

		while (true) {

			String choice;
			scan = new Scanner(System.in);
			System.out.println();
			System.out.println("+-------------------------------+");
			System.out.println("|  What would you like to do? : |");
			System.out.println("+-------------------------------+");
			System.out.println();

			choice = scan.nextLine();
			String[] Array2 = choice.split(";", -1);

			// calling add methods
			if (Array2[0].equals("addAgency")) {
				addAgency(agencyNumber, Array2[1], Array2[2], Array2[3], Array2[4], Array2[5]);
				agencyNumber++;
				System.out.print("The agency has been added successfully!");

			}
			if (Array2[0].equals("addAgent")) {
				addAgent(agentNumber, Array2[2], Array2[3], Array2[4], Array2[5], Array2[6], Array2[7], Array2[8],
						Integer.parseInt(Array2[1]));
				agentNumber++;
				System.out.print("The agent has been added successfully!");

			}
			if (Array2[0].equals("addRealEstate")) {

				addRealEstate(estateNumber, Array2[1], Array2[2], true, Array2[3], Array2[4], Array2[5],
						Integer.parseInt(Array2[6]), Integer.parseInt(Array2[7]), Integer.parseInt(Array2[8]));
				estates[estateNumber].setAvailability(false);
				estateNumber++;

			}
			if (Array2[0].equals("addCustomer")) {
				addCustomer(customerNumber, Array2[1], Array2[2], Array2[3], Array2[4], Array2[5], Array2[6],
						Array2[7]);
				customerNumber++;

			}
			if (Array2[0].equals("addContract")) {

				String[] date_contents;
				date_contents = Array2[4].split("/");
				addContract(contractNumber, Integer.parseInt(Array2[1]), Integer.parseInt(Array2[2]),
						Integer.parseInt(Array2[3]), date_contents[0], date_contents[1], date_contents[2]);

				contractNumber++;
			}

			// calling display methods
			if (choice.equals("displayAgencies")) {
				displayAgencies();
			}
			if (choice.equals("displayAgents")) {
				displayAgents();
			}
			if (choice.equals("displayRealEstates")) {
				displayRealEstates();
			}
			if (choice.equals("displayCustomers")) {
				displayCustomers();
			}
			if (choice.equals("displayContracts")) {
				displayContracts();
			}
			// delete operations
			if (Array2[0].equals("DeleteAgent")) {
				for (int i = 0; i < agentNumber; i++) {
					if (Array2[1].equals(agents[i].getAgentNumber())) {
						agents[i].setFlag(false);
					}
				}

			}
			if (Array2[0].equals("DeleteRealEstate")) {
				for (int i = 0; i < estateNumber; i++) {
					if (Array2[1].equals(estates[i].getestateNumber())) {
						estates[i].setFlag(false);
					}
				}

			}
			if (Array2[0].equals("DeleteCustomer")) {
				for (int i = 0; i < customerNumber; i++) {
					if (Array2[1].equals(customers[i].getcustomerNumber())) {
						customers[i].setFlag(false);
					}
				}

			}

			// search operations
			if (Array2[0].equals("search")) {

				for (int i = 0; i < estateNumber; i++) {
					boolean search = true;

					if (!(Array2[1].isEmpty())) {

						if (!(Array2[1].equals(estates[i].getType()))) {
							search = false;
						}
					}
					if (!(Array2[2].isEmpty())) {

						if (!(Array2[2].equals(estates[i].getStatus()))) {
							search = false;
						}
					}
					if (!(Array2[3].isEmpty())) {

						if (!(Array2[3].equals(estates[i].getTown()))) {
							search = false;
						}
					}
					if (!(Array2[4].isEmpty())) {

						if (!(Array2[4].equals(estates[i].getCity()))) {
							search = false;
						}
					}

					if (!(Array2[5].isEmpty())) {

						String[] surface_interval = Array2[5].split("-");
						if (!(Integer.parseInt(surface_interval[0]) <= estates[i].getSurface_area()
								&& Integer.parseInt(surface_interval[1]) >= estates[i].getSurface_area())) {
							search = false;
						}
					}
					if (!(Array2[6].isEmpty())) {

						String[] price_interval = Array2[6].split("-");
						if (!(Integer.parseInt(price_interval[0]) <= estates[i].getPrice()
								&& Integer.parseInt(price_interval[1]) >= estates[i].getPrice())) {
							search = false;
						}
					}
					if (!(Array2[7].isEmpty())) {

						String[] room_interval = Array2[7].split("-");
						if (!(Integer.parseInt(room_interval[0]) <= estates[i].getRooms()
								&& Integer.parseInt(room_interval[1]) >= estates[i].getRooms())) {
							search = false;
						}
					}

					if (search) {

						System.out.println();
						estates[i].display();

					}

				}

			}

			// calculate salaries
			if (Array2[0].equals("calculateSalaries")) {

				String[] month_year = Array2[1].split("/");

				for (int i = 0; i < contractNumber; i++) {
					double comission = 0;
					if (month_year[0].equals(contracts[i].getMonth()) && month_year[1].equals(contracts[i].getYear())) {

						for (int j = 0; j < estateNumber; j++) {
							if (estates[j].getestateNumber() == contracts[i].getEstateNumber()) {

								if (estates[j].getStatus().equals("For Sale")) {
									comission = (estates[j].getPrice()) * 5 / 1000;

								}
								if (estates[j].getStatus().equals("For Rent")) {
									comission = (estates[j].getPrice()) * 20 / 100;
								}
								for (int k = 0; k < agentNumber; k++) {
									if (agents[k].getAgentNumber() == contracts[i].getAgentNumber()) {
										agents[k].setSalary(agents[k].getSalary() + comission);

									}

								}
							}

						}

					}
				}
				for (int l = 0; l < agentNumber; l++) {
					System.out.println(agents[l].getName() + "'s Salary : " + agents[l].getSalary());

				}

			}

			// calculate total income
			if (Array2[0].equals("calculateTotalIncome")) {

				String[] month_year = Array2[1].split("/");

				for (int i = 0; i < contractNumber; i++) {
					double income = 0;
					if (month_year[0].equals(contracts[i].getMonth()) && month_year[1].equals(contracts[i].getYear())) {

						for (int j = 0; j < estateNumber; j++) {
							if (estates[j].getestateNumber() == contracts[i].getEstateNumber()) {

								estates[j].setAvailability(false);

								if (estates[j].getStatus().equals("For Sale")) {

									income = (estates[j].getPrice()) * 15 / 1000;

								}
								if (estates[j].getStatus().equals("For Rent")) {

									income = (estates[j].getPrice()) * 80 / 100;
								}
								for (int k = 0; k < agentNumber; k++) {
									if (agents[k].getAgentNumber() == contracts[i].getAgentNumber()) {

										for (int m = 0; m < agencyNumber; m++) {
											if (agents[k].getAgencyID() == agencies[m].getAgencyNumber()) {

												agencies[m].setIncome(agencies[m].getIncome() + income);
											}
										}

									}

								}
							}

						}

					}
				}
				System.out.println("---- Total Income ----");
				System.out.println();
				double sum = 0;
				for (int l = 0; l < agencyNumber; l++) {

					sum += agencies[l].getIncome();

				}
				System.out.println(sum);
				System.out.println(agencies[0].getName() + " : " + agencies[0].getIncome());
				System.out.println(agencies[1].getName() + " : " + agencies[1].getIncome());
				System.out.println(agencies[2].getName() + " : " + agencies[2].getIncome());
				System.out.println(agencies[3].getName() + " : " + agencies[3].getIncome());

			}

			// determining the most profitable agency
			if (Array2[0].equals("mostProfitableAgency")) {

				String[] month_year = Array2[1].split("/");

				for (int i = 0; i < contractNumber; i++) {
					double income = 0;
					if (month_year[0].equals(contracts[i].getMonth()) && month_year[1].equals(contracts[i].getYear())) {

						for (int j = 0; j < estateNumber; j++) {
							if (estates[j].getestateNumber() == contracts[i].getEstateNumber()) {

								estates[j].setAvailability(false);

								if (estates[j].getStatus().equals("For Sale")) {

									income = (estates[j].getPrice()) * 15 / 1000;

								}
								if (estates[j].getStatus().equals("For Rent")) {

									income = (estates[j].getPrice()) * 80 / 100;
								}
								for (int k = 0; k < agentNumber; k++) {
									if (agents[k].getAgentNumber() == contracts[i].getAgentNumber()) {

										for (int m = 0; m < agencyNumber; m++) {
											if (agents[k].getAgencyID() == agencies[m].getAgencyNumber()) {
												agencies[m].setIncome(0);
												agencies[m].setIncome(agencies[m].getIncome() + income);
											}
										}

									}

								}
							}

						}

					}
				}
				System.out.println("---- Most Profitable Agency ----");
				System.out.println();
				double max = 0;
				String agencyName = "";
				for (int l = 0; l < agencyNumber; l++) {
					if (agencies[l].getIncome() > max) {
						max = agencies[l].getIncome();
						agencyName = agencies[l].getName();
					}
				}
				System.out.println(agencyName + " : " + max + " tl");

			}

		}

	}
}
