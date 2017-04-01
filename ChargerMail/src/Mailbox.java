import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Creates a mailbox and controls the messages in it. 
 * @author Joanna Pease
 *
 */

public class Mailbox {

	/**
	 * Creates a mailbox
	 * @param Account The current Account address
	 * @param boxName Inbox, Sent, or Trash
	 */
	public Mailbox(String boxName) {
		this.boxName = boxName;
	}
	
	/**
	 * Create a new message to send.
	 */
	public void newMessage() {
		String toAddress;
		String messageText;
		
		input = new Scanner(System.in);
		toAddress = input.nextLine();
		input.next();
		messageText = input.nextLine();
		input.next();
		
		Message newMessage = new Message(toAddress, messageText);
	
	}
	
	/**
	 * Add a message to the queue
	 * @param message
	 */
	public void addMessage(Message message) {
		messageQueue.add(message);
	}
	
	/**
	 * Delete one message.
	 * @param message
	 */
	public void removeMessage(Message message) {
		messageQueue.remove(message);	
	}
	
	/**
	 * Delete all messages.
	 * @return true if emptied, false if not.
	 */
	public boolean eraseAll() {
		messageQueue.clear();
	}
	
	public String getName() {
		return boxName;
	}
	
	/**
	 * Sort messages by date
	 */
	public void sortMessages() {
		Collections.sort(messageQueue);
	}
	
	private ArrayList<Message> messageQueue = new ArrayList<Message>();
	private String boxName;
	private Scanner input;
	
}
