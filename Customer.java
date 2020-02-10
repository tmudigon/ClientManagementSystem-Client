import java.io.Serializable;

/**
 * This class is responsible for storing information of each client
 * 
 * @author Thanmayee Mudigonda
 * 
 */

public class Customer implements Serializable {

	/**
	 * Attributes of the client including a unique id number, first name, last name,
	 * address, postal code, phone number, and client type
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String fName;
	private String lName;
	private String address;
	private String postalCod;
	private String phoneNum;
	private char clientType;

	public Customer () {}
	
	/**
	 * Constructs a client object
	 * 
	 * @param id         client id
	 * @param firstName  client first name
	 * @param lastName   client last name
	 * @param address    client address
	 * @param postalCod  client postal code
	 * @param phoneNum   client phone number
	 * @param clientType client type
	 */
	public Customer(int id, String firstName, String lastName, String address, String postalCod, String phoneNum,
			char clientType) {
		this.id = id;
		this.setfName(firstName);
		this.setlName(lastName);
		this.setAddress(address);
		this.setPostalCod(postalCod);
		this.setPhoneNum(phoneNum);
		this.setClientType(clientType);
	}

	/**
	 * String representation of client object to display
	 */
	@Override
	public String toString() {
		return id + " " + fName + " " + lName + " " + clientType;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Getters and Setters

	/**
	 * getter for client id
	 * 
	 * @return client id
	 */
	public int getId() {
		return id;
	}

	/**
	 * setter method for client id
	 * 
	 * @param id client id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getter for client first name
	 * 
	 * @return client first name
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * setter method for client first name
	 * 
	 * @param fName first name
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * getter for client last name
	 * 
	 * @return client last name
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * setter method for client last name
	 * 
	 * @param lName last name
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * getter for client address
	 * 
	 * @return client address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * setter method for client address
	 * 
	 * @param address address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getter for client postal code
	 * 
	 * @return client postal code
	 */
	public String getPostalCod() {
		return postalCod;
	}

	/**
	 * setter method for client postal code
	 * 
	 * @param postalCod postal code
	 */
	public void setPostalCod(String postalCod) {
		this.postalCod = postalCod;
	}

	/**
	 * getter for client phone number
	 * 
	 * @return client phone number
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * setter method for client phone number
	 * 
	 * @param phoneNum number
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * getter for client type
	 * 
	 * @return client type
	 */
	public char getClientType() {
		return clientType;
	}

	/**
	 * setter method for client id
	 * 
	 * @param clientType client type
	 */
	public void setClientType(char clientType) {
		this.clientType = clientType;
	}

}
