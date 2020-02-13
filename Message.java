
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is a serializable super class that contains an ArrayList of customer
 * objects that needs to be sent over between client and server, as well as an
 * integer value for the switch board, and a String data field used to pass and
 * display messages.
 * 
 * @author Thanmayee Mudigonda & Sourabh Mokhasi
 *
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Customer> customerList;
	private int choice;
	private String data;

	/**
	 * Constructs a Message instance
	 * 
	 * @param customerList customer objects to be sent over
	 * @param choice       choice for switchboard
	 * @param data         optional message field
	 */
	public Message(ArrayList<Customer> customerList, int choice, String data) {
		this.setCustomerList(customerList);
		this.setChoice(choice);
		this.setData(data);
	}

	/**
	 * Default constructor for Message instance
	 */
	public Message() {
		customerList = new ArrayList<Customer>();
	}

////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Getters and setters for the above fields
	 */
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
