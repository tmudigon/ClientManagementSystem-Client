import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


public class ClientController {

	private Socket aSocket;
	//private PrintWriter socketOut;
	//private BufferedReader socketIn;
	private ReadObject readObject;
	private WriteObject writeObject;
	private View theView;
	private Message theMessage;
	private ViewController viewController;

	public ClientController(String serverName, int portNumber, View theView) {
		this.theView = theView;
		try {
			aSocket = new Socket(serverName, portNumber);
			// Socket input Stream
		//	socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));

			// Socket output Stream
		//	socketOut = new PrintWriter(aSocket.getOutputStream(), true);
			writeObject = new WriteObject(aSocket);
			readObject = new ReadObject(aSocket);
			
			viewController = new ViewController(this,theView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 
	 */
	public void getServerResponse() {
		while(true) {
			theMessage = readObject.readMessage();
			if(theMessage != null) {
				System.out.println("Server response is: " + theMessage.getChoice());
				switchBoard(theMessage.getChoice(),theMessage);
			}
		}
	}
	
	public void sendMessage(Message theMessage) {
		if(theMessage != null) {
			writeObject.sendObject(theMessage);
		} 
	}
	
	/**
	 * This switch Board is only for reading server response
	 * @param choice
	 * @param customerList
	 */
	public void switchBoard(int choice,Message theMessage) {
		switch (choice) { 
		case 1:
			//This case will be triggered after receiving a message from server with choice 1
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
			// Default
	}
	}
}

