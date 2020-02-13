import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * This class is responsible for setting up the socket connection and
 * communication between the client and the server
 * 
 * @author Thanmayee Mudigonda & Sourabh Mokhasi
 *
 */
public class ClientController {

	private Socket aSocket;
	private ReadObject readObject;
	private WriteObject writeObject;
	private View theView;
	private Message theMessage;
	private ViewController viewController;

	/**
	 * Constructs a ClientController instance
	 * 
	 * @param serverName
	 * @param portNumber
	 * @param theView
	 */
	public ClientController(String serverName, int portNumber, View theView) {
		this.theView = theView;
		try {
			aSocket = new Socket(serverName, portNumber);
			// Socket output Stream
			writeObject = new WriteObject(aSocket);
			// Socket input stream
			readObject = new ReadObject(aSocket);
			viewController = new ViewController(this, theView);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is a method that runs continuously and reads from the input stream of
	 * the socket. As soon as there is an object in the socket, this method parses
	 * and sends it over to the switch board
	 */
	public void getServerResponse() {
		while (true) {
			theMessage = readObject.readMessage();
			if (theMessage != null) {
				System.out.println("Server response is: " + theMessage.getChoice());
				switchBoard(theMessage.getChoice(), theMessage);
			}
		}
	}

	public void sendMessage(Message theMessage) {
		if (theMessage != null) {
			writeObject.sendObject(theMessage);
		}
	}

	/**
	 * This switch board receives the server response and updates the client view
	 * with the response
	 * 
	 * @param choice
	 * @param customerList
	 */
	public void switchBoard(int choice, Message theMessage) {
		switch (choice) {
		case 1:
			// This case will be triggered after receiving a message from server with choice
			// 1
			// search by ID
			viewController.addToListModel(theMessage.getCustomerList());
			break;
		case 2:
			// search by Name
			viewController.addToListModel(theMessage.getCustomerList());
			break;
		case 3:
			// search by type
			viewController.addToListModel(theMessage.getCustomerList());
			break;
		case 4:
			// add new customer
			theView.displayMessage(theMessage.getData());
			break;
		case 5:
			// Update customer
			theView.displayMessage(theMessage.getData());
			break;
		case 6:
			// Delete customer
			theView.displayMessage(theMessage.getData());
			break;
		default:
			System.out.println("Invalid choice");
			// Default
		}
	}
}
