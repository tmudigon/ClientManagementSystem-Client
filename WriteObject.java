
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is responsible for creating an object output stream to write
 * objects to the client socket
 * 
 * @author Thanmayee Mudigonda & Sourabh Mokhasi
 * 
 */
public class WriteObject {
	private ObjectOutputStream objectOut;

	/**
	 * Creates an blank WriteObject object
	 */
	public WriteObject(Socket theClient) {
		// this.theClient = theClient;
		try {
			objectOut = new ObjectOutputStream(theClient.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends the Message object to the client, by writing it to the object output
	 * stream on the client socket
	 */
	public void sendObject(Message theMessage) {
		try {
			objectOut.writeObject(theMessage);
			System.out.println("sending object");
			// Reset the buffer every time an object is written.
			//objectOut.reset();
		} catch (IOException e) {
			System.out.println("Error writing object!");
		} catch (NoSuchElementException e) {
			System.out.println("Invalid input!. Please try again!");
		}
	}
}
