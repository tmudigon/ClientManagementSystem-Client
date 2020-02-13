
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * This class is responsible for creating an object input stream to read in
 * objects that are sent over by the server side
 * 
 * @author Thanmayee Mudigonda & Sourabh Mokhasi
 * 
 */
public class ReadObject {

	private ObjectInputStream in;
	private Message theMessage;

	/**
	 * Constructs a ReadObject instance, which in turn constructs an object input
	 * stream to read in objects from the client's socket
	 * 
	 * @param theClient
	 */
	public ReadObject(Socket theClient) {
		try {
			in = new ObjectInputStream(theClient.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads in the object from the object input stream, and type casts it to the
	 * serializable "Message" object
	 * 
	 * @return the Message object
	 */
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