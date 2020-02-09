

import java.io.Serializable;
import java.util.ArrayList;



public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Customer> customerList;
	private int choice;
	
	public Message(ArrayList<Customer> customerList,int choice) {
		this.setCustomerList(customerList);
		this.setChoice(choice);
	}
	
	public Message() {
		customerList = new ArrayList<Customer>();
	}

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

}
