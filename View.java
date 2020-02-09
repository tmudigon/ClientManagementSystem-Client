

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

//import Controller.Controller;
//import Model.ValidateClient;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Dimension;

/**
 * This class is responsible for creating and displaying the user interface for
 * the client management system As well, this class is responsible for
 * displaying error and success messages to the user
 * 
 * @author Thanmayee Mudigonda
 *
 */
public class View extends JFrame {

	/**
	 * Main panel that contains the other panels displayed to the user
	 */
	private JPanel contentPane;
	/**
	 * text field for user to input client search parameter
	 */
	private JTextField clientSearchTextField;
	/**
	 * text field not editable to display client id
	 */
	private JTextField tfClientId;
	/**
	 * text field for user to input first name
	 */
	private JTextField tfFirstName;
	/**
	 * text field for user to input last name
	 */
	private JTextField tfLastName;
	/**
	 * text field for user to input address
	 */
	private JTextField tfAddress;
	/**
	 * text field for user to input postal code
	 */
	private JTextField tfPostalCode;
	/**
	 * text field for user to input client phone number
	 */
	private JTextField tfPhoneNumber;
	/**
	 * selection button for client id
	 */
	private JRadioButton rdbtnClientId;
	/**
	 * selection button for last name
	 */
	private JRadioButton rdbtnLastName;
	/**
	 * selection button for client type
	 */
	private JRadioButton rdbtnClientType;
	/**
	 * Jlist to display search results
	 */
	private JList searchResultList;
	/**
	 * list model to display search results
	 */
	private DefaultListModel<String> listModel;
	/**
	 * search button
	 */
	private JButton btnSearch;
	/**
	 * clear search button
	 */
	private JButton btnClearSearch;
	/**
	 * combo box object for selecting residential or commercial client
	 */
	private JComboBox<String> comboBox;
	/**
	 * add client button
	 */
	private JButton btnAddClient;
	/**
	 * clear text fields button
	 */
	private JButton btnClear;
	/**
	 * delete client button
	 */
	private JButton btnDelete;
	/**
	 * modify and save client info button
	 */
	private JButton btnSave;
	/**
	 * pannel for displaying search results
	 */
	JPanel searchResultsPane;

	/**
	 * The frame that is displayed to the user is created in the constructor of this
	 * class
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblClientManagementScreen = new JLabel("Client Management Screen");
		lblClientManagementScreen.setForeground(Color.BLUE);
		lblClientManagementScreen.setBackground(Color.DARK_GRAY);
		lblClientManagementScreen.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClientManagementScreen.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblClientManagementScreen, BorderLayout.NORTH);

		JSplitPane contentPaneNoTitle = new JSplitPane();
		contentPane.add(contentPaneNoTitle, BorderLayout.CENTER);

		JPanel leftPanel = new JPanel();
		contentPaneNoTitle.setLeftComponent(leftPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		leftPanel.add(splitPane, BorderLayout.CENTER);

		JPanel searchClientPane = new JPanel();
		splitPane.setLeftComponent(searchClientPane);
		searchClientPane.setLayout(new BorderLayout(0, 0));

		JLabel lblSearchClients = new JLabel("Search Clients");
		lblSearchClients.setForeground(Color.BLUE);
		lblSearchClients.setHorizontalAlignment(SwingConstants.CENTER);
		searchClientPane.add(lblSearchClients, BorderLayout.NORTH);

		JPanel searchClientSouth = new JPanel();
		searchClientPane.add(searchClientSouth, BorderLayout.SOUTH);
		searchClientSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		clientSearchTextField = new JTextField();
		searchClientSouth.add(clientSearchTextField);
		clientSearchTextField.setColumns(10);

		btnSearch = new JButton("Search");
		searchClientSouth.add(btnSearch);

		btnClearSearch = new JButton("Clear Search");
		searchClientSouth.add(btnClearSearch);

		JPanel searchClientCenter = new JPanel();
		searchClientPane.add(searchClientCenter, BorderLayout.CENTER);
		GridBagLayout gbl_searchClientCenter = new GridBagLayout();
		gbl_searchClientCenter.columnWidths = new int[] { 0, 0 };
		gbl_searchClientCenter.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_searchClientCenter.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_searchClientCenter.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		searchClientCenter.setLayout(gbl_searchClientCenter);

		JLabel lblSelectTheType = new JLabel("Select the type of search to be performed:");
		GridBagConstraints gbc_lblSelectTheType = new GridBagConstraints();
		gbc_lblSelectTheType.insets = new Insets(0, 0, 5, 0);
		gbc_lblSelectTheType.gridx = 0;
		gbc_lblSelectTheType.gridy = 0;
		searchClientCenter.add(lblSelectTheType, gbc_lblSelectTheType);

		rdbtnClientId = new JRadioButton("Client ID");
		GridBagConstraints gbc_rdbtnClientId = new GridBagConstraints();
		gbc_rdbtnClientId.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnClientId.anchor = GridBagConstraints.WEST;
		gbc_rdbtnClientId.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnClientId.gridx = 0;
		gbc_rdbtnClientId.gridy = 1;
		searchClientCenter.add(rdbtnClientId, gbc_rdbtnClientId);

		rdbtnLastName = new JRadioButton("Last Name");
		GridBagConstraints gbc_rdbtnLastName = new GridBagConstraints();
		gbc_rdbtnLastName.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnLastName.anchor = GridBagConstraints.WEST;
		gbc_rdbtnLastName.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnLastName.gridx = 0;
		gbc_rdbtnLastName.gridy = 2;
		searchClientCenter.add(rdbtnLastName, gbc_rdbtnLastName);

		rdbtnClientType = new JRadioButton("Client Type");
		GridBagConstraints gbc_rdbtnClientType = new GridBagConstraints();
		gbc_rdbtnClientType.anchor = GridBagConstraints.WEST;
		gbc_rdbtnClientType.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnClientType.gridx = 0;
		gbc_rdbtnClientType.gridy = 3;
		searchClientCenter.add(rdbtnClientType, gbc_rdbtnClientType);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnClientId);
		group.add(rdbtnLastName);
		group.add(rdbtnClientType);

		JLabel lblEnterTheSearch = new JLabel("Enter the search parameter below:");
		GridBagConstraints gbc_lblEnterTheSearch = new GridBagConstraints();
		gbc_lblEnterTheSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEnterTheSearch.gridx = 0;
		gbc_lblEnterTheSearch.gridy = 5;
		searchClientCenter.add(lblEnterTheSearch, gbc_lblEnterTheSearch);

		searchResultsPane = new JPanel();
		splitPane.setRightComponent(searchResultsPane);
		searchResultsPane.setLayout(new BorderLayout(0, 0));

		JLabel lblSearchResults = new JLabel("Search Results");
		lblSearchResults.setForeground(Color.BLUE);
		searchResultsPane.add(lblSearchResults, BorderLayout.NORTH);
		splitPane.setDividerLocation(200);

		// listModel = new DefaultListModel<>();
		searchResultList = new JList();
		searchResultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchResultList.setVisible(true);
		searchResultsPane.add(searchResultList, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane(searchResultList);
		searchResultsPane.add(scrollPane, BorderLayout.CENTER);

		JPanel clientInfoPane = new JPanel();
		contentPaneNoTitle.setRightComponent(clientInfoPane);
		clientInfoPane.setLayout(new BorderLayout(0, 0));

		JLabel lblClientInformation = new JLabel("Client Information");
		lblClientInformation.setForeground(Color.BLUE);
		lblClientInformation.setHorizontalAlignment(SwingConstants.CENTER);
		clientInfoPane.add(lblClientInformation, BorderLayout.NORTH);

		JPanel clientInfoSouth = new JPanel();
		clientInfoPane.add(clientInfoSouth, BorderLayout.SOUTH);
		clientInfoSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnSave = new JButton("Save");
		clientInfoSouth.add(btnSave);

		btnDelete = new JButton("Delete");
		clientInfoSouth.add(btnDelete);

		btnClear = new JButton("Clear");
		clientInfoSouth.add(btnClear);

		btnAddClient = new JButton("Add New Client");
		clientInfoSouth.add(btnAddClient);

		JPanel clientInfoCenter = new JPanel();
		clientInfoPane.add(clientInfoCenter, BorderLayout.CENTER);
		GridBagLayout gbl_clientInfoCenter = new GridBagLayout();
		gbl_clientInfoCenter.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_clientInfoCenter.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_clientInfoCenter.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_clientInfoCenter.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0,
				0.0, 1.0, Double.MIN_VALUE };
		clientInfoCenter.setLayout(gbl_clientInfoCenter);

		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblClientId = new GridBagConstraints();
		gbc_lblClientId.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientId.gridx = 2;
		gbc_lblClientId.gridy = 1;
		clientInfoCenter.add(lblClientId, gbc_lblClientId);

		tfClientId = new JTextField();
		tfClientId.setEditable(false);
		GridBagConstraints gbc_tfClientId = new GridBagConstraints();
		gbc_tfClientId.anchor = GridBagConstraints.WEST;
		gbc_tfClientId.insets = new Insets(0, 0, 5, 0);
		gbc_tfClientId.gridx = 4;
		gbc_tfClientId.gridy = 1;
		clientInfoCenter.add(tfClientId, gbc_tfClientId);
		tfClientId.setColumns(10);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 2;
		gbc_lblFirstName.gridy = 3;
		clientInfoCenter.add(lblFirstName, gbc_lblFirstName);

		tfFirstName = new JTextField(20);
		GridBagConstraints gbc_tfFirstName = new GridBagConstraints();
		gbc_tfFirstName.anchor = GridBagConstraints.WEST;
		gbc_tfFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_tfFirstName.gridx = 4;
		gbc_tfFirstName.gridy = 3;
		clientInfoCenter.add(tfFirstName, gbc_tfFirstName);
		// tfFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 2;
		gbc_lblLastName.gridy = 5;
		clientInfoCenter.add(lblLastName, gbc_lblLastName);

		tfLastName = new JTextField(20);
		GridBagConstraints gbc_tfLastName = new GridBagConstraints();
		gbc_tfLastName.anchor = GridBagConstraints.WEST;
		gbc_tfLastName.insets = new Insets(0, 0, 5, 0);
		gbc_tfLastName.gridx = 4;
		gbc_tfLastName.gridy = 5;
		clientInfoCenter.add(tfLastName, gbc_tfLastName);

		JLabel lblAddress = new JLabel("Address:");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 2;
		gbc_lblAddress.gridy = 7;
		clientInfoCenter.add(lblAddress, gbc_lblAddress);

		tfAddress = new JTextField(25);
		GridBagConstraints gbc_tfAddress = new GridBagConstraints();
		gbc_tfAddress.anchor = GridBagConstraints.WEST;
		gbc_tfAddress.insets = new Insets(0, 0, 5, 0);
		gbc_tfAddress.gridx = 4;
		gbc_tfAddress.gridy = 7;
		clientInfoCenter.add(tfAddress, gbc_tfAddress);
		// tfAddress.setColumns(10);

		JLabel lblPostalCode = new JLabel("Postal Code:");
		GridBagConstraints gbc_lblPostalCode = new GridBagConstraints();
		gbc_lblPostalCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostalCode.gridx = 2;
		gbc_lblPostalCode.gridy = 9;
		clientInfoCenter.add(lblPostalCode, gbc_lblPostalCode);

		tfPostalCode = new JTextField(7);
		GridBagConstraints gbc_tfPostalCode = new GridBagConstraints();
		gbc_tfPostalCode.anchor = GridBagConstraints.WEST;
		gbc_tfPostalCode.insets = new Insets(0, 0, 5, 0);
		gbc_tfPostalCode.gridx = 4;
		gbc_tfPostalCode.gridy = 9;
		clientInfoCenter.add(tfPostalCode, gbc_tfPostalCode);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 2;
		gbc_lblPhoneNumber.gridy = 11;
		clientInfoCenter.add(lblPhoneNumber, gbc_lblPhoneNumber);

		tfPhoneNumber = new JTextField(12);
		GridBagConstraints gbc_tfPhoneNumber = new GridBagConstraints();
		gbc_tfPhoneNumber.anchor = GridBagConstraints.WEST;
		gbc_tfPhoneNumber.insets = new Insets(0, 0, 5, 0);
		gbc_tfPhoneNumber.gridx = 4;
		gbc_tfPhoneNumber.gridy = 11;
		clientInfoCenter.add(tfPhoneNumber, gbc_tfPhoneNumber);
		// tfPhoneNumber.setColumns(10);

		JLabel lblClientType = new JLabel("Client Type:");
		GridBagConstraints gbc_lblClientType = new GridBagConstraints();
		gbc_lblClientType.insets = new Insets(0, 0, 0, 5);
		gbc_lblClientType.gridx = 2;
		gbc_lblClientType.gridy = 13;
		clientInfoCenter.add(lblClientType, gbc_lblClientType);

		String[] clientTypeOptions = { "R", "C" };
		comboBox = new JComboBox<String>(clientTypeOptions);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 13;
		clientInfoCenter.add(comboBox, gbc_comboBox);
		contentPaneNoTitle.setDividerLocation(395);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	// Display Messages
	/**
	 * Displays an error message to the user
	 */
	public void displayErrorMessage() {
		JOptionPane.showMessageDialog(null, "You have made an invalid selection or no results have been found.");
	}

	/**
	 * displays a success message to the user
	 */
	public void displaySuccessMessage() {
		JOptionPane.showMessageDialog(null, "The action has been performed successfully.");
	}

	/**
	 * displays a failure message to the user
	 */
	public void displayFailureMessage() {
		JOptionPane.showMessageDialog(null, "The action could not be performed.");
	}

	/**
	 * displays error message that all text fields have not been filled
	 */
	public void displayFillMessage() {
		JOptionPane.showMessageDialog(null, "Please input data into all of the fields.");
	}

	/**
	 * displays error message that phone number format is not correct
	 */
	public void phoneErrorMessage() {
		JOptionPane.showMessageDialog(null, "Phone number must be of format 111-111-1111.");
	}

	/**
	 * displays error message that address is too many characters
	 */
	public void addressErrorMessage() {
		JOptionPane.showMessageDialog(null, "Address must be maximum 50 characters long.");
	}

	/**
	 * displays error message that name is too many characters
	 */
	public void nameErrorMessage() {
		JOptionPane.showMessageDialog(null, "First and Last name must maximum 20 characters long.");
	}

	/**
	 * displays error message that postal code format is incorrect
	 */
	public void postalCodErrorMessage() {
		JOptionPane.showMessageDialog(null, "Postal code must be of format A1A 1A1.");
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	// Action Listeners

	/**
	 * adds action listener to the search button
	 * 
	 * @param listenForSearchButton action listener
	 */
	public void addSearchListener(ActionListener listenForSearchButton) {
		btnSearch.addActionListener(listenForSearchButton);
	}

	/**
	 * adds action listener for the clear search button
	 * 
	 * @param listenForClearSearchButton action listener
	 */
	public void addClearSearchListener(ActionListener listenForClearSearchButton) {
		btnClearSearch.addActionListener(listenForClearSearchButton);
	}

	/**
	 * adds action listener for the list items
	 * 
	 * @param listenForListSelection action listener
	 */
	public void addListListener(ListSelectionListener listenForListSelection) {
		searchResultList.addListSelectionListener(listenForListSelection);
	}

	/**
	 * adds action listener for the save button
	 * 
	 * @param listenForSaveButton action listener
	 */
	public void addSaveListener(ActionListener listenForSaveButton) {
		btnSave.addActionListener(listenForSaveButton);
	}

	/**
	 * adds action listener for the delete button
	 * 
	 * @param listenForDeleteButton action listener
	 */
	public void addDeleteListener(ActionListener listenForDeleteButton) {
		btnDelete.addActionListener(listenForDeleteButton);
	}

	/**
	 * adds action listener for the clear button
	 * 
	 * @param listenForClearButton action listener
	 */
	public void addClearListener(ActionListener listenForClearButton) {
		btnClear.addActionListener(listenForClearButton);
	}

	/**
	 * adds action listener for the add client button
	 * 
	 * @param listenForNewClientButton action listener
	 */
	public void addNewClientListener(ActionListener listenForNewClientButton) {
		btnAddClient.addActionListener(listenForNewClientButton);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	// Getters and setters
	/**
	 * Getter for round selection button
	 * 
	 * @return client id button
	 */
	public JRadioButton getRdbtnClientId() {
		return rdbtnClientId;
	}

	/**
	 * Setter for round selection button
	 * 
	 * @param rdbtnClientId client id button
	 */
	public void setRdbtnClientId(JRadioButton rdbtnClientId) {
		this.rdbtnClientId = rdbtnClientId;
	}

	/**
	 * Getter for round selection button
	 * 
	 * @return last name button
	 */
	public JRadioButton getRdbtnLastName() {
		return rdbtnLastName;
	}

	/**
	 * setter for round selection button
	 * 
	 * @param rdbtnLastName last name button
	 */
	public void setRdbtnLastName(JRadioButton rdbtnLastName) {
		this.rdbtnLastName = rdbtnLastName;
	}

	/**
	 * Getter for round selection button
	 * 
	 * @return client type button
	 */
	public JRadioButton getRdbtnClientType() {
		return rdbtnClientType;
	}

	/**
	 * setter for round selection button
	 * 
	 * @param rdbtnClientType client type button
	 */
	public void setRdbtnClientType(JRadioButton rdbtnClientType) {
		this.rdbtnClientType = rdbtnClientType;
	}

	/**
	 * getter for client search text field
	 * 
	 * @return client search text field
	 */
	public String getClientSearchTextField() {
		return clientSearchTextField.getText();
	}

	/**
	 * getter for search results list
	 * 
	 * @return search results list
	 */
	public JList getSearchResultList() {
		return searchResultList;
	}

	/**
	 * setter fir search results list
	 * 
	 * @param searchResults results list to display
	 */
	public void setSearchResultList(Object[] searchResults) {
		searchResultList.setListData(searchResults);
	}

	/**
	 * getter for search button
	 * 
	 * @return search button
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}

	/**
	 * getter for clear search button
	 * 
	 * @return clear search button
	 */
	public JButton getBtnClearSearch() {
		return btnClearSearch;
	}

	/**
	 * getter for client id text field
	 * 
	 * @return client id text field
	 */
	public JTextField getTfClientId() {
		return tfClientId;
	}

	/**
	 * getter for first name text field
	 * 
	 * @return first name text field
	 */
	public JTextField getTfFirstName() {
		return tfFirstName;
	}

	/**
	 * setter for first name text field
	 * 
	 * @param tfFirstName client first name
	 */
	public void setTfFirstName(JTextField tfFirstName) {
		this.tfFirstName = tfFirstName;
	}

	/**
	 * getter for last name text field
	 * 
	 * @return last name text field
	 */
	public JTextField getTfLastName() {
		return tfLastName;
	}

	/**
	 * setter for last name text field
	 * 
	 * @param tfLastName client last name
	 */
	public void setTfLastName(JTextField tfLastName) {
		this.tfLastName = tfLastName;
	}

	/**
	 * getter for address text field
	 * 
	 * @return address text field
	 */
	public JTextField getTfAddress() {
		return tfAddress;
	}

	/**
	 * setter for address text field
	 * 
	 * @param tfAddress client address
	 */
	public void setTfAddress(JTextField tfAddress) {
		this.tfAddress = tfAddress;
	}

	/**
	 * getter for postal code text field
	 * 
	 * @return postal code text field
	 */
	public JTextField getTfPostalCode() {
		return tfPostalCode;
	}

	/**
	 * setter for postal code text field
	 * 
	 * @param tfPostalCode client postal code
	 */
	public void setTfPostalCode(JTextField tfPostalCode) {
		this.tfPostalCode = tfPostalCode;
	}

	/**
	 * getter for phone number text field
	 * 
	 * @return phone number text field
	 */
	public JTextField getTfPhoneNumber() {
		return tfPhoneNumber;
	}

	/**
	 * setter for phone number text field
	 * 
	 * @param tfPhoneNumber client phone number
	 */
	public void setTfPhoneNumber(JTextField tfPhoneNumber) {
		this.tfPhoneNumber = tfPhoneNumber;
	}

	/**
	 * getter for combo box
	 * 
	 * @return combo box
	 */
	public JComboBox getComboBox() {
		return comboBox;
	}

	/**
	 * getter for add client button
	 * 
	 * @return add client button
	 */
	public JButton getBtnAddClient() {
		return btnAddClient;
	}

	/**
	 * getter for clear text fields button
	 * 
	 * @return clear button
	 */
	public JButton getBtnClear() {
		return btnClear;
	}

	/**
	 * getter for delete client button
	 * 
	 * @return delete button
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * getter for save button
	 * 
	 * @return save button
	 */
	public JButton getBtnSave() {
		return btnSave;
	}

}
