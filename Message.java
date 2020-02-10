

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Customer> customerList;
	private int choice;
	private String data;
	
	public Message(ArrayList<Customer> customerList,int choice,String data) {
		this.setCustomerList(customerList);
		this.setChoice(choice);
		this.setData(data);
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
