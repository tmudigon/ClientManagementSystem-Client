/**
 * This class is responsible for running the Client side of the application
 * 
 * @author Thanmayee Mudigonda & Sourabh Mokhasi
 *
 */
public class ClientApp {

	/**
	 * Main method for running the client side of the application
	 * @param args
	 */
	public static void main(String[] args) {
		View theView = new View();
		System.out.println("Client created");
		ClientController theClient = new ClientController("localhost", 9090, theView);
		ViewController viewController = new ViewController(theClient, theView);

		theView.setVisible(true);
		theView.pack();
		
		//Getting the action listener count 
		//Below code prints twice, so it means that the action listener is added twice?
		System.out.println("The search button is called: "+theView.getBtnSearch().getActionListeners().length);

		theClient.getServerResponse();
	}
}
