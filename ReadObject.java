
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReadObject {

	// private Socket theClient;
	private ObjectInputStream in;
	private Message theMessage;

	public ReadObject(Socket theClient) {
		// this.theClient = theClient;
		try {
			in = new ObjectInputStream(theClient.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Message readMessage() {
		try {
			theMessage = (Message) in.readObject();
			// in.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return theMessage;
	}
}