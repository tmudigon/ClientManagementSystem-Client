
public class ClientApp {

	public static void main(String[] args) {
		View theView = new View();
		System.out.println("Client created");
		ClientController theClient = new ClientController("localhost", 9090, theView);
		ViewController viewController = new ViewController(theClient, theView);
		
		theView.setVisible(true);
		theView.pack();
		theClient.getServerResponse();
	}
}
