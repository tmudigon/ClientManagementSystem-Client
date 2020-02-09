

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteObject {
	private ObjectOutputStream objectOut = null;
	private Message theMessage;
	private Scanner stdin = null;
	private Scanner textFileIn = null;
	private Socket theClient = null;

	/**
	 * Creates an blank MusicRecord object
	 */
	public WriteObject(Socket theClient) {
		this.theClient = theClient;
		try {
			objectOut = new ObjectOutputStream(theClient.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends the Message object to the client.
	 */
	public void sendObject(Message theMessage) {
		try {
			objectOut.writeObject(theMessage);
			// Reset the buffer everytime an object is written.
			objectOut.reset();
		} catch (IOException e) {
			System.out.println("Error writing object!");
		} catch (NoSuchElementException e) {
			System.out.println("Invalid input!. Please try again!");
		}
	}
}
