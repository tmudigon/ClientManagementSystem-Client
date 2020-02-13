
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 * This class is responsible for connecting the model and the view packages This
 * class acts as a bridge between the front end and the back end
 * 
 * @author Thanmayee Mudigonda
 *
 */
public class ViewController {

	private ClientController theClient;
	private View theView;
	private Message theMessage;
	private ValidateInput validateInput;

	/**
	 * Constructs a controller object
	 * 
	 * @param theClient client controller object
	 * @param frame view object
	 */
	public ViewController(ClientController theClient, View theView) {
		this.theClient = theClient;
		this.theView = theView;
		theMessage = new Message();
		validateInput = new ValidateInput(theView);
		theView.addSearchListener(new SearchListener());
		theView.addClearSearchListener(new ClearSearchListener());
		theView.addListListener(new ListListener());
		theView.addSaveListener(new SaveListener());
		theView.addDeleteListener(new DeleteListener());
		theView.addClearListener(new ClearListener());
		theView.addNewClientListener(new NewClientListener());
	}

	/**
	 * This method displays the appropriate list to the user based on the search
	 * parameter
	 * 
	 * @param selectedList list to be displayed to user
	 */
	public void addToListModel(ArrayList<Customer> customerList) {
		if (customerList.size() != 0) {
			theView.setSearchResultList(customerList.toArray());
		} else {
			theView.displayErrorMessage();
		}
	}

	/**
	 * This class listens for the search button and performs the action when the
	 * button is pushed
	 * 
	 * @author Thanmayee Mudigonda
	 *
	 */
	private class SearchListener implements ActionListener {

		/**
		 * This method performs the search based on the provided parameter when the
		 * search button is pushed
		 * 
		 * This method first checks which type of search is requested, and calls the
		 * appropriate method from the back end
		 * 
		 * Appropriate messages are displayed to the user
		 * 
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
		    System.out.println("Event hashcode:"+System.identityHashCode(e));

			String searchParam = null;
			searchParam = theView.getClientSearchTextField();
			//ArrayList<Customer> selectedList;
			theMessage.setData(searchParam);

			if (theView.getRdbtnClientId().isSelected()) {
				theView.getSearchResultList().clearSelection();
				if (searchParam != null) {
					try {
						theMessage.setChoice(1);
						theClient.sendMessage(theMessage);
						// selectedList = theModel.searchByClientId(Integer.parseInt(searchParam));
						// addToListModel(selectedList);
					} catch (NumberFormatException ex) {
						theView.displayErrorMessage();
					}
				} else
					theView.displayErrorMessage();
			}

			else if (theView.getRdbtnLastName().isSelected()) {
				if (searchParam != null) {
					theView.getSearchResultList().clearSelection();
					theMessage.setChoice(2);
					theClient.sendMessage(theMessage);
					// selectedList = theModel.searchByClientName(searchParam);
					// addToListModel(selectedList);
				} else
					theView.displayErrorMessage();
			}

			else if (theView.getRdbtnClientType().isSelected()) {
				theView.getSearchResultList().clearSelection();
				if (searchParam != null) {
					try {
						theMessage.setChoice(3);
						theClient.sendMessage(theMessage);
						// selectedList =
						// theModel.searchByClientType(searchParam.toUpperCase().charAt(0));
						// addToListModel(selectedList);
					} catch (ArrayIndexOutOfBoundsException e1) {
						theView.displayErrorMessage();
					} catch (StringIndexOutOfBoundsException e2) {
						theView.displayErrorMessage();
					}

				} else
					theView.displayErrorMessage();

			} else
				theView.displayErrorMessage();
		}
	}

//		public void addToListModel(ArrayList<Customer> selectedList) {
//			if (selectedList.size() != 0) {
//				theView.setSearchResultList(selectedList.toArray());
//			} else {
//				theView.displayErrorMessage();
//			}
//		}
//	}
//
	/**
	 * This class is responsible for clearing the search results when the clear
	 * search button is pushed
	 * 
	 * @author Thanmayee Mudigonda
	 *
	 */
	private class ClearSearchListener implements ActionListener {
		/**
		 * This method clears the search results when clear search button is pushed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			clearFromListModel();
		}

		/**
		 * Clears the search results
		 */
		public void clearFromListModel() {
			ArrayList<Customer> nullList = new ArrayList();
			theView.setSearchResultList(nullList.toArray());
		}
	}

	/**
	 * This class is responsible for listening for a selection in the list and
	 * displaying all of the information in the search results panel when a
	 * selection is made by the user
	 * 
	 * @author Thanmayee Mudigonda
	 *
	 */
	private class ListListener implements ListSelectionListener {

		/**
		 * Listens for a selection in the list and displays all of the information in
		 * the search results panel
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {

			Customer c = null;
			if (!e.getValueIsAdjusting() && theView.getSearchResultList().getSelectedIndex() >= 0) {
				c = (Customer) theView.getSearchResultList().getModel()
						.getElementAt(theView.getSearchResultList().getSelectedIndex());
				theView.getTfClientId().setText(c.getId() + "");
				theView.getTfFirstName().setText(c.getfName());
				theView.getTfLastName().setText(c.getlName());
				theView.getTfAddress().setText(c.getAddress());
				theView.getTfPostalCode().setText(c.getPostalCod());
				theView.getTfPhoneNumber().setText(c.getPhoneNum());

				for (int i = 0; i < theView.getComboBox().getItemCount(); i++) {
					if (c.getClientType() == ((String) theView.getComboBox().getItemAt(i)).charAt(0)) {
						theView.getComboBox().setSelectedItem(c.getClientType() + "");
					}
				}
			}
		}
	}

	/**
	 * This class is responsible for modifying a client's information when the save
	 * button is clicked This class also verifies that the information provided
	 * follows the valid format before saving the information
	 * 
	 * @author Thanmayee Mudigonda
	 *
	 */
	private class SaveListener implements ActionListener {
		/**
		 * Modifies the client information when the save button is clicked, provided
		 * that the user inputted values all follow the valid format
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			boolean update = false;
			int id = 0;

			try {
				id = Integer.parseInt(theView.getTfClientId().getText());
			} catch (NumberFormatException e1) {
				theView.displayFailureMessage();
			}

			String fName = theView.getTfFirstName().getText();
			String lName = theView.getTfLastName().getText();
			String address = theView.getTfAddress().getText();
			String postalCod = theView.getTfPostalCode().getText();
			String phoneNum = theView.getTfPhoneNumber().getText();
			char clientType = ((String) theView.getComboBox().getSelectedItem()).charAt(0);

			if (theView.getTfClientId().getText().isEmpty() || id == 0 || theView.getTfFirstName().getText().isEmpty()
					|| theView.getTfLastName().getText().isEmpty() || theView.getTfAddress().getText().isEmpty()
					|| theView.getTfPostalCode().getText().isEmpty() || theView.getTfPostalCode().getText().isEmpty()
					|| theView.getTfPhoneNumber().getText().isEmpty()) {
				theView.displayFillMessage();
			} else {

				if (validateInput.validateInput(fName, lName, address, postalCod, phoneNum)) {
					Customer c = new Customer(id, fName, lName, address, postalCod, phoneNum, clientType);
					theMessage.getCustomerList().add(c);
					theMessage.setChoice(5);
					theMessage.setData(null);
					theClient.sendMessage(theMessage);
					//update = theModel.updateClientInfo(id, fName, lName, address, postalCod, phoneNum, clientType);
				}
			}

			if (update) {
				theView.displaySuccessMessage();
			} else {
				theView.displayFailureMessage();
			}
		}
	}

	/**
	 * This class is responsible for listening for the delete button and calling
	 * appropriate back end methods to delete the client information from the
	 * database
	 * 
	 * @author Thanmayee Mudigonda
	 *
	 */
	private class DeleteListener implements ActionListener {
		/**
		 * Listens for the delete button and calls appropriate back end methods to
		 * delete client information
		 * 
		 * Displays appropriate messages to the user
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
//			try {
				int id = Integer.parseInt(theView.getTfClientId().getText());
				
				Customer c = new Customer();
				c.setId(id);
				
				theMessage.getCustomerList().add(c);
				theMessage.setChoice(6);
				theMessage.setData(null);
				theClient.sendMessage(theMessage);
				
				
//				boolean check = theModel.deleteClientInfo(id);
//				if (check) {
//					theView.displaySuccessMessage();
//				} else {
//					theView.displayFailureMessage();
//				}
//			} catch (NumberFormatException excep) {	}
		}
	}
//
	/**
	 * This class is responsible for listening for the clear button and clearing the
	 * text fields displayed to the user
	 * 
	 * @author Thamayee Mudigonda
	 *
	 */
	private class ClearListener implements ActionListener {
		/**
		 * Clears text fields when the clear button is pushed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			theView.getTfClientId().setText("");
			theView.getTfFirstName().setText("");
			theView.getTfLastName().setText("");
			theView.getTfAddress().setText("");
			theView.getTfPostalCode().setText("");
			theView.getTfPhoneNumber().setText("");
		}
	}

	/**
	 * This class is responsible for listening for the Add New Client button, and
	 * calling appropriate methods from the back end to add a new client, provided
	 * that the user inputted values follow the valid format
	 * 
	 * Appropriate messages are displayed to the user
	 * 
	 * @author Thanmayee Mudigonda
	 *
	 */
	private class NewClientListener implements ActionListener {
		/**
		 * Listens for add new client button and calls back end methods to add the
		 * client if info follows the valid format
		 * 
		 * Success and error messages are displayed to the user
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			//boolean addNew = false;

			String fName = theView.getTfFirstName().getText();
			String lName = theView.getTfLastName().getText();
			String address = theView.getTfAddress().getText();
			String postalCod = theView.getTfPostalCode().getText();
			String phoneNum = theView.getTfPhoneNumber().getText();
			char clientType = ((String) theView.getComboBox().getSelectedItem()).charAt(0);

			if (theView.getTfFirstName().getText().isEmpty() || theView.getTfLastName().getText().isEmpty()
					|| theView.getTfAddress().getText().isEmpty() || theView.getTfPostalCode().getText().isEmpty()
					|| theView.getTfPostalCode().getText().isEmpty()
					|| theView.getTfPhoneNumber().getText().isEmpty()) {
				theView.displayFillMessage();
			} else {
				if (validateInput.validateInput(fName, lName, address, postalCod, phoneNum)) {
					int defaultId = -1;
					Customer c = new Customer(defaultId, fName, lName, address, postalCod, phoneNum, clientType);
					//addNew = theModel.addClient(c);
					
					theMessage.getCustomerList().add(c);
					theMessage.setChoice(4);
					theMessage.setData(null);
					theClient.sendMessage(theMessage);
				}
			}
//			if (addNew) {
//				theView.displaySuccessMessage();
//			} else {
//				theView.displayFailureMessage();
//			}
		}
	}
//
//	/**
//	 * Responsible for calling appropriate back end methods to check if the user
//	 * input is valid, and displaying appropriate error messages if it is not
//	 * 
//	 * @param fName     client first name
//	 * @param lName     client last name
//	 * @param address   client address
//	 * @param postalCod client postal code
//	 * @param phoneNum  client phone number
//	 * @return true if all input values are valid and false otherwise
//	 */
//	private boolean validateUserInput(String fName, String lName, String address, String postalCod, String phoneNum) {
//		if (theModel.validatePostalCode(postalCod)) {
//			if (theModel.validateNameLength(fName, lName)) {
//				if (theModel.validateAddressLength(address)) {
//					if (theModel.validatePhoneNum(phoneNum)) {
//						return true;
//					} else
//						theView.phoneErrorMessage();
//				} else
//					theView.addressErrorMessage();
//			} else
//				theView.nameErrorMessage();
//		} else
//			theView.postalCodErrorMessage();
//		return false;
//	}

	
	
}
